define([
  'baja!',
  'baja!gx:Brush,gx:Color,gx:Font',
  'baja!control:BooleanWritable',
  'baja!myFirstModule:SizeEnum,myFirstModule:ToggleStyleEnum',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'lex!myFirstModule',
  'css!nmodule/myFirstModule/rc/booleanToggleWidget',

], function (
  baja,
  gx,
  controlTypes,
  enums,
  Widget,
  subscriberMixIn,
  lexicons
) {
  'use strict';

  const [myFirstModuleLexicon] = lexicons;

  return class BooleanToggleWidget extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          moduleName: 'myFirstModule',
          keyName: 'BooleanToggleWidget',
          properties: {
            onColor: baja.$('gx:Brush', '#4CAF50'),
            offColor: baja.$('gx:Brush', '#ccc'),
            knobColor: baja.$('gx:Brush', '#fff'),
            size: baja.$('myFirstModule:SizeEnum', 'medium'),
            showLabels: true,
            onLabel: myFirstModuleLexicon.getSafe('booleanToggleWidget.onLabel'),
            offLabel: myFirstModuleLexicon.getSafe('booleanToggleWidget.offLabel'),
            toggleStyle: baja.$('myFirstModule:ToggleStyleEnum', 'rounded'),
            disabled: false,
            font: baja.$('gx:Font', 'null'),
            textColor: baja.$('gx:Color', '#333')
          }
        }
      });

      subscriberMixIn(this);

      this.widgetId = this.generateRandomId(8);
      this.$toggleContainer = null;
      this.$toggleSwitch = null;
      this.$toggleKnob = null;
      this.$onLabel = null;
      this.$offLabel = null;
      this.isToggling = false;
      this.currentState = false;
      this.subscriberFunction = null;

      // Store the subscriber function for later reattachment
      const that = this;
      this.subscriberFunction = function () {
        if (that.value()) {
          that.$updateDom(that.value());
        }
      };

      this.getSubscriber().attach('changed', this.subscriberFunction);
    }

    generateRandomId(length) {
      const chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
      let result = 'toggle_';
      for (let i = length; i > 0; --i) {
        result += chars[Math.round(Math.random() * (chars.length - 1))];
      }
      return result;
    }

    doInitialize(dom) {
      const props = this.properties();
      const showLabels = props.getValue('showLabels');
      const onLabel = props.getValue('onLabel');
      const offLabel = props.getValue('offLabel');

      // Better enum handling with fallbacks
      let toggleStyle = 'rounded';
      let size = 'medium';

      try {
        const toggleStyleEnum = props.getValue('toggleStyle');
        toggleStyle = toggleStyleEnum ? toggleStyleEnum.toString().toLowerCase() : 'rounded';
        console.log('Toggle style:', toggleStyle);
      } catch (e) {
        console.warn('Error getting toggleStyle:', e);
      }

      try {
        const sizeEnum = props.getValue('size');
        size = sizeEnum ? sizeEnum.toString().toLowerCase() : 'medium';
        console.log('Size:', size);
      } catch (e) {
        console.warn('Error getting size:', e);
      }

      let html = `<div id="${this.widgetId}" class="boolean-toggle-container ${toggleStyle} ${size}">`;

      if (showLabels) {
        html += '<div class="toggle-labels">';
        html += `<span class="toggle-label off-label">${offLabel}</span>`;
        html += '<div class="toggle-switch-wrapper">';
      }

      // Create toggle switch structure
      html += '<div class="toggle-switch">';
      html += '<div class="toggle-track"></div>';
      html += '<div class="toggle-knob"></div>';
      html += '</div>';

      if (showLabels) {
        html += '</div>';
        html += `<span class="toggle-label on-label">${onLabel}</span>`;
        html += '</div>';
      }

      html += '</div>';

      console.log('Generated HTML:', html); // Debug output

      dom.html(html);

      // Get references to DOM elements
      this.$toggleContainer = dom.find(`#${this.widgetId}`);
      this.$toggleSwitch = dom.find('.toggle-switch');
      this.$toggleKnob = dom.find('.toggle-knob');
      this.$onLabel = showLabels ? dom.find('.on-label') : null;
      this.$offLabel = showLabels ? dom.find('.off-label') : null;

      this.setupEventHandlers();
      this.applyTextStyling();
      this.applySwitchStyling();
      this.validatePointType();
    }

    validatePointType() {
      // Check if the bound point can handle boolean values
      const point = this.value();
      if (point && point.getType) {
        const pointType = point.getType();

        // Check if it's writable (has setFallback method)
        if (!point.setFallback) {
          console.warn('BooleanToggleWidget: Bound point is not writable. Widget may not function correctly.');
          this.showError('Point is not writable');
        }

        // Note: Removed strict BooleanWritable check - let's allow any writable point
      }
    }

    showError(message) {
      if (this.$toggleContainer) {
        this.$toggleContainer.addClass('error-state');
        this.$toggleContainer.attr('title', `Error: ${message}`);
      }
    }

    setupEventHandlers() {
      if (!this.$toggleSwitch || !this.$toggleSwitch[0]) return;

      const toggleElement = this.$toggleSwitch[0];
      let clickStartTime = 0;

      // Prevent double-clicking issues
      const handleToggleClick = (e) => {
        e.preventDefault();
        e.stopPropagation();

        const now = Date.now();
        if (this.isToggling || (now - clickStartTime) < 200) {
          return;
        }

        clickStartTime = now;

        if (this.properties().getValue('disabled')) {
          return;
        }

        this.performToggle();
      };

      // Mouse events
      toggleElement.addEventListener('click', handleToggleClick);

      // Touch events for mobile
      toggleElement.addEventListener('touchend', (e) => {
        e.preventDefault();
        handleToggleClick(e);
      });

      // Keyboard support
      toggleElement.addEventListener('keydown', (e) => {
        if (e.key === 'Enter' || e.key === ' ') {
          e.preventDefault();
          handleToggleClick(e);
        }
      });

      // Focus support for accessibility
      toggleElement.setAttribute('tabindex', '0');
      toggleElement.setAttribute('role', 'switch');
    }

    performToggle() {
      if (this.isToggling) return;

      this.isToggling = true;

      // Temporarily detach subscriber to prevent conflicts
      this.getSubscriber().detach('changed', this.subscriberFunction);

      const newState = !this.currentState;

      // Immediate visual feedback
      this.updateToggleState(newState, true);

      // Send command to point
      this.writeToggleToPoint(newState)
        .then(() => {
          console.log('Toggle command successful:', newState);
        })
        .catch((error) => {
          console.error('Toggle command failed:', error);
          // Revert visual state on error
          this.updateToggleState(this.currentState, false);
        })
        .finally(() => {
          this.isToggling = false;

          // Reattach subscriber after brief delay for smoother transitions
          setTimeout(() => {
            this.getSubscriber().attach('changed', this.subscriberFunction);
          }, 50);
        });
    }

    updateToggleState(state, isUserAction = false) {
      this.currentState = state;

      if (this.$toggleContainer) {
        if (state) {
          this.$toggleContainer.addClass('on').removeClass('off');
        } else {
          this.$toggleContainer.addClass('off').removeClass('on');
        }
      }

      // Update ARIA attributes for accessibility
      if (this.$toggleSwitch && this.$toggleSwitch[0]) {
        this.$toggleSwitch[0].setAttribute('aria-checked', state.toString());
      }

      // Update label highlighting
      if (this.$onLabel && this.$offLabel) {
        if (state) {
          this.$onLabel.addClass('active');
          this.$offLabel.removeClass('active');
        } else {
          this.$onLabel.removeClass('active');
          this.$offLabel.addClass('active');
        }
      }
    }

    doLoad(value) {
      this.$updateDom(value);
    }

    $updateDom(value) {
      if (!value || this.isToggling) return;

      try {
        const out = value.getOut();
        const booleanValue = out.getValue();

        // Convert to boolean if needed
        const state = booleanValue === true || booleanValue === 'true' || booleanValue === 1;

        this.updateToggleState(state, false);
      } catch (error) {
        console.error('Error updating toggle state:', error);
      }
    }

    writeToggleToPoint(state) {
      const point = this.value();
      if (!point) {
        return Promise.reject('No point bound to widget');
      }

      try {
        // Use the same pattern as the slider - write to setFallback
        const booleanValue = baja.$('baja:StatusBoolean', {
          status: baja.Status.ok,
          value: state
        });

        point.setFallback(booleanValue);
        return Promise.resolve();
      } catch (error) {
        return Promise.reject(`Failed to write boolean value: ${error.message}`);
      }
    }

    applyTextStyling() {
      const props = this.properties();
      const textColor = this.getColorValue(props.getValue('textColor'), '#333');
      const font = props.getValue('font');

      const fontInfo = this.parseFontProperty(font);

      const textCSS = `
        #${this.widgetId} .toggle-label {
          font-size: ${fontInfo.size} !important;
          color: ${textColor} !important;
          font-weight: ${fontInfo.weight} !important;
          font-family: ${fontInfo.family} !important;
        }
      `;

      this.addStyleTag('text', textCSS);
    }

    applySwitchStyling() {
      const props = this.properties();
      const onColor = this.getColorValue(props.getValue('onColor'), '#4CAF50');
      const offColor = this.getColorValue(props.getValue('offColor'), '#ccc');
      const knobColor = this.getColorValue(props.getValue('knobColor'), '#fff');

      const switchCSS = `
        #${this.widgetId}.on .toggle-track {
          background-color: ${onColor} !important;
        }
        #${this.widgetId}.off .toggle-track {
          background-color: ${offColor} !important;
        }
        #${this.widgetId} .toggle-knob {
          background-color: ${knobColor} !important;
        }
        #${this.widgetId}.on .toggle-label.on-label {
          color: ${onColor} !important;
          font-weight: bold !important;
        }
        #${this.widgetId}.off .toggle-label.off-label {
          color: ${offColor} !important;
          font-weight: bold !important;
        }
      `;

      this.addStyleTag('switch', switchCSS);
    }

    addStyleTag(type, css) {
      const existingStyle = document.getElementById(`${this.widgetId}-${type}-style`);
      if (existingStyle) {
        existingStyle.remove();
      }

      const styleTag = document.createElement('style');
      styleTag.id = `${this.widgetId}-${type}-style`;
      styleTag.innerHTML = css;
      document.head.appendChild(styleTag);
    }

    parseFontProperty(font) {
      let fontFamily = 'Arial';
      let fontSize = '14px';
      let fontWeight = 'normal';

      if (font && typeof font.toString === 'function') {
        const fontStr = font.toString().trim();

        if (fontStr === 'null' || fontStr === '') {
          return { family: fontFamily, size: fontSize, weight: fontWeight };
        }

        const parts = fontStr.split(/\s+/);

        let weightPart = null;
        let sizePart = null;
        let familyParts = [];

        for (const part of parts) {
          if (part === 'bold' || part === 'normal' || part === 'italic') {
            weightPart = part;
          } else if (part.match(/^\d+pt$/)) {
            sizePart = part;
          } else {
            familyParts.push(part);
          }
        }

        if (weightPart === 'bold') {
          fontWeight = 'bold';
        }

        if (sizePart) {
          const ptSize = parseInt(sizePart.replace('pt', ''));
          fontSize = Math.round(ptSize * 4/3) + 'px';
        }

        if (familyParts.length > 0) {
          fontFamily = familyParts.join(' ');
        }
      }

      return {
        family: fontFamily,
        size: fontSize,
        weight: fontWeight
      };
    }

    getColorValue(colorValue, defaultColor) {
      if (!colorValue) return defaultColor;

      if (typeof colorValue.toHexString === 'function') {
        return colorValue.toHexString();
      } else if (typeof colorValue.toString === 'function') {
        const colorStr = colorValue.toString();

        if (colorStr.startsWith('#') ||
            colorStr.startsWith('rgb(') ||
            colorStr.startsWith('rgba(') ||
            colorStr.startsWith('hsl(') ||
            colorStr.match(/^[a-zA-Z]+$/)) {
          return colorStr;
        }
      } else if (typeof colorValue === 'string') {
        return colorValue;
      }

      return defaultColor;
    }

    doChanged() {
      const props = this.properties();

      const needsReinit = props.isChanged('showLabels') ||
                         props.isChanged('onLabel') ||
                         props.isChanged('offLabel') ||
                         props.isChanged('toggleStyle') ||
                         props.isChanged('size');

      const needsTextRestyling = props.isChanged('textColor') ||
                                 props.isChanged('font');

      const needsSwitchRestyling = props.isChanged('onColor') ||
                                  props.isChanged('offColor') ||
                                  props.isChanged('knobColor');

      if (needsReinit) {
        // Preserve current state during reinit
        const currentState = this.currentState;
        this.doInitialize(this.getDom());

        // Restore state after reinit
        if (currentState !== null) {
          this.updateToggleState(currentState, false);
        }
      } else {
        if (needsTextRestyling) {
          this.applyTextStyling();
        }
        if (needsSwitchRestyling) {
          this.applySwitchStyling();
        }
      }

      // Handle disabled state
      if (props.isChanged('disabled')) {
        const disabled = props.getValue('disabled');
        if (this.$toggleContainer) {
          if (disabled) {
            this.$toggleContainer.addClass('disabled');
            if (this.$toggleSwitch && this.$toggleSwitch[0]) {
              this.$toggleSwitch[0].setAttribute('aria-disabled', 'true');
            }
          } else {
            this.$toggleContainer.removeClass('disabled');
            if (this.$toggleSwitch && this.$toggleSwitch[0]) {
              this.$toggleSwitch[0].removeAttribute('aria-disabled');
            }
          }
        }
      }
    }

    doDestroy() {
      // Ensure subscriber is detached properly
      if (this.subscriberFunction) {
        this.getSubscriber().detach('changed', this.subscriberFunction);
        this.subscriberFunction = null;
      }

      // Remove event listeners (they'll be cleaned up with DOM removal)

      // Remove style tags
      const textStyle = document.getElementById(`${this.widgetId}-text-style`);
      if (textStyle) {
        textStyle.remove();
      }

      const switchStyle = document.getElementById(`${this.widgetId}-switch-style`);
      if (switchStyle) {
        switchStyle.remove();
      }

      return super.doDestroy();
    }
  };
});
define([
  'baja!',
  'baja!gx:Brush,gx:Color,gx:Font',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'lex!myFirstModule',
  'nmodule/webEditors/rc/wb/ActionFirer',
  'css!nmodule/myFirstModule/rc/pointLabelWidget'
], function (
  baja,
  gx,
  Widget,
  subscriberMixIn,
  lexicons,
  ActionFirer
) {
  'use strict';

  const [myFirstModuleLexicon] = lexicons;

  return class PointLabelWidget extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          moduleName: 'myFirstModule',
          keyName: 'PointLabelWidget',
          properties: {
            showStatus: true,
            backgroundColor: baja.$('gx:Brush', '#ffffff'),
            textColor: baja.$('gx:Color', '#333333'),
            valueColor: baja.$('gx:Color', '#28a745'),
            valueFont: baja.$('gx:Font', 'null'),
            customLabel: ''
          }
        }
      });

      subscriberMixIn(this);

      this.widgetId = this.generateRandomId();
      this.currentPoint = null;
      this.$container = null;
      this.$valueDisplay = null;
      this.$nameDisplay = null;
      this.subscriberFunction = null;

      // Store the subscriber function for later reattachment
      const that = this;
      this.subscriberFunction = function(prop) {
        if (prop.getName() === 'out') {
          that.updateDisplay();
        }
      };
    }

    generateRandomId() {
      return 'point-label-' + Math.random().toString(36).substr(2, 9);
    }

    doInitialize(dom) {
      const props = this.properties();
      const showStatus = props.getValue('showStatus');
      const customLabel = props.getValue('customLabel');

      const html = `
        <div id="${this.widgetId}" class="point-label-widget">
          <div class="point-header">
            <h3 class="point-name">${customLabel || myFirstModuleLexicon.getSafe('pointLabelWidget.status.loading')}</h3>
          </div>
          <div class="point-value-container">
            <span class="point-value">--</span>
          </div>
          ${showStatus ? '<div class="point-status"></div>' : ''}
        </div>
      `;

      dom.html(html);

      this.$container = dom.find(`#${this.widgetId}`);
      this.$valueDisplay = this.$container.find('.point-value');
      this.$nameDisplay = this.$container.find('.point-name');
      this.$statusDisplay = this.$container.find('.point-status');

      this.applyBackgroundStyling();
      this.applyTextStyling();
      this.applyValueStyling();
    }

    doLoad(value) {
      if (!value) {
        this.showError(myFirstModuleLexicon.getSafe('pointLabelWidget.errors.pointNotFound'));
        return;
      }

      this.currentPoint = value;
      this.updateDisplayLabel();
      this.setupSubscription();
      this.updateDisplay();
      this.setupRightClickActions();
    }

    updateDisplayLabel() {
      const customLabel = this.properties().getValue('customLabel');
      if (customLabel) {
        this.$nameDisplay.text(customLabel);
      } else if (this.currentPoint) {
        this.$nameDisplay.text(this.getPointName());
      }
    }

    getPointName() {
      try {
        return this.currentPoint.getDisplayName() ||
               this.currentPoint.getName() ||
               myFirstModuleLexicon.getSafe('pointLabelWidget.status.unknown');
      } catch (e) {
        return myFirstModuleLexicon.getSafe('pointLabelWidget.status.unknown');
      }
    }

    setupSubscription() {
      if (!this.currentPoint) return;

      try {
        const subscriber = this.getSubscriber();
        subscriber.unsubscribeAll();

        subscriber.attach('changed', this.subscriberFunction);
        subscriber.subscribe(this.currentPoint);

      } catch (error) {
        console.error('Error setting up subscription:', error);
      }
    }

    updateDisplay() {
      if (!this.currentPoint || !this.$valueDisplay) return;

      try {
        const out = this.currentPoint.getOut();
        const status = out.getStatus();

        this.updateValueDisplay(out);
        this.updateStatusDisplay(status);

      } catch (error) {
        console.error('Error updating display:', error);
        this.$valueDisplay.text(myFirstModuleLexicon.getSafe('pointLabelWidget.status.error'));
      }
    }

    updateValueDisplay(out) {
      if (!this.$valueDisplay || !out) return;

      try {
        // Use getValueDisplay() which handles formatting and units automatically
        const displayValue = out.getValueDisplay();
        this.$valueDisplay.text(displayValue || '--');
      } catch (error) {
        console.error('Error getting value display:', error);
        this.$valueDisplay.text('--');
      }
    }

    updateStatusDisplay(status) {
      if (!status) return;

      this.$container.removeClass('status-ok status-fault status-down status-disabled status-unacked-alarm');

      if (status.isOk()) {
        this.$container.addClass('status-ok');
      } else if (status.isFault()) {
        this.$container.addClass('status-fault');
      } else if (status.isDown()) {
        this.$container.addClass('status-down');
      } else if (status.isDisabled()) {
        this.$container.addClass('status-disabled');
      } else if (status.isUnackedAlarm()) {
        this.$container.addClass('status-unacked-alarm');
      }

      if (this.$statusDisplay && this.$statusDisplay.length) {
        if (status.isOk()) {
          this.$statusDisplay.text(`${myFirstModuleLexicon.getSafe('pointLabelWidget.labels.status')}: ${myFirstModuleLexicon.getSafe('pointLabelWidget.status.ok')}`);
        } else {
          this.$statusDisplay.text(`${myFirstModuleLexicon.getSafe('pointLabelWidget.labels.status')}: ${status.toString()}`);
        }
      }
    }

    setupRightClickActions() {
      if (!this.currentPoint) return;

      const that = this;
      this.$container.on('contextmenu', function(event) {
        event.preventDefault();

        try {
          const hasActionsToDisplay = that.currentPoint &&
                                     that.currentPoint.getSlots().actions().filter(that.isActionVisible).toArray().length > 0;

          if (hasActionsToDisplay) {
            ActionFirer.showActionDialog(that.currentPoint);
          }

        } catch (error) {
          console.error('Right-click menu error:', error);
        }
      });
    }

    isActionVisible(slot) {
      return !(slot.getFlags() & baja.Flags.HIDDEN);
    }

    showError(message) {
      console.error(message);
      alert(message);
    }

    applyBackgroundStyling() {
      const props = this.properties();
      const backgroundColor = this.getColorValue(props.getValue('backgroundColor'), '#ffffff');

      const backgroundCSS = `
        #${this.widgetId} {
          background-color: ${backgroundColor} !important;
        }
      `;

      this.addStyleTag('background', backgroundCSS);
    }

    applyTextStyling() {
      const props = this.properties();
      const textColor = this.getColorValue(props.getValue('textColor'), '#333333');

      const textCSS = `
        #${this.widgetId} .point-name {
          color: ${textColor} !important;
        }
      `;

      this.addStyleTag('text', textCSS);
    }

    applyValueStyling() {
      const props = this.properties();
      const valueColor = this.getColorValue(props.getValue('valueColor'), '#28a745');
      const font = props.getValue('valueFont');

      const fontInfo = this.parseFontProperty(font);

      const valueCSS = `
        #${this.widgetId} .point-value {
          color: ${valueColor} !important;
          font-size: ${fontInfo.size} !important;
          font-weight: ${fontInfo.weight} !important;
          font-family: ${fontInfo.family} !important;
        }
      `;

      this.addStyleTag('value', valueCSS);
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

      const needsReinit = props.isChanged('showStatus') ||
                         props.isChanged('customLabel');

      const needsBackgroundRestyling = props.isChanged('backgroundColor');

      const needsTextRestyling = props.isChanged('textColor');

      const needsValueRestyling = props.isChanged('valueColor') ||
                                 props.isChanged('valueFont');

      if (needsReinit) {
        // Preserve current state during reinit
        const currentPoint = this.currentPoint;
        this.doInitialize(this.getDom());

        // Restore point and setup after reinit
        if (currentPoint) {
          this.currentPoint = currentPoint;
          this.setupSubscription();
          this.updateDisplay();
          this.setupRightClickActions();
        }
      } else {
        if (needsBackgroundRestyling) {
          this.applyBackgroundStyling();
        }
        if (needsTextRestyling) {
          this.applyTextStyling();
        }
        if (needsValueRestyling) {
          this.applyValueStyling();
        }
      }
    }

    doDestroy() {
      // Ensure subscriber is detached properly
      if (this.subscriberFunction) {
        this.getSubscriber().detach('changed', this.subscriberFunction);
        this.subscriberFunction = null;
      }

      // Remove style tags
      const backgroundStyle = document.getElementById(`${this.widgetId}-background-style`);
      if (backgroundStyle) {
        backgroundStyle.remove();
      }

      const textStyle = document.getElementById(`${this.widgetId}-text-style`);
      if (textStyle) {
        textStyle.remove();
      }

      const valueStyle = document.getElementById(`${this.widgetId}-value-style`);
      if (valueStyle) {
        valueStyle.remove();
      }

      this.currentPoint = null;
    }
  };
});
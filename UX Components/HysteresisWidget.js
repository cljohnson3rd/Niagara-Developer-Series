define([
  'baja!',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'Promise',
  'css!nmodule/myFirstModule/rc/hysteresisWidget'
], function (
  baja,
  Widget,
  subscriberMixIn,
  Promise
) {
  'use strict';

  return class HysteresisWidget extends Widget {

    constructor() {
      super();
      subscriberMixIn(this);
      this.$hysteresis = null;
      this.$editingSetpoints = false; // Track if user is editing setpoints
    }

    doInitialize(dom) {
      dom.html(`
        <div class="hysteresis-widget">

          <div class="hysteresis-header">
            <h2 class="hysteresis-title">🌡️ Hysteresis Control</h2>
            <div class="action-indicator">
              <span class="action-badge">Direct Action</span>
            </div>
          </div>

          <div class="status-grid">

            <div class="status-card input-card">
              <div class="status-label">INPUT VALUE</div>
              <div class="input-value status-value">--</div>
              <div class="input-status status-info">Status: --</div>
            </div>

            <div class="status-card on-sp-card">
              <div class="status-label">ON SETPOINT</div>
              <div class="on-sp-value status-value">--</div>
              <div class="on-sp-status status-info">Status: --</div>
            </div>

            <div class="status-card off-sp-card">
              <div class="status-label">OFF SETPOINT</div>
              <div class="off-sp-value status-value">--</div>
              <div class="off-sp-status status-info">Status: --</div>
            </div>

            <div class="status-card output-card">
              <div class="status-label">OUTPUT</div>
              <div class="output-indicator">
                <div class="output-light"></div>
                <span class="output-text">OFF</span>
              </div>
            </div>
          </div>

          <div class="controls-section">
            <h3 class="controls-title">Setpoint Configuration</h3>

            <div class="control-grid">
              <div>
                <label class="control-label">On Setpoint</label>
                <input type="number" class="on-sp-input control-input" step="0.1" />
              </div>
              <div>
                <label class="control-label">Off Setpoint</label>
                <input type="number" class="off-sp-input control-input" step="0.1" />
              </div>
            </div>

            <div class="button-group">
              <button type="button" class="update-setpoints btn primary">Update Setpoints</button>
            </div>
          </div>

          <div class="logic-info">
            <div class="logic-description">
              <strong>Hysteresis Logic:</strong> <span class="logic-text">Waiting for component...</span>
            </div>
          </div>
        </div>
      `);

      this.setupEventHandlers(dom);
    }

    doLoad(value) {
      if (value && value.getType && value.getType().is('myFirstModule:Hysteresis')) {
        this.$hysteresis = value;
        this.$editingSetpoints = false; // Ensure clean state
        this.setupSubscription();
        this.refreshData(this.jq());
        return Promise.resolve();
      } else {
        this.jq().find('.logic-text').text('No hysteresis component attached');
        return Promise.resolve();
      }
    }

    setupEventHandlers(dom) {
      const self = this;

      // Setpoint update button
      dom.find('.update-setpoints').on('click', function() {
        self.updateSetpoints(dom);
      });

      // Track when user is editing setpoints to prevent overwrites
      dom.find('.on-sp-input, .off-sp-input').on('focus', function() {
        self.$editingSetpoints = true;
      });

      dom.find('.on-sp-input, .off-sp-input').on('blur', function() {
        // Small delay to allow for tab between fields
        setTimeout(function() {
          if (!dom.find('.on-sp-input, .off-sp-input').is(':focus')) {
            self.$editingSetpoints = false;
          }
        }, 100);
      });

      // Prevent Enter key from submitting and losing focus accidentally
      dom.find('.on-sp-input, .off-sp-input').on('keypress', function(e) {
        if (e.which === 13) { // Enter key
          e.preventDefault();
          $(this).blur(); // Remove focus
          self.updateSetpoints(dom); // Trigger update
        }
      });
    }

    setupSubscription() {
      const self = this;

      // Debounce refreshData to prevent rapid successive calls
      let refreshTimeout = null;

      this.getSubscriber().attach('changed', function (property) {
        if (['input', 'onSp', 'offSp', 'out', 'tstatAction'].includes(property.getName())) {
          // Clear existing timeout and set new one
          if (refreshTimeout) {
            clearTimeout(refreshTimeout);
          }
          refreshTimeout = setTimeout(function() {
            self.refreshData(self.jq());
            refreshTimeout = null;
          }, 100); // 100ms debounce
        }
      });
    }

    updateSetpoints(dom) {
      if (!this.$hysteresis) {
        alert('Error: Component not loaded');
        return;
      }

      const onSpValue = parseFloat(dom.find('.on-sp-input').val());
      const offSpValue = parseFloat(dom.find('.off-sp-input').val());

      if (isNaN(onSpValue) || isNaN(offSpValue)) {
        alert('Please enter valid numeric values for setpoints');
        return;
      }

      try {
        // Create StatusNumeric objects with values
        const onSpStatusNumeric = baja.$('baja:StatusNumeric');
        const offSpStatusNumeric = baja.$('baja:StatusNumeric');

        onSpStatusNumeric.setValue(onSpValue);
        offSpStatusNumeric.setValue(offSpValue);

        // Set values on component
        this.$hysteresis.set({slot: 'onSp', value: onSpStatusNumeric});
        this.$hysteresis.set({slot: 'offSp', value: offSpStatusNumeric});

        // Clear editing state and remove focus
        this.$editingSetpoints = false;
        dom.find('.on-sp-input, .off-sp-input').blur();

        // Refresh data after a brief delay
        setTimeout(() => this.refreshData(dom), 200);

      } catch (err) {
        alert('Error updating setpoints: ' + err.message);
      }
    }

    refreshData(dom) {
      if (!this.$hysteresis) return;

      try {
        const input = this.$hysteresis.get('input');
        const onSp = this.$hysteresis.get('onSp');
        const offSp = this.$hysteresis.get('offSp');
        const output = this.$hysteresis.get('out');
        const tstatAction = this.$hysteresis.get('tstatAction');

        // Update all display values
        this.updateValueDisplay(dom, '.input-value', '.input-status', input);
        this.updateValueDisplay(dom, '.on-sp-value', '.on-sp-status', onSp);
        this.updateValueDisplay(dom, '.off-sp-value', '.off-sp-status', offSp);

        // Update output indicator
        const isOutputOn = output && output.getValue();
        const outputLight = dom.find('.output-light');
        const outputText = dom.find('.output-text');

        if (isOutputOn) {
          outputLight.removeClass('off').addClass('on');
          outputText.text('ON').removeClass('off').addClass('on');
        } else {
          outputLight.removeClass('on').addClass('off');
          outputText.text('OFF').removeClass('on').addClass('off');
        }

        // Update action indicator
        const actionBadge = dom.find('.action-badge');
        if (tstatAction) {
          actionBadge.text('Direct Action').removeClass('reverse').addClass('direct');
        } else {
          actionBadge.text('Reverse Action').removeClass('direct').addClass('reverse');
        }

        // Update input fields with current setpoints (ONLY if not editing)
        const onSpInput = dom.find('.on-sp-input');
        const offSpInput = dom.find('.off-sp-input');

        // Strong protection: Don't update inputs if user is editing OR if either field has focus
        if (!this.$editingSetpoints && !onSpInput.is(':focus') && !offSpInput.is(':focus')) {
          if (onSp && onSp.getStatus().isValid()) {
            const currentOnSpValue = onSpInput.val();
            const newOnSpValue = onSp.getValue().toFixed(1);
            // Only update if value actually changed to avoid disrupting typing
            if (currentOnSpValue !== newOnSpValue) {
              onSpInput.val(newOnSpValue);
            }
          }
          if (offSp && offSp.getStatus().isValid()) {
            const currentOffSpValue = offSpInput.val();
            const newOffSpValue = offSp.getValue().toFixed(1);
            // Only update if value actually changed to avoid disrupting typing
            if (currentOffSpValue !== newOffSpValue) {
              offSpInput.val(newOffSpValue);
            }
          }
        }

        // Update logic description
        this.updateLogicDescription(dom, onSp, offSp, tstatAction);

      } catch (err) {
        console.error('Error refreshing data:', err);
      }
    }

    updateValueDisplay(dom, valueSelector, statusSelector, statusNumeric) {
      const valueEl = dom.find(valueSelector);
      const statusEl = dom.find(statusSelector);

      if (statusNumeric && statusNumeric.getStatus().isValid()) {
        valueEl.text(statusNumeric.getValue().toFixed(1));
        statusEl.text('Status: OK').removeClass('invalid').addClass('valid');
      } else {
        valueEl.text('--');
        statusEl.text('Status: Invalid').removeClass('valid').addClass('invalid');
      }
    }

    updateLogicDescription(dom, onSp, offSp, tstatAction) {
      const logicEl = dom.find('.logic-text');

      if (onSp && offSp && onSp.getStatus().isValid() && offSp.getStatus().isValid()) {
        const onVal = onSp.getValue();
        const offVal = offSp.getValue();
        const action = tstatAction ? 'Direct' : 'Reverse';

        if (onVal > offVal) {
          logicEl.html(`<strong>${action}</strong> - Output turns ON when input ≥ ${onVal.toFixed(1)}, turns OFF when input ≤ ${offVal.toFixed(1)}`);
        } else {
          logicEl.html(`<strong>${action}</strong> - Output turns ON when input ≤ ${onVal.toFixed(1)}, turns OFF when input ≥ ${offVal.toFixed(1)}`);
        }
      } else {
        logicEl.text('Configure valid setpoints to see logic description');
      }
    }

    doDestroy() {
      if (this.$hysteresis) {
        this.$hysteresis = null;
      }
    }
  };
});
package com.devseries.myFirstModule.hvac;

import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "facets", type = "BFacets", defaultValue = "BFacets.makeBoolean()")
@NiagaraProperty(name = "input", type = "BStatusNumeric", defaultValue = "new BStatusNumeric(0, BStatus.nullStatus)", flags = Flags.SUMMARY)
@NiagaraProperty(name = "onSp", type = "BStatusNumeric", defaultValue = "new BStatusNumeric(0, BStatus.nullStatus)", flags = Flags.SUMMARY)
@NiagaraProperty(name = "offSp", type = "BStatusNumeric", defaultValue = "new BStatusNumeric(0, BStatus.nullStatus)", flags = Flags.SUMMARY)
@NiagaraProperty(name = "tstatAction", type = "BBoolean", defaultValue = "BBoolean.FALSE", facets = {@Facet(name = "BFacets.TRUE_TEXT", value = "\"Direct\""), @Facet(name = "BFacets.FALSE_TEXT", value = "\"Reverse\"")}, flags = Flags.SUMMARY|Flags.READONLY)
@NiagaraProperty(name = "out", type = "BStatusBoolean", defaultValue = "new BStatusBoolean(false)", flags = Flags.SUMMARY|Flags.READONLY)

public class BHysteresis extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.hvac.BHysteresis(1072255673)1.0$ @*/
/* Generated Mon May 26 11:57:10 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "facets"

  /**
   * Slot for the {@code facets} property.
   * @see #getFacets
   * @see #setFacets
   */
  public static final Property facets = newProperty(0, BFacets.makeBoolean(), null);

  /**
   * Get the {@code facets} property.
   * @see #facets
   */
  public BFacets getFacets() { return (BFacets)get(facets); }

  /**
   * Set the {@code facets} property.
   * @see #facets
   */
  public void setFacets(BFacets v) { set(facets, v, null); }

  //endregion Property "facets"

  //region Property "input"

  /**
   * Slot for the {@code input} property.
   * @see #getInput
   * @see #setInput
   */
  public static final Property input = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.nullStatus), null);

  /**
   * Get the {@code input} property.
   * @see #input
   */
  public BStatusNumeric getInput() { return (BStatusNumeric)get(input); }

  /**
   * Set the {@code input} property.
   * @see #input
   */
  public void setInput(BStatusNumeric v) { set(input, v, null); }

  //endregion Property "input"

  //region Property "onSp"

  /**
   * Slot for the {@code onSp} property.
   * @see #getOnSp
   * @see #setOnSp
   */
  public static final Property onSp = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.nullStatus), null);

  /**
   * Get the {@code onSp} property.
   * @see #onSp
   */
  public BStatusNumeric getOnSp() { return (BStatusNumeric)get(onSp); }

  /**
   * Set the {@code onSp} property.
   * @see #onSp
   */
  public void setOnSp(BStatusNumeric v) { set(onSp, v, null); }

  //endregion Property "onSp"

  //region Property "offSp"

  /**
   * Slot for the {@code offSp} property.
   * @see #getOffSp
   * @see #setOffSp
   */
  public static final Property offSp = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.nullStatus), null);

  /**
   * Get the {@code offSp} property.
   * @see #offSp
   */
  public BStatusNumeric getOffSp() { return (BStatusNumeric)get(offSp); }

  /**
   * Set the {@code offSp} property.
   * @see #offSp
   */
  public void setOffSp(BStatusNumeric v) { set(offSp, v, null); }

  //endregion Property "offSp"

  //region Property "tstatAction"

  /**
   * Slot for the {@code tstatAction} property.
   * @see #getTstatAction
   * @see #setTstatAction
   */
  public static final Property tstatAction = newProperty(Flags.SUMMARY | Flags.READONLY, BBoolean.FALSE.as(BBoolean.class).getBoolean(), BFacets.make(BFacets.make(BFacets.TRUE_TEXT, "Direct"), BFacets.make(BFacets.FALSE_TEXT, "Reverse")));

  /**
   * Get the {@code tstatAction} property.
   * @see #tstatAction
   */
  public boolean getTstatAction() { return getBoolean(tstatAction); }

  /**
   * Set the {@code tstatAction} property.
   * @see #tstatAction
   */
  public void setTstatAction(boolean v) { setBoolean(tstatAction, v, null); }

  //endregion Property "tstatAction"

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY | Flags.READONLY, new BStatusBoolean(false), null);

  /**
   * Get the {@code out} property.
   * @see #out
   */
  public BStatusBoolean getOut() { return (BStatusBoolean)get(out); }

  /**
   * Set the {@code out} property.
   * @see #out
   */
  public void setOut(BStatusBoolean v) { set(out, v, null); }

  //endregion Property "out"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHysteresis.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BHysteresis() {
    }

    private static final BIcon icon = BIcon.make("module://myFirstModule/images/thermometer.png");
    public BIcon getIcon() {
        return icon;
    }

    public BFacets getSlotFacets(Slot slot)
    {
        if (slot == out) return getFacets();
        return super.getSlotFacets(slot);
    }



    public void changed(Property p, Context cx)
    {
        if(!isRunning())
        {
            return;
        }
        if (p.equals(input) || p.equals(onSp) || p.equals(offSp) || p.equals(tstatAction))
        {
            this.calculate();
        }

    }

    public void calculate() {

        BStatus in = getInput().getStatus();
        BStatus spOn = getOnSp().getStatus();
        BStatus spOff = getOffSp().getStatus();
        double cv = getInput().getValue();
        double onSP = getOnSp().getValue();
        double offSP = getOffSp().getValue();
        boolean output = getOut().getValue();
        boolean action = getTstatAction();
        if (in.isValid() && spOn.isValid() && spOff.isValid()) {
            if (onSP > offSP) {
                action = true;
                if (!output && (cv >= onSP)) {
                    output = true;
                }
                if (output && (cv <= offSP)) {
                    output = false;
                }
            } else {
                action = false;
                if (!output && (cv <= onSP)) {
                    output = true;
                }
                if (output && (cv >= offSP)) {
                    output = false;
                }
            }
        } else {
            output = false;
            action = false;
        }
        getOut().setValue(output);
        setTstatAction(action);

    }
}

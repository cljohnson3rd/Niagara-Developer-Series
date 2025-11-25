package com.devseries.myFirstModule.components;


import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusBoolean;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "input", type = "BStatusBoolean", defaultValue = "new BStatusBoolean(false, BStatus.nullStatus)", flags = Flags.SUMMARY|Flags.OPERATOR)
@NiagaraProperty(name = "out", type = "String", defaultValue = "new String()", flags = Flags.READONLY|Flags.SUMMARY)

public class BMyFirstComponent extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.components.BMyFirstComponent(3721320961)1.0$ @*/
/* Generated Sun May 25 12:46:18 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "input"

  /**
   * Slot for the {@code input} property.
   * @see #getInput
   * @see #setInput
   */
  public static final Property input = newProperty(Flags.SUMMARY | Flags.OPERATOR, new BStatusBoolean(false, BStatus.nullStatus), null);

  /**
   * Get the {@code input} property.
   * @see #input
   */
  public BStatusBoolean getInput() { return (BStatusBoolean)get(input); }

  /**
   * Set the {@code input} property.
   * @see #input
   */
  public void setInput(BStatusBoolean v) { set(input, v, null); }

  //endregion Property "input"

  //region Property "out"

  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY | Flags.SUMMARY, new String(), null);

  /**
   * Get the {@code out} property.
   * @see #out
   */
  public String getOut() { return getString(out); }

  /**
   * Set the {@code out} property.
   * @see #out
   */
  public void setOut(String v) { setString(out, v, null); }

  //endregion Property "out"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BMyFirstComponent.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


    @Override
    public void changed(Property p, Context cx){
        super.changed(p, cx);
        if (p == input){
            boolean value = getInput().getBoolean();
            if (value) {
                setOut("Hello, World!");
            }
            else{
                setOut("Goodbye, World!");
            }
        }
    }

}

package com.devseries.myFirstModule.Topics;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraAction(name = "execute", flags = Flags.SUMMARY)
@NiagaraProperty(name = "timeExecuted", type = "BAbsTime", defaultValue = "BAbsTime.DEFAULT", flags = Flags.SUMMARY)

public class BTimeExecuted extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.Topics.BTimeExecuted(3398277159)1.0$ @*/
/* Generated Thu Jun 05 23:01:18 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "timeExecuted"

  /**
   * Slot for the {@code timeExecuted} property.
   * @see #getTimeExecuted
   * @see #setTimeExecuted
   */
  public static final Property timeExecuted = newProperty(Flags.SUMMARY, BAbsTime.DEFAULT, null);

  /**
   * Get the {@code timeExecuted} property.
   * @see #timeExecuted
   */
  public BAbsTime getTimeExecuted() { return (BAbsTime)get(timeExecuted); }

  /**
   * Set the {@code timeExecuted} property.
   * @see #timeExecuted
   */
  public void setTimeExecuted(BAbsTime v) { set(timeExecuted, v, null); }

  //endregion Property "timeExecuted"

  //region Action "execute"

  /**
   * Slot for the {@code execute} action.
   * @see #execute()
   */
  public static final Action execute = newAction(Flags.SUMMARY, null);

  /**
   * Invoke the {@code execute} action.
   * @see #execute
   */
  public void execute() { invoke(execute, null, null); }

  //endregion Action "execute"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTimeExecuted.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BTimeExecuted() {}

    public void doExecute(){
        setTimeExecuted(BAbsTime.now());
    }
}

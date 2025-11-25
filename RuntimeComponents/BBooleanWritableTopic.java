package com.devseries.myFirstModule.Topics;

import javax.baja.control.BBooleanWritable;
import javax.baja.nre.annotations.NiagaraTopic;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraTopic(name = "overridden", eventType = "BBoolean", flags = Flags.SUMMARY)

public class BBooleanWritableTopic extends BBooleanWritable {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.Topics.BBooleanWritableTopic(983856439)1.0$ @*/
/* Generated Thu Jun 05 22:06:10 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Topic "overridden"

  /**
   * Slot for the {@code overridden} topic.
   * @see #fireOverridden
   */
  public static final Topic overridden = newTopic(Flags.SUMMARY, null);

  /**
   * Fire an event for the {@code overridden} topic.
   * @see #overridden
   */
  public void fireOverridden(BBoolean event) { fire(overridden, event, null); }

  //endregion Topic "overridden"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBooleanWritableTopic.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BBooleanWritableTopic() {}

    @Override
    public void changed(Property p, Context cx) {
        super.changed(p, cx);

        if (p.equals(out)) { // or check if out status changed
            if (getStatus().isOverridden()) {
                System.out.println(">>> Status became overridden");
                fireOverridden(BBoolean.TRUE);
            }
        }
    }
}

package com.devseries.myFirstModule.utilities;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.util.BNotification;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraProperty(name = "dialogTitle", type = "String", defaultValue = "")
@NiagaraProperty(name = "dialogMessage", type = "BString", defaultValue = "")

public class BDriverFinderMessage extends BNotification
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.utilities.BDriverFinderMessage(3446483276)1.0$ @*/
/* Generated Sun Nov 23 16:00:16 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "dialogTitle"

  /**
   * Slot for the {@code dialogTitle} property.
   * @see #getDialogTitle
   * @see #setDialogTitle
   */
  public static final Property dialogTitle = newProperty(0, "", null);

  /**
   * Get the {@code dialogTitle} property.
   * @see #dialogTitle
   */
  public String getDialogTitle() { return getString(dialogTitle); }

  /**
   * Set the {@code dialogTitle} property.
   * @see #dialogTitle
   */
  public void setDialogTitle(String v) { setString(dialogTitle, v, null); }

  //endregion Property "dialogTitle"

  //region Property "dialogMessage"

  /**
   * Slot for the {@code dialogMessage} property.
   * @see #getDialogMessage
   * @see #setDialogMessage
   */
  public static final Property dialogMessage = newProperty(0, "", null);

  /**
   * Get the {@code dialogMessage} property.
   * @see #dialogMessage
   */
  public String getDialogMessage() { return getString(dialogMessage); }

  /**
   * Set the {@code dialogMessage} property.
   * @see #dialogMessage
   */
  public void setDialogMessage(String v) { setString(dialogMessage, v, null); }

  //endregion Property "dialogMessage"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverFinderMessage.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}

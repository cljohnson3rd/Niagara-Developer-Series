package com.devseries.myfirstmodule.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType(agent = @AgentOn(types = "myFirstModule:Hysteresis"))
@NiagaraSingleton
public final class BHysteresisWidget
    extends BSingleton
    implements BIJavaScript, BIFormFactorMax
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myfirstmodule.ux.BHysteresisWidget(2902535604)1.0$ @*/
/* Generated Wed Nov 26 15:38:19 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  public static final BHysteresisWidget INSTANCE = new BHysteresisWidget();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHysteresisWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  private BHysteresisWidget() {}
  public JsInfo getJsInfo(Context cx) { return jsInfo; }

  private static final JsInfo jsInfo =
      JsInfo.make(
        BOrd.make("module://myFirstModule/rc/hysteresisWidget.js"),
        BMyFirstModuleJsBuild.TYPE
      );
}

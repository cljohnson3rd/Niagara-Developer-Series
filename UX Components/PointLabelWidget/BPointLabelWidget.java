package com.devseries.myfirstmodule.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorCompact;
import javax.baja.web.BIOffline;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

@NiagaraType
@NiagaraSingleton

public final class BPointLabelWidget extends BSingleton implements BIJavaScript, BIFormFactorCompact, BIOffline {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myfirstmodule.ux.BPointLabelWidget(2747097003)1.0$ @*/
/* Generated Thu Dec 11 23:23:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  public static final BPointLabelWidget INSTANCE = new BPointLabelWidget();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPointLabelWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    private BPointLabelWidget(){}
    public JsInfo getJsInfo(Context cx) {return jsInfo;}

    private static final JsInfo jsInfo =
            JsInfo.make(
                    BOrd.make("module://myFirstModule/rc/pointLabelWidget.js"),
                    BMyFirstModuleJsBuild.TYPE
            );
}

package com.devseries.myFirstModule.ui.Widgets;

import com.tridium.hx.px.BHxPxGraphics;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;


@NiagaraType(agent = {@AgentOn(types = {"myFirstModule:ModernGaugeWidget", "myFirstModule:ModernLabel"}, requiredPermissions = "r")})
@NiagaraSingleton
public class BHxModernGaugeWidgetView extends BHxPxGraphics {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.ui.Widgets.BHxModernGaugeWidgetView(1490029361)1.0$ @*/
/* Generated Sun Dec 14 14:54:37 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  public static final BHxModernGaugeWidgetView INSTANCE = new BHxModernGaugeWidgetView();

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHxModernGaugeWidgetView.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}

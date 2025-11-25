package com.devseries.myFirstModule.ui;

import com.devseries.myFirstModule.utilities.BDriverFinderMessage;

import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Context;
import javax.baja.ui.BDialog;
import javax.baja.ui.pane.BTextEditorPane;
import javax.baja.ui.text.BTextEditor;
import javax.baja.util.BNotification;
import javax.baja.workbench.BWbShell;
import javax.baja.workbench.util.BNotificationHandler;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType(agent = @AgentOn(types = "myFirstModule:DriverFinderMessage"))

public class BDriverFinderNotificationPopup extends BNotificationHandler
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.ui.BDriverFinderNotificationPopup(2175268105)1.0$ @*/
/* Generated Sun Nov 23 16:13:28 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverFinderNotificationPopup.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BDriverFinderNotificationPopup(){}

    @Override
    public void handle(BWbShell shell, BNotification notify, Context cx)
    {
        BDriverFinderMessage item = (BDriverFinderMessage) notify;
        BTextEditor textEditor = new BTextEditor(item.getDialogMessage(), false);
        BTextEditorPane textEditorPane = new BTextEditorPane(textEditor, 20, 80);

        BDialog.message(shell, item.getDialogMessage(), textEditorPane);
    }

}

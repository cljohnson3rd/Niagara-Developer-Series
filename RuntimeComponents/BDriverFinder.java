package com.devseries.myFirstModule.utilities;

import javax.baja.collection.BITable;
import javax.baja.collection.Column;
import javax.baja.collection.ColumnList;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@NiagaraType
@NiagaraAction(name = "findDrivers")

public class BDriverFinder extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.utilities.BDriverFinder(394305265)1.0$ @*/
/* Generated Sun Nov 23 16:02:20 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Action "findDrivers"

  /**
   * Slot for the {@code findDrivers} action.
   * @see #findDrivers()
   */
  public static final Action findDrivers = newAction(0, null);

  /**
   * Invoke the {@code findDrivers} action.
   * @see #findDrivers
   */
  public void findDrivers() { invoke(findDrivers, null, null); }

  //endregion Action "findDrivers"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDriverFinder.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public BDriverFinder(){}

    private static final BIcon icon = BIcon.make("module://myFirstModule/images/driverFinder.png");
    public BIcon getIcon() {
        return icon;
    }

    private static final Logger LOG = Logger.getLogger("Finding Drivers");

    public void doFindDrivers(Context cx)
    {
        @SuppressWarnings("unchecked")
        BOrd ord = BOrd.make("bql:select slotPath from driver:DeviceNetwork where parent.slotPath != 'slot:/Drivers'");
        BITable result = (BITable) ord.get(Sys.getStation(),cx);
        ColumnList columns = result.getColumns();
        Column valueColumn = columns.get(0);

        BString message = BString.make("Networks found outside of Drivers Container!\n");

        try(TableCursor c = result.cursor())
        {
            while(c.next())
            {

                BString path = (BString) c.cell(valueColumn);
                message = BString.make(message.toString() + path.toString() + "\n");
                LOG.log(Level.INFO, path.toString());
            }
        }

        BDriverFinderMessage notification = new BDriverFinderMessage();
        notification.setDialogTitle("Drivers Found");
        notification.setDialogMessage(message.getString());
        notification.raise(false);
    }
}

package com.devseries.myFirstModule.components;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType
@NiagaraProperty(name = "componentToCopy", type = "BOrd", defaultValue = "BOrd.make(\"station:|slot:/\")", flags = Flags.SUMMARY)
@NiagaraProperty(name = "query", type = "BOrd", defaultValue = "BOrd.make(\"station:|slot:/\")", flags = Flags.SUMMARY)
@NiagaraProperty(name = "copiesMade", type = "BDouble", defaultValue = "BDouble.make(0.0)", flags = Flags.READONLY|Flags.SUMMARY)
@NiagaraAction(name = "runCopier")

public class BComponentCopier extends BComponent {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.components.BComponentCopier(2718282312)1.0$ @*/
/* Generated Mon May 26 19:29:23 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "componentToCopy"

  /**
   * Slot for the {@code componentToCopy} property.
   * @see #getComponentToCopy
   * @see #setComponentToCopy
   */
  public static final Property componentToCopy = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/"), null);

  /**
   * Get the {@code componentToCopy} property.
   * @see #componentToCopy
   */
  public BOrd getComponentToCopy() { return (BOrd)get(componentToCopy); }

  /**
   * Set the {@code componentToCopy} property.
   * @see #componentToCopy
   */
  public void setComponentToCopy(BOrd v) { set(componentToCopy, v, null); }

  //endregion Property "componentToCopy"

  //region Property "query"

  /**
   * Slot for the {@code query} property.
   * @see #getQuery
   * @see #setQuery
   */
  public static final Property query = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/"), null);

  /**
   * Get the {@code query} property.
   * @see #query
   */
  public BOrd getQuery() { return (BOrd)get(query); }

  /**
   * Set the {@code query} property.
   * @see #query
   */
  public void setQuery(BOrd v) { set(query, v, null); }

  //endregion Property "query"

  //region Property "copiesMade"

  /**
   * Slot for the {@code copiesMade} property.
   * @see #getCopiesMade
   * @see #setCopiesMade
   */
  public static final Property copiesMade = newProperty(Flags.READONLY | Flags.SUMMARY, BDouble.make(0.0).as(BDouble.class).getDouble(), null);

  /**
   * Get the {@code copiesMade} property.
   * @see #copiesMade
   */
  public double getCopiesMade() { return getDouble(copiesMade); }

  /**
   * Set the {@code copiesMade} property.
   * @see #copiesMade
   */
  public void setCopiesMade(double v) { setDouble(copiesMade, v, null); }

  //endregion Property "copiesMade"

  //region Action "runCopier"

  /**
   * Slot for the {@code runCopier} action.
   * @see #runCopier()
   */
  public static final Action runCopier = newAction(0, null);

  /**
   * Invoke the {@code runCopier} action.
   * @see #runCopier
   */
  public void runCopier() { invoke(runCopier, null, null); }

  //endregion Action "runCopier"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BComponentCopier.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    private static final BIcon icon = BIcon.make("module://myFirstModule/images/printer.png");

    public BIcon getIcon(){
        return icon;
    }

    public void doRunCopier()
    {
        BComponent compToCopy = (BComponent) getComponentToCopy().resolve().get();
        String compToCopyName = compToCopy.getName();

        double count = 0.0;

        @SuppressWarnings("unchecked")
        BITable table = (BITable) getQuery().resolve().get();

        try(TableCursor<BIObject> cursor = table.cursor())
        {
            while(cursor.next())
            {
                BIObject obj = cursor.get();
                Type compType = obj.getType();

                if (obj instanceof BComponent)
                {
                    BComponent comp = (BComponent) obj;
                    try
                    {
                        comp.add(compToCopyName, compToCopy.newCopy(), null);
                        count++;
                    } catch (DuplicateSlotException e){
                        System.out.println( e + "\nSlot name already used at " + comp.getSlotPath());
                    } catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
        } catch( Exception e){
            System.out.println("error looping over table:\n" + e);
        }
        setCopiesMade(count);
    }

}

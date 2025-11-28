package com.devseries.myfirstmodule.ux;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum( range = { @Range(ordinal = 1, value = "small"), @Range(ordinal = 2, value = "medium"), @Range(ordinal = 3, value = "large")}, defaultValue = "medium")

public final class BSizeEnum extends BFrozenEnum {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myfirstmodule.ux.BSizeEnum(3916823061)1.0$ @*/
/* Generated Thu Nov 27 00:06:11 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  /** Ordinal value for small. */
  public static final int SMALL = 1;
  /** Ordinal value for medium. */
  public static final int MEDIUM = 2;
  /** Ordinal value for large. */
  public static final int LARGE = 3;

  /** BSizeEnum constant for small. */
  public static final BSizeEnum small = new BSizeEnum(SMALL);
  /** BSizeEnum constant for medium. */
  public static final BSizeEnum medium = new BSizeEnum(MEDIUM);
  /** BSizeEnum constant for large. */
  public static final BSizeEnum large = new BSizeEnum(LARGE);

  /** Factory method with ordinal. */
  public static BSizeEnum make(int ordinal)
  {
    return (BSizeEnum)small.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BSizeEnum make(String tag)
  {
    return (BSizeEnum)small.getRange().get(tag);
  }

  /** Private constructor. */
  private BSizeEnum(int ordinal)
  {
    super(ordinal);
  }

  public static final BSizeEnum DEFAULT = medium;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSizeEnum.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}

package com.devseries.myfirstmodule.ux;

import javax.baja.nre.annotations.NiagaraEnum;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.nre.annotations.Range;
import javax.baja.sys.BFrozenEnum;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType
@NiagaraEnum( range = { @Range(ordinal = 1, value = "rounded"), @Range(ordinal = 2, value = "square"), @Range(ordinal = 3, value = "stadium")}, defaultValue = "rounded")

public final class BToggleStyleEnum extends BFrozenEnum {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myfirstmodule.ux.BToggleStyleEnum(4074929992)1.0$ @*/
/* Generated Thu Nov 27 01:49:18 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  /** Ordinal value for rounded. */
  public static final int ROUNDED = 1;
  /** Ordinal value for square. */
  public static final int SQUARE = 2;
  /** Ordinal value for stadium. */
  public static final int STADIUM = 3;

  /** BToggleStyleEnum constant for rounded. */
  public static final BToggleStyleEnum rounded = new BToggleStyleEnum(ROUNDED);
  /** BToggleStyleEnum constant for square. */
  public static final BToggleStyleEnum square = new BToggleStyleEnum(SQUARE);
  /** BToggleStyleEnum constant for stadium. */
  public static final BToggleStyleEnum stadium = new BToggleStyleEnum(STADIUM);

  /** Factory method with ordinal. */
  public static BToggleStyleEnum make(int ordinal)
  {
    return (BToggleStyleEnum)rounded.getRange().get(ordinal, false);
  }

  /** Factory method with tag. */
  public static BToggleStyleEnum make(String tag)
  {
    return (BToggleStyleEnum)rounded.getRange().get(tag);
  }

  /** Private constructor. */
  private BToggleStyleEnum(int ordinal)
  {
    super(ordinal);
  }

  public static final BToggleStyleEnum DEFAULT = rounded;

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BToggleStyleEnum.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}

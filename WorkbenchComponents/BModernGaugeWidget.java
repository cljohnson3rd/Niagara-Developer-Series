package com.devseries.myFirstModule.ui.Widgets;

import javax.baja.gx.*;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.ui.BWidget;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType

// Value and Range
@NiagaraProperty(name = "value",     type = "double", defaultValue = "50.0")
@NiagaraProperty(name = "minValue",  type = "double", defaultValue = "0.0")
@NiagaraProperty(name = "maxValue",  type = "double", defaultValue = "100.0")

// Display
@NiagaraProperty(name = "title",     type = "String",  defaultValue = "Gauge")
@NiagaraProperty(name = "text",      type = "String",  defaultValue = "")
@NiagaraProperty(name = "showValue", type = "boolean", defaultValue = "true")
@NiagaraProperty(name = "showTitle", type = "boolean", defaultValue = "true")
@NiagaraProperty(name = "showScale", type = "boolean", defaultValue = "true")

// Gauge Geometry
@NiagaraProperty(name = "startAngle", type = "int",    defaultValue = "135")
@NiagaraProperty(name = "sweepAngle", type = "int",    defaultValue = "270")
@NiagaraProperty(name = "gaugeStyle", type = "String", defaultValue = "modern")

// Scale
@NiagaraProperty(name = "majorTicks", type = "int", defaultValue = "5")
@NiagaraProperty(name = "minorTicks", type = "int", defaultValue = "4")
@NiagaraProperty(name = "precision",  type = "int", defaultValue = "0")

// Colors and Styling
@NiagaraProperty(name = "backgroundColor", type = "gx:Color", defaultValue = "BColor.make(0x2C3E50)")
@NiagaraProperty(name = "gaugeColor",      type = "gx:Color", defaultValue = "BColor.make(0x34495E)")
@NiagaraProperty(name = "needleColor",     type = "gx:Color", defaultValue = "BColor.make(0xE74C3C)")
@NiagaraProperty(name = "textColor",       type = "gx:Color", defaultValue = "BColor.white")
@NiagaraProperty(name = "scaleColor",      type = "gx:Color", defaultValue = "BColor.make(0xBDC3C7)")

// Warning Zones
@NiagaraProperty(name = "warningMin",   type = "double",  defaultValue = "70.0")
@NiagaraProperty(name = "warningMax",   type = "double",  defaultValue = "85.0")
@NiagaraProperty(name = "criticalMin",  type = "double",  defaultValue = "85.0")
@NiagaraProperty(name = "criticalMax",  type = "double",  defaultValue = "100.0")
@NiagaraProperty(name = "showZones",    type = "boolean", defaultValue = "true")
@NiagaraProperty(name = "warningColor", type = "gx:Color", defaultValue = "BColor.make(0xF39C12)")
@NiagaraProperty(name = "criticalColor",type = "gx:Color", defaultValue = "BColor.make(0xE74C3C)")

// Fonts
@NiagaraProperty(name = "titleFont", type = "gx:Font", defaultValue = "BFont.DEFAULT")
@NiagaraProperty(name = "valueFont", type = "gx:Font", defaultValue = "BFont.DEFAULT")
@NiagaraProperty(name = "scaleFont", type = "gx:Font", defaultValue = "BFont.DEFAULT")

public class BModernGaugeWidget extends BWidget {
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.ui.Widgets.BModernGaugeWidget(3604787991)1.0$ @*/
/* Generated Mon Nov 24 11:37:31 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "value"

  /**
   * Slot for the {@code value} property.
   *  Value and Range
   * @see #getValue
   * @see #setValue
   */
  public static final Property value = newProperty(0, 50.0, null);

  /**
   * Get the {@code value} property.
   *  Value and Range
   * @see #value
   */
  public double getValue() { return getDouble(value); }

  /**
   * Set the {@code value} property.
   *  Value and Range
   * @see #value
   */
  public void setValue(double v) { setDouble(value, v, null); }

  //endregion Property "value"

  //region Property "minValue"

  /**
   * Slot for the {@code minValue} property.
   * @see #getMinValue
   * @see #setMinValue
   */
  public static final Property minValue = newProperty(0, 0.0, null);

  /**
   * Get the {@code minValue} property.
   * @see #minValue
   */
  public double getMinValue() { return getDouble(minValue); }

  /**
   * Set the {@code minValue} property.
   * @see #minValue
   */
  public void setMinValue(double v) { setDouble(minValue, v, null); }

  //endregion Property "minValue"

  //region Property "maxValue"

  /**
   * Slot for the {@code maxValue} property.
   * @see #getMaxValue
   * @see #setMaxValue
   */
  public static final Property maxValue = newProperty(0, 100.0, null);

  /**
   * Get the {@code maxValue} property.
   * @see #maxValue
   */
  public double getMaxValue() { return getDouble(maxValue); }

  /**
   * Set the {@code maxValue} property.
   * @see #maxValue
   */
  public void setMaxValue(double v) { setDouble(maxValue, v, null); }

  //endregion Property "maxValue"

  //region Property "title"

  /**
   * Slot for the {@code title} property.
   *  Display
   * @see #getTitle
   * @see #setTitle
   */
  public static final Property title = newProperty(0, "Gauge", null);

  /**
   * Get the {@code title} property.
   *  Display
   * @see #title
   */
  public String getTitle() { return getString(title); }

  /**
   * Set the {@code title} property.
   *  Display
   * @see #title
   */
  public void setTitle(String v) { setString(title, v, null); }

  //endregion Property "title"

  //region Property "text"

  /**
   * Slot for the {@code text} property.
   * @see #getText
   * @see #setText
   */
  public static final Property text = newProperty(0, "", null);

  /**
   * Get the {@code text} property.
   * @see #text
   */
  public String getText() { return getString(text); }

  /**
   * Set the {@code text} property.
   * @see #text
   */
  public void setText(String v) { setString(text, v, null); }

  //endregion Property "text"

  //region Property "showValue"

  /**
   * Slot for the {@code showValue} property.
   * @see #getShowValue
   * @see #setShowValue
   */
  public static final Property showValue = newProperty(0, true, null);

  /**
   * Get the {@code showValue} property.
   * @see #showValue
   */
  public boolean getShowValue() { return getBoolean(showValue); }

  /**
   * Set the {@code showValue} property.
   * @see #showValue
   */
  public void setShowValue(boolean v) { setBoolean(showValue, v, null); }

  //endregion Property "showValue"

  //region Property "showTitle"

  /**
   * Slot for the {@code showTitle} property.
   * @see #getShowTitle
   * @see #setShowTitle
   */
  public static final Property showTitle = newProperty(0, true, null);

  /**
   * Get the {@code showTitle} property.
   * @see #showTitle
   */
  public boolean getShowTitle() { return getBoolean(showTitle); }

  /**
   * Set the {@code showTitle} property.
   * @see #showTitle
   */
  public void setShowTitle(boolean v) { setBoolean(showTitle, v, null); }

  //endregion Property "showTitle"

  //region Property "showScale"

  /**
   * Slot for the {@code showScale} property.
   * @see #getShowScale
   * @see #setShowScale
   */
  public static final Property showScale = newProperty(0, true, null);

  /**
   * Get the {@code showScale} property.
   * @see #showScale
   */
  public boolean getShowScale() { return getBoolean(showScale); }

  /**
   * Set the {@code showScale} property.
   * @see #showScale
   */
  public void setShowScale(boolean v) { setBoolean(showScale, v, null); }

  //endregion Property "showScale"

  //region Property "startAngle"

  /**
   * Slot for the {@code startAngle} property.
   *  Gauge Geometry
   * @see #getStartAngle
   * @see #setStartAngle
   */
  public static final Property startAngle = newProperty(0, 135, null);

  /**
   * Get the {@code startAngle} property.
   *  Gauge Geometry
   * @see #startAngle
   */
  public int getStartAngle() { return getInt(startAngle); }

  /**
   * Set the {@code startAngle} property.
   *  Gauge Geometry
   * @see #startAngle
   */
  public void setStartAngle(int v) { setInt(startAngle, v, null); }

  //endregion Property "startAngle"

  //region Property "sweepAngle"

  /**
   * Slot for the {@code sweepAngle} property.
   * @see #getSweepAngle
   * @see #setSweepAngle
   */
  public static final Property sweepAngle = newProperty(0, 270, null);

  /**
   * Get the {@code sweepAngle} property.
   * @see #sweepAngle
   */
  public int getSweepAngle() { return getInt(sweepAngle); }

  /**
   * Set the {@code sweepAngle} property.
   * @see #sweepAngle
   */
  public void setSweepAngle(int v) { setInt(sweepAngle, v, null); }

  //endregion Property "sweepAngle"

  //region Property "gaugeStyle"

  /**
   * Slot for the {@code gaugeStyle} property.
   * @see #getGaugeStyle
   * @see #setGaugeStyle
   */
  public static final Property gaugeStyle = newProperty(0, "modern", null);

  /**
   * Get the {@code gaugeStyle} property.
   * @see #gaugeStyle
   */
  public String getGaugeStyle() { return getString(gaugeStyle); }

  /**
   * Set the {@code gaugeStyle} property.
   * @see #gaugeStyle
   */
  public void setGaugeStyle(String v) { setString(gaugeStyle, v, null); }

  //endregion Property "gaugeStyle"

  //region Property "majorTicks"

  /**
   * Slot for the {@code majorTicks} property.
   *  Scale
   * @see #getMajorTicks
   * @see #setMajorTicks
   */
  public static final Property majorTicks = newProperty(0, 5, null);

  /**
   * Get the {@code majorTicks} property.
   *  Scale
   * @see #majorTicks
   */
  public int getMajorTicks() { return getInt(majorTicks); }

  /**
   * Set the {@code majorTicks} property.
   *  Scale
   * @see #majorTicks
   */
  public void setMajorTicks(int v) { setInt(majorTicks, v, null); }

  //endregion Property "majorTicks"

  //region Property "minorTicks"

  /**
   * Slot for the {@code minorTicks} property.
   * @see #getMinorTicks
   * @see #setMinorTicks
   */
  public static final Property minorTicks = newProperty(0, 4, null);

  /**
   * Get the {@code minorTicks} property.
   * @see #minorTicks
   */
  public int getMinorTicks() { return getInt(minorTicks); }

  /**
   * Set the {@code minorTicks} property.
   * @see #minorTicks
   */
  public void setMinorTicks(int v) { setInt(minorTicks, v, null); }

  //endregion Property "minorTicks"

  //region Property "precision"

  /**
   * Slot for the {@code precision} property.
   * @see #getPrecision
   * @see #setPrecision
   */
  public static final Property precision = newProperty(0, 0, null);

  /**
   * Get the {@code precision} property.
   * @see #precision
   */
  public int getPrecision() { return getInt(precision); }

  /**
   * Set the {@code precision} property.
   * @see #precision
   */
  public void setPrecision(int v) { setInt(precision, v, null); }

  //endregion Property "precision"

  //region Property "backgroundColor"

  /**
   * Slot for the {@code backgroundColor} property.
   *  Colors and Styling
   * @see #getBackgroundColor
   * @see #setBackgroundColor
   */
  public static final Property backgroundColor = newProperty(0, BColor.make(0x2C3E50), null);

  /**
   * Get the {@code backgroundColor} property.
   *  Colors and Styling
   * @see #backgroundColor
   */
  public BColor getBackgroundColor() { return (BColor)get(backgroundColor); }

  /**
   * Set the {@code backgroundColor} property.
   *  Colors and Styling
   * @see #backgroundColor
   */
  public void setBackgroundColor(BColor v) { set(backgroundColor, v, null); }

  //endregion Property "backgroundColor"

  //region Property "gaugeColor"

  /**
   * Slot for the {@code gaugeColor} property.
   * @see #getGaugeColor
   * @see #setGaugeColor
   */
  public static final Property gaugeColor = newProperty(0, BColor.make(0x34495E), null);

  /**
   * Get the {@code gaugeColor} property.
   * @see #gaugeColor
   */
  public BColor getGaugeColor() { return (BColor)get(gaugeColor); }

  /**
   * Set the {@code gaugeColor} property.
   * @see #gaugeColor
   */
  public void setGaugeColor(BColor v) { set(gaugeColor, v, null); }

  //endregion Property "gaugeColor"

  //region Property "needleColor"

  /**
   * Slot for the {@code needleColor} property.
   * @see #getNeedleColor
   * @see #setNeedleColor
   */
  public static final Property needleColor = newProperty(0, BColor.make(0xE74C3C), null);

  /**
   * Get the {@code needleColor} property.
   * @see #needleColor
   */
  public BColor getNeedleColor() { return (BColor)get(needleColor); }

  /**
   * Set the {@code needleColor} property.
   * @see #needleColor
   */
  public void setNeedleColor(BColor v) { set(needleColor, v, null); }

  //endregion Property "needleColor"

  //region Property "textColor"

  /**
   * Slot for the {@code textColor} property.
   * @see #getTextColor
   * @see #setTextColor
   */
  public static final Property textColor = newProperty(0, BColor.white, null);

  /**
   * Get the {@code textColor} property.
   * @see #textColor
   */
  public BColor getTextColor() { return (BColor)get(textColor); }

  /**
   * Set the {@code textColor} property.
   * @see #textColor
   */
  public void setTextColor(BColor v) { set(textColor, v, null); }

  //endregion Property "textColor"

  //region Property "scaleColor"

  /**
   * Slot for the {@code scaleColor} property.
   * @see #getScaleColor
   * @see #setScaleColor
   */
  public static final Property scaleColor = newProperty(0, BColor.make(0xBDC3C7), null);

  /**
   * Get the {@code scaleColor} property.
   * @see #scaleColor
   */
  public BColor getScaleColor() { return (BColor)get(scaleColor); }

  /**
   * Set the {@code scaleColor} property.
   * @see #scaleColor
   */
  public void setScaleColor(BColor v) { set(scaleColor, v, null); }

  //endregion Property "scaleColor"

  //region Property "warningMin"

  /**
   * Slot for the {@code warningMin} property.
   *  Warning Zones
   * @see #getWarningMin
   * @see #setWarningMin
   */
  public static final Property warningMin = newProperty(0, 70.0, null);

  /**
   * Get the {@code warningMin} property.
   *  Warning Zones
   * @see #warningMin
   */
  public double getWarningMin() { return getDouble(warningMin); }

  /**
   * Set the {@code warningMin} property.
   *  Warning Zones
   * @see #warningMin
   */
  public void setWarningMin(double v) { setDouble(warningMin, v, null); }

  //endregion Property "warningMin"

  //region Property "warningMax"

  /**
   * Slot for the {@code warningMax} property.
   * @see #getWarningMax
   * @see #setWarningMax
   */
  public static final Property warningMax = newProperty(0, 85.0, null);

  /**
   * Get the {@code warningMax} property.
   * @see #warningMax
   */
  public double getWarningMax() { return getDouble(warningMax); }

  /**
   * Set the {@code warningMax} property.
   * @see #warningMax
   */
  public void setWarningMax(double v) { setDouble(warningMax, v, null); }

  //endregion Property "warningMax"

  //region Property "criticalMin"

  /**
   * Slot for the {@code criticalMin} property.
   * @see #getCriticalMin
   * @see #setCriticalMin
   */
  public static final Property criticalMin = newProperty(0, 85.0, null);

  /**
   * Get the {@code criticalMin} property.
   * @see #criticalMin
   */
  public double getCriticalMin() { return getDouble(criticalMin); }

  /**
   * Set the {@code criticalMin} property.
   * @see #criticalMin
   */
  public void setCriticalMin(double v) { setDouble(criticalMin, v, null); }

  //endregion Property "criticalMin"

  //region Property "criticalMax"

  /**
   * Slot for the {@code criticalMax} property.
   * @see #getCriticalMax
   * @see #setCriticalMax
   */
  public static final Property criticalMax = newProperty(0, 100.0, null);

  /**
   * Get the {@code criticalMax} property.
   * @see #criticalMax
   */
  public double getCriticalMax() { return getDouble(criticalMax); }

  /**
   * Set the {@code criticalMax} property.
   * @see #criticalMax
   */
  public void setCriticalMax(double v) { setDouble(criticalMax, v, null); }

  //endregion Property "criticalMax"

  //region Property "showZones"

  /**
   * Slot for the {@code showZones} property.
   * @see #getShowZones
   * @see #setShowZones
   */
  public static final Property showZones = newProperty(0, true, null);

  /**
   * Get the {@code showZones} property.
   * @see #showZones
   */
  public boolean getShowZones() { return getBoolean(showZones); }

  /**
   * Set the {@code showZones} property.
   * @see #showZones
   */
  public void setShowZones(boolean v) { setBoolean(showZones, v, null); }

  //endregion Property "showZones"

  //region Property "warningColor"

  /**
   * Slot for the {@code warningColor} property.
   * @see #getWarningColor
   * @see #setWarningColor
   */
  public static final Property warningColor = newProperty(0, BColor.make(0xF39C12), null);

  /**
   * Get the {@code warningColor} property.
   * @see #warningColor
   */
  public BColor getWarningColor() { return (BColor)get(warningColor); }

  /**
   * Set the {@code warningColor} property.
   * @see #warningColor
   */
  public void setWarningColor(BColor v) { set(warningColor, v, null); }

  //endregion Property "warningColor"

  //region Property "criticalColor"

  /**
   * Slot for the {@code criticalColor} property.
   * @see #getCriticalColor
   * @see #setCriticalColor
   */
  public static final Property criticalColor = newProperty(0, BColor.make(0xE74C3C), null);

  /**
   * Get the {@code criticalColor} property.
   * @see #criticalColor
   */
  public BColor getCriticalColor() { return (BColor)get(criticalColor); }

  /**
   * Set the {@code criticalColor} property.
   * @see #criticalColor
   */
  public void setCriticalColor(BColor v) { set(criticalColor, v, null); }

  //endregion Property "criticalColor"

  //region Property "titleFont"

  /**
   * Slot for the {@code titleFont} property.
   *  Fonts
   * @see #getTitleFont
   * @see #setTitleFont
   */
  public static final Property titleFont = newProperty(0, BFont.DEFAULT, null);

  /**
   * Get the {@code titleFont} property.
   *  Fonts
   * @see #titleFont
   */
  public BFont getTitleFont() { return (BFont)get(titleFont); }

  /**
   * Set the {@code titleFont} property.
   *  Fonts
   * @see #titleFont
   */
  public void setTitleFont(BFont v) { set(titleFont, v, null); }

  //endregion Property "titleFont"

  //region Property "valueFont"

  /**
   * Slot for the {@code valueFont} property.
   * @see #getValueFont
   * @see #setValueFont
   */
  public static final Property valueFont = newProperty(0, BFont.DEFAULT, null);

  /**
   * Get the {@code valueFont} property.
   * @see #valueFont
   */
  public BFont getValueFont() { return (BFont)get(valueFont); }

  /**
   * Set the {@code valueFont} property.
   * @see #valueFont
   */
  public void setValueFont(BFont v) { set(valueFont, v, null); }

  //endregion Property "valueFont"

  //region Property "scaleFont"

  /**
   * Slot for the {@code scaleFont} property.
   * @see #getScaleFont
   * @see #setScaleFont
   */
  public static final Property scaleFont = newProperty(0, BFont.DEFAULT, null);

  /**
   * Get the {@code scaleFont} property.
   * @see #scaleFont
   */
  public BFont getScaleFont() { return (BFont)get(scaleFont); }

  /**
   * Set the {@code scaleFont} property.
   * @see #scaleFont
   */
  public void setScaleFont(BFont v) { set(scaleFont, v, null); }

  //endregion Property "scaleFont"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BModernGaugeWidget.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    private double centerX, centerY, radius;
    private double gaugeRadius, needleLength;

    @Override
    public void computePreferredSize() {
        setPreferredSize(200, 200);
    }

    @Override
    public void doLayout(BWidget[] kids) {
        double width = getWidth();
        double height = getHeight();

        // Calculate center and radius
        centerX = width / 2.0;
        centerY = height / 2.0;
        radius = Math.min(width, height) / 2.0 - 20; // Leave margin

        gaugeRadius = radius * 0.8;
        needleLength = radius * 0.7;
    }

    @Override
    public void paint(Graphics g) {
        // Anti-aliasing for smoother graphics
        g.useAntiAliasing(true);

        // Clear background
        g.setBrush(getBackgroundColor().toBrush());
        g.fill(BRectGeom.make(0, 0, getWidth(), getHeight()));

        // Draw gauge components in order
        drawGaugeBackground(g);
        drawWarningZones(g);
        drawScale(g);
        drawNeedle(g);
        drawCenterHub(g);
        drawLabels(g);
    }

    private void drawGaugeBackground(Graphics g) {
        // Outer ring
        g.setBrush(getGaugeColor().toBrush());
        g.setPen(BPen.make(2));  // Width only

        double outerSize = radius * 2;
        BEllipseGeom outerCircle = BEllipseGeom.make(
                centerX - radius, centerY - radius, outerSize, outerSize);
        g.fill(outerCircle);

        // Set brush for border color
        g.setBrush(getScaleColor().toBrush());
        g.stroke(outerCircle);

        // Inner gauge area
        g.setBrush(getBackgroundColor().toBrush());
        double innerSize = gaugeRadius * 2;
        BEllipseGeom innerCircle = BEllipseGeom.make(
                centerX - gaugeRadius, centerY - gaugeRadius, innerSize, innerSize);
        g.fill(innerCircle);
    }

    private void drawWarningZones(Graphics g) {
        if (!getShowZones()) return;

        double minVal = getMinValue();
        double maxVal = getMaxValue();
        double startAngleRad = Math.toRadians(getStartAngle());
        double sweepAngleRad = Math.toRadians(getSweepAngle());

        // Warning zone
        drawColorZone(g, getWarningMin(), getWarningMax(),
                getWarningColor(), minVal, maxVal, startAngleRad, sweepAngleRad);

        // Critical zone
        drawColorZone(g, getCriticalMin(), getCriticalMax(),
                getCriticalColor(), minVal, maxVal, startAngleRad, sweepAngleRad);
    }

    private void drawColorZone(Graphics g, double zoneMin, double zoneMax,
                               BColor color, double minVal, double maxVal,
                               double startAngle, double sweepAngle) {

        double zoneStartAngle = startAngle +
                ((zoneMin - minVal) / (maxVal - minVal)) * sweepAngle;
        double zoneEndAngle = startAngle +
                ((zoneMax - minVal) / (maxVal - minVal)) * sweepAngle;

        g.setBrush(color.toBrush());

        // Draw arc for the zone
        double zoneWidth = 10;
        for (double r = gaugeRadius - zoneWidth; r <= gaugeRadius; r += 2) {
            for (double angle = zoneStartAngle; angle <= zoneEndAngle; angle += 0.1) {
                double x = centerX + Math.cos(angle) * r;
                double y = centerY + Math.sin(angle) * r;
                g.fill(BEllipseGeom.make(x - 1, y - 1, 2, 2));
            }
        }
    }

    private void drawScale(Graphics g) {
        if (!getShowScale()) return;

        g.setBrush(getScaleColor().toBrush());
        g.setFont(getScaleFont());

        double minVal = getMinValue();
        double maxVal = getMaxValue();
        double startAngleRad = Math.toRadians(getStartAngle());
        double sweepAngleRad = Math.toRadians(getSweepAngle());
        int majorTicksVal = getMajorTicks();
        int minorTicksVal = getMinorTicks();

        // Major tick marks and labels
        for (int i = 0; i <= majorTicksVal; i++) {
            double angle = startAngleRad + (i * sweepAngleRad / majorTicksVal);
            double value = minVal + (i * (maxVal - minVal) / majorTicksVal);

            // Major tick line
            double x1 = centerX + Math.cos(angle) * (gaugeRadius - 15);
            double y1 = centerY + Math.sin(angle) * (gaugeRadius - 15);
            double x2 = centerX + Math.cos(angle) * (gaugeRadius - 5);
            double y2 = centerY + Math.sin(angle) * (gaugeRadius - 5);

            g.setPen(BPen.make(2));  // Width only
            g.setBrush(getScaleColor().toBrush());  // Color separately
            g.strokeLine(x1, y1, x2, y2);

            // Scale labels
            String label = formatValue(value);
            double labelX = centerX + Math.cos(angle) * (gaugeRadius - 25);
            double labelY = centerY + Math.sin(angle) * (gaugeRadius - 25);

            BFont font = getScaleFont();
            double textWidth = font.width(label);
            double textHeight = font.getHeight();

            g.drawString(label, labelX - textWidth / 2, labelY + textHeight / 2);

            // Minor ticks between major ticks
            if (i < majorTicksVal && minorTicksVal > 0) {
                double minorAngleStep = (sweepAngleRad / majorTicksVal) / (minorTicksVal + 1);
                for (int j = 1; j <= minorTicksVal; j++) {
                    double minorAngle = angle + (j * minorAngleStep);
                    double mx1 = centerX + Math.cos(minorAngle) * (gaugeRadius - 10);
                    double my1 = centerY + Math.sin(minorAngle) * (gaugeRadius - 10);
                    double mx2 = centerX + Math.cos(minorAngle) * (gaugeRadius - 5);
                    double my2 = centerY + Math.sin(minorAngle) * (gaugeRadius - 5);

                    g.setPen(BPen.make(1));  // Width only
                    g.setBrush(getScaleColor().toBrush());  // Color separately
                    g.strokeLine(mx1, my1, mx2, my2);
                }
            }
        }
    }

    private void drawNeedle(Graphics g) {
        double value = getValue();
        double minVal = getMinValue();
        double maxVal = getMaxValue();

        // Clamp value to range
        value = Math.max(minVal, Math.min(maxVal, value));

        // Calculate needle angle
        double startAngleRad = Math.toRadians(getStartAngle());
        double sweepAngleRad = Math.toRadians(getSweepAngle());
        double valueAngle = startAngleRad + ((value - minVal) / (maxVal - minVal)) * sweepAngleRad;

        // Calculate needle tip position
        double tipX = centerX + Math.cos(valueAngle) * needleLength;
        double tipY = centerY + Math.sin(valueAngle) * needleLength;

        // Draw needle
        g.setBrush(getNeedleColor().toBrush());
        g.setPen(BPen.make(3));  // Width only

        // Main needle line
        g.strokeLine(centerX, centerY, tipX, tipY);

        // Optional: Draw needle as triangle for better visibility
        double needleWidth = 8;
        double baseAngle1 = valueAngle + Math.PI / 2;
        double baseAngle2 = valueAngle - Math.PI / 2;

        double base1X = centerX + Math.cos(baseAngle1) * needleWidth / 2;
        double base1Y = centerY + Math.sin(baseAngle1) * needleWidth / 2;
        double base2X = centerX + Math.cos(baseAngle2) * needleWidth / 2;
        double base2Y = centerY + Math.sin(baseAngle2) * needleWidth / 2;

        double[] xCoords = { tipX, base1X, base2X };
        double[] yCoords = { tipY, base1Y, base2Y };
        BPolygonGeom needle = BPolygonGeom.make(xCoords, yCoords);
        g.fill(needle);
    }

    private void drawCenterHub(Graphics g) {
        // Center hub
        g.setBrush(getNeedleColor().toBrush());
        double hubSize = 12;
        BEllipseGeom hub = BEllipseGeom.make(
                centerX - hubSize / 2, centerY - hubSize / 2, hubSize, hubSize);
        g.fill(hub);

        // Inner hub highlight
        g.setBrush(getBackgroundColor().toBrush());
        double innerHubSize = 6;
        BEllipseGeom innerHub = BEllipseGeom.make(
                centerX - innerHubSize / 2, centerY - innerHubSize / 2,
                innerHubSize, innerHubSize);
        g.fill(innerHub);
    }

    private void drawLabels(Graphics g) {
        g.setBrush(getTextColor().toBrush());

        // Title
        if (getShowTitle()) {
            g.setFont(getTitleFont());
            String t = getTitle();
            BFont titleFont = getTitleFont();
            double titleWidth = titleFont.width(t);
            g.drawString(t, centerX - titleWidth / 2, centerY - radius / 2);
        }

        // Current value / text
        if (getShowValue()) {
            g.setFont(getValueFont());

            String valueText = getText();
            if (valueText == null || valueText.length() == 0) {
                // Fallback if nothing bound into "text"
                valueText = formatValue(getValue());
            }

            BFont valueFont = getValueFont();
            double valueWidth = valueFont.width(valueText);
            g.drawString(valueText, centerX - valueWidth / 2, centerY + radius / 3);
        }
    }

    private String formatValue(double value) {
        int prec = getPrecision();
        if (prec == 0) {
            return String.valueOf((int) value);
        } else {
            return String.format("%." + prec + "f", value);
        }
    }
}

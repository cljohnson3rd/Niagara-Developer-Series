package com.devseries.myFirstModule.ui.Widgets;

import javax.baja.gx.BBrush;
import javax.baja.gx.BEllipseGeom;
import javax.baja.gx.BPolygonGeom;
import javax.baja.gx.Graphics;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.ui.BLabel;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.event.BMouseEvent;

@NiagaraType
@NiagaraProperty(name = "borderBrush", type = "BBrush", defaultValue = "BBrush.NULL")
@NiagaraProperty(name = "borderWidth", type = "double", defaultValue = "0.0")
@NiagaraProperty(name = "cornerRadius", type = "double", defaultValue = "0.0")

@NiagaraProperty(name = "hoverEnabled", type = "boolean", defaultValue = "true")
@NiagaraProperty(name = "hoverBackground", type = "BBrush", defaultValue = "BBrush.NULL")
@NiagaraProperty(name = "hoverBorderBrush", type = "BBrush", defaultValue = "BBrush.NULL")
@NiagaraProperty(name = "hoverTextBrush", type = "BBrush", defaultValue = "BBrush.NULL")


public class BModernLabel extends BLabel
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.devseries.myFirstModule.ui.Widgets.BModernLabel(2841417650)1.0$ @*/
/* Generated Mon Nov 24 20:18:04 EST 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "borderBrush"

  /**
   * Slot for the {@code borderBrush} property.
   * @see #getBorderBrush
   * @see #setBorderBrush
   */
  public static final Property borderBrush = newProperty(0, BBrush.NULL, null);

  /**
   * Get the {@code borderBrush} property.
   * @see #borderBrush
   */
  public BBrush getBorderBrush() { return (BBrush)get(borderBrush); }

  /**
   * Set the {@code borderBrush} property.
   * @see #borderBrush
   */
  public void setBorderBrush(BBrush v) { set(borderBrush, v, null); }

  //endregion Property "borderBrush"

  //region Property "borderWidth"

  /**
   * Slot for the {@code borderWidth} property.
   * @see #getBorderWidth
   * @see #setBorderWidth
   */
  public static final Property borderWidth = newProperty(0, 0.0, null);

  /**
   * Get the {@code borderWidth} property.
   * @see #borderWidth
   */
  public double getBorderWidth() { return getDouble(borderWidth); }

  /**
   * Set the {@code borderWidth} property.
   * @see #borderWidth
   */
  public void setBorderWidth(double v) { setDouble(borderWidth, v, null); }

  //endregion Property "borderWidth"

  //region Property "cornerRadius"

  /**
   * Slot for the {@code cornerRadius} property.
   * @see #getCornerRadius
   * @see #setCornerRadius
   */
  public static final Property cornerRadius = newProperty(0, 0.0, null);

  /**
   * Get the {@code cornerRadius} property.
   * @see #cornerRadius
   */
  public double getCornerRadius() { return getDouble(cornerRadius); }

  /**
   * Set the {@code cornerRadius} property.
   * @see #cornerRadius
   */
  public void setCornerRadius(double v) { setDouble(cornerRadius, v, null); }

  //endregion Property "cornerRadius"

  //region Property "hoverEnabled"

  /**
   * Slot for the {@code hoverEnabled} property.
   * @see #getHoverEnabled
   * @see #setHoverEnabled
   */
  public static final Property hoverEnabled = newProperty(0, true, null);

  /**
   * Get the {@code hoverEnabled} property.
   * @see #hoverEnabled
   */
  public boolean getHoverEnabled() { return getBoolean(hoverEnabled); }

  /**
   * Set the {@code hoverEnabled} property.
   * @see #hoverEnabled
   */
  public void setHoverEnabled(boolean v) { setBoolean(hoverEnabled, v, null); }

  //endregion Property "hoverEnabled"

  //region Property "hoverBackground"

  /**
   * Slot for the {@code hoverBackground} property.
   * @see #getHoverBackground
   * @see #setHoverBackground
   */
  public static final Property hoverBackground = newProperty(0, BBrush.NULL, null);

  /**
   * Get the {@code hoverBackground} property.
   * @see #hoverBackground
   */
  public BBrush getHoverBackground() { return (BBrush)get(hoverBackground); }

  /**
   * Set the {@code hoverBackground} property.
   * @see #hoverBackground
   */
  public void setHoverBackground(BBrush v) { set(hoverBackground, v, null); }

  //endregion Property "hoverBackground"

  //region Property "hoverBorderBrush"

  /**
   * Slot for the {@code hoverBorderBrush} property.
   * @see #getHoverBorderBrush
   * @see #setHoverBorderBrush
   */
  public static final Property hoverBorderBrush = newProperty(0, BBrush.NULL, null);

  /**
   * Get the {@code hoverBorderBrush} property.
   * @see #hoverBorderBrush
   */
  public BBrush getHoverBorderBrush() { return (BBrush)get(hoverBorderBrush); }

  /**
   * Set the {@code hoverBorderBrush} property.
   * @see #hoverBorderBrush
   */
  public void setHoverBorderBrush(BBrush v) { set(hoverBorderBrush, v, null); }

  //endregion Property "hoverBorderBrush"

  //region Property "hoverTextBrush"

  /**
   * Slot for the {@code hoverTextBrush} property.
   * @see #getHoverTextBrush
   * @see #setHoverTextBrush
   */
  public static final Property hoverTextBrush = newProperty(0, BBrush.NULL, null);

  /**
   * Get the {@code hoverTextBrush} property.
   * @see #hoverTextBrush
   */
  public BBrush getHoverTextBrush() { return (BBrush)get(hoverTextBrush); }

  /**
   * Set the {@code hoverTextBrush} property.
   * @see #hoverTextBrush
   */
  public void setHoverTextBrush(BBrush v) { set(hoverTextBrush, v, null); }

  //endregion Property "hoverTextBrush"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BModernLabel.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    private boolean mouseOver = false;

    public BModernLabel() {}

    @Override
    public boolean receiveInputEvents() {
        return getHoverEnabled() || hasBindings();
    }

    /* ===== Hover ===== */

    @Override
    public void mouseEntered(BMouseEvent event) {
        if (!getHoverEnabled()) return;
        mouseOver = true;
        repaint();
    }

    @Override
    public void mouseExited(BMouseEvent event) {
        if (!getHoverEnabled()) return;
        mouseOver = false;
        repaint();
    }

    /* ===== Background with optional shadow ===== */

    @Override
    protected void paintBackground(Graphics g, BBrush labelBackground) {
        g.useAntiAliasing(true);

        double w = getWidth();
        double h = getHeight();
        double r = Math.max(0.0, Math.min(getCornerRadius(), Math.min(w, h) / 2.0));

        // Determine the final background:
        //   1) HoverBackground (if set)
        //   2) Label’s built-in background property
        BBrush bg = labelBackground;

        if (mouseOver && getHoverEnabled() && !getHoverBackground().isNull()) {
            bg = getHoverBackground();
        }

        // Background
        if (!bg.isNull()) {
            g.setBrush(bg);
            fillCapsule(g, 0.0, 0.0, w, h, r);
        }
    }

    /* ===== Text with optional hover color ===== */

    @Override
    protected void paintText(Graphics g, String text, double tx, double ty) {
        g.push();
        try {
            if (mouseOver && getHoverEnabled() && !getHoverTextBrush().isNull()) {
                g.setBrush(getHoverTextBrush());
            }
            g.useFractionalFontMetrics(true);
            g.drawString(text, tx, ty);
        } finally {
            g.pop();
        }
    }

    /* ===== Border on top ===== */

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BBrush border = getBorderBrush();
        if (mouseOver && getHoverEnabled() && !getHoverBorderBrush().isNull()) {
            border = getHoverBorderBrush();
        }

        double bw = getBorderWidth();
        if (border.isNull() || bw <= 0.0) return;

        double inset = bw / 2.0;
        double w = getWidth()  - bw;
        double h = getHeight() - bw;
        double r = Math.max(0.0, Math.min(getCornerRadius(), Math.min(w, h) / 2.0));

        g.push();
        try {
            g.useAntiAliasing(true);
            g.setBrush(border);
            strokeCapsule(g, inset, inset, w, h, r);
        } finally {
            g.pop();
        }
    }

    /* ===== Capsule helpers ===== */

    private void fillCapsule(Graphics g, double x, double y, double w, double h, double radius) {
        double r = Math.min(radius, h / 2.0);
        if (r <= 0.0) {
            g.fillRect(x, y, w, h);
            return;
        }
        double cxL = x + r;
        double cxR = x + w - r;
        double cy = y + h / 2.0;
        double d = r * 2.0;

        g.fillRect(cxL, y, cxR - cxL, h);
        g.fill(BEllipseGeom.make(cxL - r, cy - r, d, d));
        g.fill(BEllipseGeom.make(cxR - r, cy - r, d, d));
    }

    private void strokeCapsule(Graphics g, double x, double y, double w, double h, double radius)
    {
        double r = Math.min(radius, h / 2.0);
        if (r <= 0.0) {
            g.strokeRect(x, y, w, h);
            return;
        }

        double cxLeft  = x + r;
        double cxRight = x + w - r;
        double cy      = y + h / 2.0;

        // How many segments to approximate each semicircle
        final int STEPS = 32;

        // Points around the outer perimeter:
        //  - right arc: top -> bottom
        //  - bottom edge: right -> left
        //  - left arc: bottom -> top
        //  - top edge: left -> right
        int maxPoints = (STEPS + 1)   // right arc
                + 1             // bottom-left corner
                + (STEPS + 1)   // left arc
                + 1;            // back to top-right
        double[] xs = new double[maxPoints];
        double[] ys = new double[maxPoints];
        int idx = 0;

        // 1) Right semicircle: from -90° (top) to +90° (bottom)
        for (int i = 0; i <= STEPS; i++) {
            double theta = -Math.PI / 2.0 + (Math.PI * i / STEPS);
            xs[idx] = cxRight + Math.cos(theta) * r;
            ys[idx] = cy      + Math.sin(theta) * r;
            idx++;
        }

        // 2) Bottom straight edge: from bottom-right to bottom-left
        xs[idx] = cxLeft;
        ys[idx] = cy + r;
        idx++;

        // 3) Left semicircle: from +90° (bottom) to +270° (top)
        for (int i = 0; i <= STEPS; i++) {
            double theta = Math.PI / 2.0 + (Math.PI * i / STEPS);
            xs[idx] = cxLeft + Math.cos(theta) * r;
            ys[idx] = cy     + Math.sin(theta) * r;
            idx++;
        }

        // 4) Top straight edge: from top-left back to top-right
        xs[idx] = cxRight;
        ys[idx] = cy - r;
        idx++;

        // Build polygon and stroke its outline – this gives you a single, smooth pill border
        BPolygonGeom outline = BPolygonGeom.make(xs, ys);
        g.stroke(outline);
    }

}

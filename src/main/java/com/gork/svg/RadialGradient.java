/**
 * 
 * The <linearGradient> SVG element lets authors define linear gradients to apply to other SVG elements.
 * 
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class RadialGradient extends SvgElement {

	public RadialGradient() {
		super("radialGradient");
	}

	public void setR(double val) {
		this.getElement().setAttribute("r", String.valueOf(val));
	}

	public void setCx(double val) {
		this.getElement().setAttribute("cx", String.valueOf(val));
	}

	public void setCy(double val) {
		this.getElement().setAttribute("cy", String.valueOf(val));
	}

	public void setFr(double val) {
		this.getElement().setAttribute("fr", String.valueOf(val));
	}

	public void setFx(double val) {
		this.getElement().setAttribute("fx", String.valueOf(val));
	}

	public void setFy(double val) {
		this.getElement().setAttribute("fy", String.valueOf(val));
	}

	/**
	 * eg "rotate(90)"
	 * @param val
	 */
	public void setGradientTransform(String val) {
		this.getElement().setAttribute("gradientTransform", val);
	}

}

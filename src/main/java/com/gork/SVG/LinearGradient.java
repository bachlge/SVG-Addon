/**
 * 
 * The <linearGradient> SVG element lets authors define linear gradients to apply to other SVG elements.
 * 
 */
package com.gork.SVG;

@SuppressWarnings("serial")
public class LinearGradient extends SvgElement {

	public LinearGradient() {
		super("linearGradient");
	}

	public void setX1(double val) {
		this.getElement().setAttribute("x1", String.valueOf(val));
	}

	public void setY1(double val) {
		this.getElement().setAttribute("y1", String.valueOf(val));
	}

	public void setX2(double val) {
		this.getElement().setAttribute("x2", String.valueOf(val));
	}

	public void setY2(double val) {
		this.getElement().setAttribute("y2", String.valueOf(val));
	}

	/**
	 * eg "rotate(90)"
	 * @param val
	 */
	public void setGradientTransform(String val) {
		this.getElement().setAttribute("gradientTransform", val);
	}

}

/**
 * 
 * The <circle> SVG element is an SVG basic shape, used to draw circles based on a center point and a radius.
 * 
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class Circle extends SvgElement {

	public Circle() {
		super("circle");
	}

	/**
	 * Convenience Constructor
	 * @param cx
	 * @param cy
	 * @param r
	 */
	public Circle(double cx, double cy, double r) {
		this();
		setCenter(cx, cy);
		setRadius(r);
	}

	/**
	 * Convenience Method
	 */
	public void setCenter(double cx, double cy) {
		setCx(cx);
		setCy(cy);
	}

	/**
	 * Convenience Method
	 */
	public void setCenter(Point p) {
		setCenter(p.getX(), p.getY());
	}


	public void setRadius(double r) {
		this.getElement().setAttribute("r", String.valueOf(r));
	}

	public void setCx(double cx) {
		this.getElement().setAttribute("cx", String.valueOf(cx));
	}

	public void setCy(double cy) {
		this.getElement().setAttribute("cy", String.valueOf(cy));
	}

}

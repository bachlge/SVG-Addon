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

	public void setCenter(double x, double y) {
		setX(x);
		setY(y);
	}

	public void setCenter(Point p) {
		setX(p.getX());
		setY(p.getY());
	}


	public void setRadius(double r) {
		this.getElement().setAttribute("r", String.valueOf(r));

	}

	public void setX(double cx) {
		this.getElement().setAttribute("cx", String.valueOf(cx));
	}

	public void setY(double cy) {
		this.getElement().setAttribute("cy", String.valueOf(cy));
	}

}

/**
 * 
 * The <line> SVG element is an SVG basic shape used to create a line connecting two points.
 * 
 */
package com.gork.svg.elements;

import com.vaadin.flow.component.HasStyle;

@SuppressWarnings("serial")
public class Line extends SvgElement implements HasStyle {

	public Line() {
		super("line");
		this.getElement().setAttribute("stroke", "black");
	}

	public Line(double x1, double y1, double x2, double y2) {
		this();
		setX1(x1);
		setY1(y1);
		setX2(x2);
		setY2(y2);
	}

	/**
	 * Set X1 (X-Coordinate of the Start Point)
	 * @param val
	 */
	public void setX1(double val) {
		this.getElement().setAttribute("x1", String.valueOf(val));
	}

	/**
	 * Set Y1 (Y-Coordinate of the Start Point)
	 * @param val
	 */
	public void setY1(double val) {
		this.getElement().setAttribute("y1", String.valueOf(val));
	}

	/**
	 * Set X2 (X-Coordinate of the End Point)
	 * @param val
	 */
	public void setX2(double val) {
		this.getElement().setAttribute("x2", String.valueOf(val));
	}

	/**
	 * Set Y2 (Y-Coordinate of the End Point)
	 * @param val
	 */
	public void setY2(double val) {
		this.getElement().setAttribute("y2", String.valueOf(val));
	}

	public void setPathLength(double val) {
		this.getElement().setAttribute("pathLength", String.valueOf(val));
	}

	/**
	 * Convenience Method:
	 * Set X and Y Coordinate of the Start Point
	 * @param x double x1-cordinate
	 * @param y double y1-cordinate
	 */
	public void setStart(double x, double y) {
		setX1(x);
		setY1(y);
	}

	/**
	 * Convenience Method:
	 * Set X and Y Coordinate of the End Point
	 * @param x double x2-cordinate
	 * @param y double y2-cordinate
	 */
	public void setEnd(double x, double y) {
		setX2(x);
		setY2(y);
	}

}

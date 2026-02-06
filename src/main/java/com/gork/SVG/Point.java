/**
 * 
 * The <polygon> SVG element defines a closed shape consisting of a set of connected straight line segments.
 * The last point is connected to the first point.
 * 
 * For open shapes, see the <polyline> element.
 * 
*/
package com.gork.SVG;

public class Point {

	private double x = 0;
	private double y = 0;

	public Point() {
		super();
	}

	public Point(double x, double y) {
		this();
		setX(x);
		setY(y);
	}

	public double getX() {
		return this.x;
	}

	public void setX(double val) {
		this.x = val;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double val) {
		this.y = val;
	}

	public String toString() {
		return getX() + "," + getY();
	}

}

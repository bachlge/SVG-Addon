/**
 * 
 * The <polygon> SVG element defines a closed shape consisting of a set of connected straight line segments.
 * The last point is connected to the first point.
 * 
 * For open shapes, see the <polyline> element.
 * 
*/
package com.gork.svg;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class Polygon extends SvgElement {

	public Polygon() {
		super("polygon");
	}

	public Polygon(Point... points) {
		this();
		setPoints(points);
	}

	public Polygon(Set<Point> points) {
		this();
		setPoints(points);
	}

	public void setPoints(Point... points) {
		Arrays.stream(points).map(p -> p.toString()).collect(Collectors.joining(" "));
	}

	public void setPoints(Set<Point> points) {
		points.stream().map(p -> p.toString()).collect(Collectors.joining(" "));
	}

	public void setPoints(String val) {
		this.getElement().setAttribute("points", val);
	}

	public void setPathLength(double val) {
		System.out.println(">>>>>>>>>Polygon-Path=" + val);
		this.getElement().setAttribute("pathLength", String.valueOf(val));
	}

}

/**
 * 
 * The <polyline> SVG element is an SVG basic shape that creates straight lines connecting several points.
 * Typically a polyline is used to create open shapes as the last point doesn't have to be connected to the first point.
 * 
 * For closed shapes see the <polygon> element.
 * 
 */
package com.gork.svg;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
public class Polyline extends SvgElement {

	public Polyline() {
		super("polyline");
	}

	public Polyline(Point... points) {
		this();
		setPoints(points);
	}

	public Polyline(Set<Point> points) {
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
		this.getElement().setAttribute("pathLength", String.valueOf(val));
	}

}

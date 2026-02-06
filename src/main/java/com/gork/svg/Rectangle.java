package com.gork.svg;

@SuppressWarnings("serial")
public class Rectangle extends SvgElement {

	public Rectangle() {
		super("rect");
	}

	public void define(double x, double y, double w, double h) {
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
	}

	public void define(Point p, double w, double h) {
		setX(p.getX());
		setY(p.getY());
		setWidth(w);
		setHeight(h);
	}

	public void setX(double x) {
		this.getElement().setAttribute("x", String.valueOf(x));
	}

	public void setY(double y) {
		this.getElement().setAttribute("y", String.valueOf(y));
	}

	public void setWidth(double w) {
		this.getElement().setAttribute("width", String.valueOf(w));
	}

	public void setHeight(double h) {
		this.getElement().setAttribute("height", String.valueOf(h));
	}

}

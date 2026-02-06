package com.gork.SVG;

@SuppressWarnings("serial")
public class Path extends SvgElement {

	public Path() {
		super("path");
	}

	public void setD(String val) {
		this.getElement().setAttribute("d", val);
	}

}

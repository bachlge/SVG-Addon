/**
 * 
 * The <path> SVG element is the generic element to define a shape.
 * All the basic shapes can be created with a path element.
 * 
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class Path extends SvgElement {

	public Path() {
		super("path");
	}

	public void setD(String val) {
		this.getElement().setAttribute("d", val);
	}

}

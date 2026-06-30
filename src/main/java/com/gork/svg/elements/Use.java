/**
 * 
 * The <use> element takes nodes from within an SVG document, and duplicates them somewhere else. 
 * he effect is the same as if the nodes were deeply cloned into a non-exposed DOM, then pasted where the <use> element is,
 * much like cloned <template> elements.
 * 
 */
package com.gork.svg.elements;

@SuppressWarnings("serial")
public class Use extends SvgElement {

	public Use() {
		super("use");
	}

	public void setHref(String val) {
		this.getElement().setAttribute("gref", val);
	}

}

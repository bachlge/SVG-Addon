/**
 * 
 * The <defs> SVG element is used to store graphical objects that will be used at a later time.
 * Objects created inside a <defs> element are not rendered directly.
 * To display them you have to reference them (with a <use> element for example).
 * 
 * Graphical objects can be referenced from anywhere, however, defining these objects inside of a <defs> element
 * promotes understandability of the SVG content and is beneficial to the overall accessibility of the document.
 * 
 */
package com.gork.svg;

import com.vaadin.flow.component.HasComponents;

@SuppressWarnings("serial")
public class Defs extends SvgElement implements HasComponents {

	public Defs() {
		super("defs");
	}

}

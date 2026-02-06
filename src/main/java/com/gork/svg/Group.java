/**
 * 
 * The <g> SVG element is a container used to group other SVG elements.
 * 
 * Transformations applied to the <g> element are performed on its child elements, and its attributes are inherited by its children.
 * It can also group multiple elements to be referenced later with the <use> element.
 * 
 */
package com.gork.svg;

import com.vaadin.flow.component.HasComponents;

@SuppressWarnings("serial")
public class Group extends SvgElement implements HasComponents {

	public Group() {
		super("g");
	}

}

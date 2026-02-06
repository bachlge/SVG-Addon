/**
 * 
 * The <svg> SVG element is a container that defines a new coordinate system and viewport.
 * It is used as the outermost element of SVG documents, but it can also be used to embed an SVG fragment inside an SVG or HTML document.
 * 
 * This element is for creating new SVG documents.
 * If you have an existing SVG document to embed in another document via URL, use <img>, <object>, or <image>.
 * 
 */
package com.gork.SVG;

import com.vaadin.flow.component.HasSize;

@SuppressWarnings("serial")
public class SvgContainer extends SvgElement implements HasSize {

	public SvgContainer() {
		super("svg");
	}

}

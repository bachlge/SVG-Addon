/**
 * 
 * The base class for every SVG-Element
 * 
 */
package com.gork.svg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.dom.Element;

@SuppressWarnings("serial")
public class SvgElement extends Component implements HasComponents {

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public SvgElement() {
		super();
	}

	/**
	 * most common constructor
	 * 
	 * used like `super("path");`
	 * @param tag
	 */
	public SvgElement(String tag) {
		super(new Element(tag));
	}

	//========== these methods can be applied to any SVG-Element ==========//

	public void setFill(String val) {
		this.getElement().setAttribute("fill", val);
	}

	public void setStroke(String val) {
		this.getElement().setAttribute("stroke", val);
	}

	public void setTransform(String val) {
		this.getElement().setAttribute("transform", val);
	}

	public void setTransformTranslate(double x, double y) {
		setTransform(String.format("translate(%1s %2s)", x, y));
	}

}

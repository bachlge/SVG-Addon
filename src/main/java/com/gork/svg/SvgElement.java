/**
 * 
 * The base class for every SVG-Element
 * 
 */
package com.gork.svg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.shared.Registration;

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

	public void setStrokeWidth(String val) {
		this.getElement().setAttribute("stroke-width", val);
	}

	public void setStrokeOpacity(String val) {
		this.getElement().setAttribute("stroke-opacity", val);
	}

	public void setStrokeTransparent() {
		this.getElement().setAttribute("stroke-opacity", String.valueOf(0));
	}

	public void setTransform(String val) {
		this.getElement().setAttribute("transform", val);
	}

	public void setTransformTranslate(double x, double y) {
		setTransform(String.format("translate(%1s %2s)", x, y));
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<SvgElement> {

	    public ClickEvent(SvgElement source, boolean fromClient) {
	        super(source, fromClient);
	    }
	}

	public Registration addMouseOverListener(ComponentEventListener<MouseOverEvent> listener) {
		return addListener(MouseOverEvent.class, listener);
	}

	@DomEvent("mouseover")
	public static class MouseOverEvent extends ComponentEvent<SvgElement> {

	    public MouseOverEvent(SvgElement source, boolean fromClient) {
	        super(source, fromClient);
	    }
	}

}

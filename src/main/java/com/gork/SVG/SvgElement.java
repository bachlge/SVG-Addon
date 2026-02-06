package com.gork.SVG;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.dom.Element;

@SuppressWarnings("serial")
public class SvgElement extends Component implements HasComponents {
	
	public SvgElement() {
		super();
	}

	public SvgElement(Element e) {
		super(e);
	}

	public SvgElement(String tag) {
		super(new Element(tag));
	}

	public void setFill(String val) {
		this.getElement().setAttribute("fill", val);
	}

	public void setStroke(String val) {
		this.getElement().setAttribute("stroke", val);
	}

}

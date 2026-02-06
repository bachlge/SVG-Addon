package com.gork.SVG;

import java.util.Set;

import com.vaadin.flow.component.HasStyle;

@SuppressWarnings("serial")
public class Text extends SvgElement implements HasStyle {

	public Text() {
		super("text");
	}

	public void setX(double val) {
		this.getElement().setAttribute("x", String.valueOf(val));
	}

	public void setY(double val) {
		this.getElement().setAttribute("y", String.valueOf(val));
	}

	public void setRotate(Set<Number> setOfNumbers) {
	}

	public void setDx(double val) {
		this.getElement().setAttribute("dx", String.valueOf(val));
	}

	public void setDy(double val) {
		this.getElement().setAttribute("dy", String.valueOf(val));
	}

	public void setTextLength(double val) {
		this.getElement().setAttribute("textLength", String.valueOf(val));
	}

	public void setLengthAdjust(double val) {
		this.getElement().setAttribute("lengthAdjust", String.valueOf(val));
	}

	public void setText(String text) {
		add(text);
	}

	
}

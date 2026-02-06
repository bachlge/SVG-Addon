/**
 * 
 * The <text> SVG element draws a graphics element consisting of text.
 * It's possible to apply a gradient, pattern, clipping path, mask, or filter to <text>, like any other SVG graphics element.
 * 
 * If text is included in SVG not inside of a <text> element, it is not rendered.
 * This is different than being hidden by default, as setting the display property won't show the text.
 * 
 */
package com.gork.svg;

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

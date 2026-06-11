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

	/**
	 * Convenience Constructor directly adding the given text-String
	 * @param text
	 */
	public Text(String text) {
		this();
		add(text);
	}

	public void setX(double val) {
		this.getElement().setAttribute("x", String.valueOf(val));
	}

	public void setY(double val) {
		this.getElement().setAttribute("y", String.valueOf(val));
	}

	public void setPosition(double x, double y) {
		setX(x);
		setY(y);
	}

	public void setRotate(Set<Number> setOfNumbers) {
	}

	public void setRotate(Number val) {
		this.getElement().setAttribute("rotate", String.valueOf(val));
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

	public void setTextAnchor(TextAnchor val) {
		this.getElement().setAttribute("text-anchor", val.name());
	}

	public enum TextAnchor {
		start, middle, end,
	}

	public void setTextAlignmentBaseline(AlignmentBaseline val) {
		this.getElement().setAttribute("alignment-baseline", val.name());
	}

	public enum AlignmentBaseline {
		Baseline, Central, Hanging, Ideographic, Mathematical, Alphabetic,// "Before-edge", "After-edge", 
	}


}

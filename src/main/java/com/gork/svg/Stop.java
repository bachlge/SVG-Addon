/**
 * 
 * The <stop> SVG element defines a color and its position to use on a gradient.
 * This element is always a child of a <linearGradient> or <radialGradient> element.
 * 
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class Stop extends SvgElement {

	public Stop() {
		super("stop");
	}

	/**
	 * This attribute defines where the gradient stop is placed along the gradient vector.
	 * Value type: <number> | <percentage>; Default value: 0; Animatable: yes
	 * 
	 * @param val
	 */
	public void setOffset(double val) {
		this.getElement().setAttribute("offset", String.valueOf(val));
	}

	/**
	 * This attribute defines the color of the gradient stop. It can be used as a CSS property.
	 * Value type: <color>; Default value: black; Animatable: yes
	 * 
	 * @param val
	 */
	public void setStopColor(String val) {
		this.getElement().setAttribute("stop-color", val);
	}

	public void setStopOpacity(double val) {
		this.getElement().setAttribute("stop-opacity", String.valueOf(val));
	}
	
}

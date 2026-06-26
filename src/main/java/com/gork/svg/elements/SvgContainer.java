/**
 * 
 * The <svg> SVG element is a container that defines a new coordinate system and viewport.
 * It is used as the outermost element of SVG documents, but it can also be used to embed an SVG fragment inside an SVG or HTML document.
 * 
 * This element is for creating new SVG documents.
 * If you have an existing SVG document to embed in another document via URL, use <img>, <object>, or <image>.
 * 
 */
package com.gork.svg.elements;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
public class SvgContainer extends SvgElement implements HasSize {

	public SvgContainer() {
		super("svg");
	}

	/**
	 * Convenience Constructor, setting Width and Height
	 * @param width
	 * @param height
	 */
	public SvgContainer(double w, double h) {
		this();
		setViewportWidth(w);
		setViewportHeight(h);
	}

	/**
	 * The displayed x coordinate of the svg container.
	 * Default value: 0
	 * @param x
	 */
	public void setX(double x) {
		this.getElement().setAttribute("x", String.valueOf(x));
	}

	public double getX() {
		return Double.parseDouble(this.getElement().getAttribute("x"));
	}

	/**
	 * The displayed y coordinate of the svg container.
	 * Default value: 0.
	 * @param y
	 */
	public void setY(double y) {
		this.getElement().setAttribute("y", String.valueOf(y));
	}

	public double getY() {
		return Double.parseDouble(this.getElement().getAttribute("y"));
	}

	/**
	 * The displayed width of the rectangular viewport.
	 * Default value: auto.
	 * @param w
	 */
	public void setViewportWidth(double w) {
		this.getElement().setAttribute("width", String.valueOf(w));
	}

	public double getViewportWidth() {
		return Double.parseDouble(this.getElement().getAttribute("width"));
	}

	/**
	 * The displayed height of the rectangular viewport.
	 * Default value: auto.
	 * @param h
	 */
	public void setViewportHeight(double h) {
		this.getElement().setAttribute("height", String.valueOf(h));
	}

	public double getViewportHeight() {
		return Double.parseDouble(this.getElement().getAttribute("height"));
	}


	/**
	 * Wenn das viewBox-Attribut fehlt, ist das Benutzer-Koordinatensystem identisch mit dem Viewport-Koordinatensystem.
	 * @param minX
	 * @param minY
	 * @param width
	 * @param height
	 */
	public void setViewBox(double minX, double minY, double width, double height) {
		this.getElement().setAttribute("viewBox", String.format("%s %s %s %s", minX, minY, width, height));
	}

	public void setViewBox(String viewBox) {
		this.getElement().setAttribute("viewBox", viewBox);
	}

	/**
	 * 
	 * @param AspectRatio
	 * TODO: the AspectRatio as parameter is not really good because they can be combined
	 */
	public void setPreserveAspectRatio(AspectRatio val) {
		this.getElement().setAttribute("preserveAspectRatio", val.toString());
	}

	public enum AspectRatio { none, xMinYMin, xMidYMin, xMaxYMin, xMinYMid, xMidYMid, xMaxYMid, xMinYMax, xMidYMax, xMaxYMax, meet, slice, }


	public Registration addZoomListener(ComponentEventListener<ZoomEvent> listener) {
		return addListener(ZoomEvent.class, listener);
	}

	/**
	 * Trackpads use the wheel event for both two-finger scrolling and two-finger pinching (zooming).
	 * Production-grade web tools differentiate between them by checking the e.ctrlKey property:
	 * e.ctrlKey === false: The user is performing a two-finger scroll / pan.
	 * e.ctrlKey === true: The user is pinching to zoom
	 * (the browser intentionally passes a fake Ctrl key flag during pinches).
	 */
	@DomEvent("wheel")
	public static class ZoomEvent extends ComponentEvent<SvgContainer> {

	    public ZoomEvent(SvgContainer source, boolean fromClient) {
	        super(source, fromClient);
	    }
	}


}

/**
 * 
 * The <marker> SVG element defines a graphic used for drawing arrowheads or polymarkers on a
 * given <path>, <line>, <polyline> or <polygon> element.
 * 
 * Markers can be attached to shapes using the marker-start, marker-mid, and marker-end properties.
 * 
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class Marker extends SvgElement {

	public Marker() {
		super("marker");
	}

	public void setMarkerHeight(double val) {
		this.getElement().setAttribute("markerHeight", String.valueOf(val));
	}

	public void setMarkerWidth(double val) {
		this.getElement().setAttribute("markerWidth", String.valueOf(val));
	}

	public void setMarkerUnits(double val) {
		this.getElement().setAttribute("markerUnits", String.valueOf(val));
	}

	public void setOrient(double val) {
		this.getElement().setAttribute("orient", String.valueOf(val));
	}

	public void setRefX(double val) {
		this.getElement().setAttribute("refX", String.valueOf(val));
	}

	public void setRefY(double val) {
		this.getElement().setAttribute("refY", String.valueOf(val));
	}

	/**
	 * 
	 * This attribute defines how the svg fragment must be deformed if it is embedded in a container with a different aspect ratio.
	 * 
	 * Default: xMidYMid meet
	 * @param val
	 */
	public void setPreserveAspectRatio(AspectRatio val) {
		this.getElement().setAttribute("href", val.toString());
	}

	public enum AspectRatio { none, xMinYMin, xMidYMin, xMaxYMin, xMinYMid, xMidYMid, xMaxYMid, xMinYMax, xMidYMax, xMaxYMax }


}

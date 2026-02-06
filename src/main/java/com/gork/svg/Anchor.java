/**
 * 
 * The <a> SVG element creates a hyperlink to other web pages, files, locations in the same page, email addresses, or any other URL.
 * It is very similar to HTML's <a> element.
 * 
 * SVG's <a> element is a container, which means you can create a link around text (like in HTML) but also around any shape.
 * 
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class Anchor extends SvgElement {

	public Anchor() {
		super("a");
	}

	public void setHref(String val) {
		this.getElement().setAttribute("href", val);
	}

	public void setDownload(String val) {
		this.getElement().setAttribute("download", val);
	}

	public void setTarget(Target val) {
		this.getElement().setAttribute("href", val.toString());
	}

	public enum Target { _self, _parent, _top, _blank }

}

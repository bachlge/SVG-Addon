package com.gork.SVG;

@SuppressWarnings("serial")
public class Heart extends Path {

	public Heart() {
		setD("M 10,30 " +
		   	"A 20,20 0,0,1 50,30 " +
			"A 20,20 0,0,1 90,30 " +
		   	"Q 90,60 50,90 " + 
			"Q 10,60 10,30 z");
		setStroke("red");
		setFill("none");
	}

}

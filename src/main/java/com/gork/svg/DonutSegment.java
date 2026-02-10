/**
 * 
 * Convenience class for creating a path like the d3-arc()
 * 
 * const arc = d3.arc()
 *   .innerRadius(0)
 *   .outerRadius(100)
 *   .startAngle(0)
 *   .endAngle(Math.PI / 2);  // "M0,-100A100,100,0,0,1,100,0L0,0Z"
 *
 */
package com.gork.svg;

@SuppressWarnings("serial")
public class DonutSegment extends Path {

	private double x = 0;		// center x coordinate
	private double y = 0;		// center y coordinate
	private double r1 = 0;		// inner radius
	private double r2 = 0;		// outer radius
	private double a1 = 0;		// start angle
	private double a2 = 0;		// end angle

	private String path = "";	// resulting path

	public DonutSegment() {
		super();

		// nice color and no fill by default
		setStroke("skyblue");
		setFill("none");
	}

	public void setCenter(double x, double y) {
		setX(x);
		setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double val) {
		this.x = val;
		calcPath();
	}
	
	public double getY() {
		return y;
	}

	public void setY(double val) {
		this.y = val;
		calcPath();
	}
	
	public double getInnerRadius() {
		return r1;
	}

	public void setInnerRadius(double val) {
		this.r1 = val;
		calcPath();
	}

	public double getOuterRaduis() {
		return r2;
	}

	public void setOuterRadius(double val) {
		this.r2 = val;
		calcPath();
	}
	
	public double getStartAngle() {
		return a1;
	}

	public void setStartAngle(double val) {
		this.a1 = val;
		calcPath();
	}

	public double getEndAngle() {
		return a2;
	}

	public void setEndAngle(double val) {
		this.a2 = val;
		calcPath();
	}

	/**
	 * 
	 * After each set method: calculate the path
	 * so the getPath()-method will return the correct path at any time
	 * 
	 * Donut-Sector:
	 *  - Move to starting point (M to lower left corner ll)
	 *  - draw an arc to lower right corner (A to lr with radius = distL)
	 *  - draw a radial line to upper right corner (L to ur)
	 *  - draw an arc to upper left corner (A to ul with radius = distU)
	 *  - close (Z = radial line to lower left corner ll)
	 * 
	 * where:
	 *   M = moveto
	 *   L = lineto
	 *   A = elliptical Arc
	 *   Z = closepath
	 *   
	 *   Capital letters means absolutely positioned, lower cases means relatively positioned.
	 *   NOTE: double values need to be parsed as strings, otherwise will raise an exception!
	 *   NOTE: direction of the Arches is different for Anc and Desc!
	 * 
	 */
	public void calcPath() {

		// lower left, lower right, upper left, upper right
		Coord ll = new Coord(a1, r1);
		Coord lr = new Coord(a2, r1);
		Coord ul = new Coord(a1, r2);
		Coord ur = new Coord(a2, r2);

		path = String.format("M %1s %2s A %3s %4s 0 0 1 %5s %6s L %7s %8s A %9s %10s 0 0 0 %11s %12s z",
				ll.x, ll.y,
				r1, r1, lr.x, lr.y,
				ur.x, ur.y,
				r2, r2, ul.x, ul.y);

	}

	/**
	 * Test:
	 * return the d-Parameter of a Path drawing a DonutSegment
	 * @return
	 */
	public void test() {

		r1=100;
		r2=150;
		a1=30;
		a2=120;

		calcPath();

		setD(path);
	}

	/*
	 * get the Coordinates of the Corner-Points of a Donut-Segment given the Beta-Angle and the Distance
	 * 
	 * Pro Ancestor-Level ist die Anzahl der möglichen Elemente: 2^Level: 2^0=1, 2^1=2, 2^2=4, 2^3=8, etc
	 * wir können den linken und rechten Winkel (beta) wie folgt ermitteln:
	 * Winkel links = 180 / mögliche Anzahl Elemente der Ebene * Position des Elements-1
	 * Winkel rechts = 180 / mögliche Anzahl Elemente der Ebene * Position des Elements
	 * das Donut-Segment ist ein gleichschenkeliges Dreieck, 2 der Seiten sind:
	 * Abstand von Zentrum innen = SPACE*(level-1);
	 * Abstand von Zentrum außen = SPACE*level;
	 * die Länge der der dritten Seite ist: 2*Abstand von Zentrum*sin(beta/2)
	 * hiermit kennen wir 2 Seiten des rechtwinkeligen Dreiecks:
	 * c = 2*(Abstand von Zentrum)
	 * a = Länge der der dritten Seite
	 * mit Pythagoras kann b errechnet werden --> haben wir schon = länge der dritten Seite des gleichseitigen
	 * wir brauchen als y-Koordinate die Höhe auf c: (a*b)/c
	 * den p-Teil von c bekommen wir mit Pythagoras als wurzel(b^2-h^2)
	 * die x-Koordinte ist dann: -1*Abstand von Zentrum innen+p
	 * 
	 */
	private class Coord {
		public double x, y;
		private double lengthA, lengthB, lengthC, lengthH, lengthP;

		public Coord(double beta, double dist) {
			// gleichschenkeliges Dreieck
			lengthB = 2*dist * Math.sin(Math.toRadians(beta/2));
			// rechtwinkeliges Dreieck
			lengthC = dist;
			lengthA = Math.sqrt(Math.pow(2*lengthC, 2) - Math.pow(lengthB, 2));
			lengthH = (lengthA*lengthB)/(2*lengthC); // =posY
			lengthP = Math.sqrt(Math.pow(lengthB, 2) - Math.pow(lengthH, 2));
			x = -lengthC+lengthP;
			y = -lengthH;

			LOGGER.info("Donut calculated Coords=" + x + "/" + y);
		}
	}

}

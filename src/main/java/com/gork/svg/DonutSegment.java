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

	// lower left, lower right, upper left, upper right
	private Coord ll;
	private Coord lr;
	private Coord ul;
	private Coord ur;

	private String path = "";	// resulting path

	public DonutSegment() {
		super();

		// nice color and no fill by default
		setStroke("Gold");
		setStrokeTransparent();
		setFill("none");
	}

	public DonutSegment(double innerRadius, double outerRadius, double startAngle, double endAngle) {
		this();
		this.r1 = innerRadius;
		this.r2 = outerRadius;
		this.a1 = startAngle;
		this.a2 = endAngle;
		calcPath();
		setD(path);
	}

	public DonutSegment(double centerX, double centerY, double innerRadius, double outerRadius, double startAngle, double endAngle) {
		this(innerRadius, outerRadius, startAngle, endAngle);
		setCenter(centerX, centerY);
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

	public double getCenterX() {
		return (ll.x + ul.x + lr.x + ur.x ) / 4;
	}

	public double getCenterY() {
		return (ll.y + ul.y + lr.y + ur.y ) / 4;
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
		ll = new Coord(a1, r1);
		lr = new Coord(a2, r1);
		ul = new Coord(a1, r2);
		ur = new Coord(a2, r2);

		LOGGER.info("Segment-Corners-" + "ll:" + a1 + "/" + r1 + ", lr:"+ a2 + "/" + r1 + ", ul:" + a1 + "/" + r2 + ", ur:" + a2 + "/" + r2);

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

		a1=10;
		a2=80;

		calcPath();

		setD(path);
	}

	/*
	 * get the Coordinates of the Corner-Points of a Donut-Segment given the Beta-Angle and the Distance
	 * 
	 * 
	 *         |  \
	 *    a/   |   \dist
	 *    /    |h   \               b
	 *   /     |     \
	 *  /      |  beta\
	 * +-------+-------+---------------+
	 *     p dist  q           dist
	 * 
	 * a = c.cos(β)
	 * hc = a.sin(β)
	 * p = sqrt(a^2 - hc^2)
	 * 
	 * x=p
	 * y=hc
	 */
	private class Coord {
		public double x, y;

		public Coord(double beta, double dist) {
			if (beta >= 0 & beta <= 180) {
				calc(beta, dist);
			} else if (beta >= 180 & beta <= 360) {
				calc(beta-180, dist);
				x=-x; y=-y;
			} else { // beta outside 0-360
				LOGGER.error("Coordinates can only be calculated for angles between 0 and 360 degrees");
			}
			LOGGER.info("Coord (dist=" + dist + "/beta=" + beta + ") ==> x/y=" + x + "/" + y);
		}

		public void calc(double beta, double dist) {
			double lengthA, lengthB, lengthC, lengthH, lengthP;
			// gleichschenkeliges Dreieck (liegend, Schenkel=dist, Basis=Seite B des rechtwinkeligen Dreiecks
			lengthB = 2*dist * Math.sin(Math.toRadians(beta/2));
			// rechtwinkeliges Dreieck (A dieses Dreiecks=A des gleichschenkeligen, C dieses = 2*dist)
			lengthC = 2*dist;
			lengthA = Math.sqrt(Math.pow(lengthC, 2) - Math.pow(lengthB, 2));
			lengthH = (lengthA*lengthB)/(lengthC); // =posY
			lengthP = Math.sqrt(Math.pow(lengthB, 2) - Math.pow(lengthH, 2));
			x = -dist+lengthP;
			y = -lengthH;

		}
	}

}

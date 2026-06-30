/**
 *
 * Utility Class for Charts
 * 
 */
package com.gork.svg.chart.helper;

import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class Scale {

	public Scale() {
	}

	/**
	 * ScaleSize
	 * eg.
	 * if there are up to 100 Years between start and end we will show a Yearly Scale with Ticks every 10 Years
	 * if there are up to 5 Years between start and end. We will show a Monthly Scale with Ticks every 6 Months
	 * 
	 */
	public record ScaleSize(ChronoUnit timeunit, int diff, ChronoUnit scaleunit, int interval) {}

	/**
	 * initial List of available Scale Sizes
	 */
	public static List<ScaleSize> scaleSizes = List.of(
		new ScaleSize(ChronoUnit.DAYS, 0, ChronoUnit.DAYS, 1),
		new ScaleSize(ChronoUnit.SECONDS, 60, ChronoUnit.SECONDS, 1),
		new ScaleSize(ChronoUnit.MINUTES, 60, ChronoUnit.MINUTES, 1),
		new ScaleSize(ChronoUnit.HOURS, 25, ChronoUnit.HOURS, 1),
		new ScaleSize(ChronoUnit.DAYS, 25, ChronoUnit.DAYS, 1),
		new ScaleSize(ChronoUnit.DAYS, 100, ChronoUnit.DAYS, 10),
		new ScaleSize(ChronoUnit.MONTHS, 12, ChronoUnit.MONTHS, 1),
		new ScaleSize(ChronoUnit.YEARS, 2, ChronoUnit.MONTHS, 1),
		new ScaleSize(ChronoUnit.YEARS, 5, ChronoUnit.MONTHS, 6),
		new ScaleSize(ChronoUnit.YEARS, 50, ChronoUnit.YEARS, 5),
		new ScaleSize(ChronoUnit.YEARS, 100, ChronoUnit.YEARS, 10),
		new ScaleSize(ChronoUnit.YEARS, 200, ChronoUnit.YEARS, 20),
		new ScaleSize(ChronoUnit.YEARS, 500, ChronoUnit.YEARS, 50),
		new ScaleSize(ChronoUnit.YEARS, 5000, ChronoUnit.YEARS, 100)
	);


}

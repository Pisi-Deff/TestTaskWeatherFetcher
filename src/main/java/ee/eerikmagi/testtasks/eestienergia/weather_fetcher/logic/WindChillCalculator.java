package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.logic;

import java.math.BigDecimal;

public class WindChillCalculator {
	private static final double STANDALONE_ADDED_CONST = 13.12;
	private static final double TEMPERATURE_MULTIPLIER_CONST = 0.6215;
	private static final double VELOCITY_MULTIPLIER_CONST = 11.37;
	private static final double VELOCITY_EXPONENT_CONST = 0.16;
	private static final double BOTH_MULTIPLIER_CONST = 0.3965;
	
	/**
	 * Calculates the windchill based on the provided temperature and wind speed values.
	 * Could probably be made more accurate by making the calculations using BigDecimals
	 * but I would argue that such precision is not really needed for just plain wind chill.
	 * 
	 * Formula taken from: https://www.freemathhelp.com/wind-chill.html
	 * 
	 * @param temperature
	 * @param windSpeed
	 * @return
	 */
	public static double calculate(
		BigDecimal temperature,
		BigDecimal windSpeed
	) {
		if (temperature == null || windSpeed == null) {
			throw new IllegalArgumentException("Arguments must not be null");
		}
		
		double velocity = Math.pow(windSpeed.doubleValue(), VELOCITY_EXPONENT_CONST);
		double temp = temperature.doubleValue();
		
		return
				STANDALONE_ADDED_CONST
				+ TEMPERATURE_MULTIPLIER_CONST * temp
				- VELOCITY_MULTIPLIER_CONST * velocity
				+ BOTH_MULTIPLIER_CONST * temp * velocity;
	}
}

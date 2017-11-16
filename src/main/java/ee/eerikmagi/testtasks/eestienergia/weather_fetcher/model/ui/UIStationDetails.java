package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.ui;

import java.math.BigDecimal;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource.Station;

public class UIStationDetails {
	private String phenomenon;
	private BigDecimal visibility;
	private int precipitations;
	private BigDecimal airPressure;
	private int relativeHumidity;
	private BigDecimal airTemperature;

	private int windDirection;
	private BigDecimal windSpeed;
	private BigDecimal windSpeedMax;

	private int waterLevel;
	private BigDecimal waterTemperature;
	
	private double windChill;
	
	public String getPhenomenon() {
		return phenomenon;
	}
	public UIStationDetails setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
		return this;
	}
	
	public BigDecimal getVisibility() {
		return visibility;
	}
	public UIStationDetails setVisibility(BigDecimal visibility) {
		this.visibility = visibility;
		return this;
	}
	
	public int getPrecipitations() {
		return precipitations;
	}
	public UIStationDetails setPrecipitations(int precipitations) {
		this.precipitations = precipitations;
		return this;
	}
	
	public BigDecimal getAirPressure() {
		return airPressure;
	}
	public UIStationDetails setAirPressure(BigDecimal airPressure) {
		this.airPressure = airPressure;
		return this;
	}
	
	public int getRelativeHumidity() {
		return relativeHumidity;
	}
	public UIStationDetails setRelativeHumidity(int relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
		return this;
	}
	
	public BigDecimal getAirTemperature() {
		return airTemperature;
	}
	public UIStationDetails setAirTemperature(BigDecimal airTemperature) {
		this.airTemperature = airTemperature;
		return this;
	}
	
	public int getWindDirection() {
		return windDirection;
	}
	public UIStationDetails setWindDirection(int windDirection) {
		this.windDirection = windDirection;
		return this;
	}
	
	public BigDecimal getWindSpeed() {
		return windSpeed;
	}
	public UIStationDetails setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
		return this;
	}
	
	public BigDecimal getWindSpeedMax() {
		return windSpeedMax;
	}
	public UIStationDetails setWindSpeedMax(BigDecimal windSpeedMax) {
		this.windSpeedMax = windSpeedMax;
		return this;
	}
	
	public int getWaterLevel() {
		return waterLevel;
	}
	public UIStationDetails setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
		return this;
	}
	
	public BigDecimal getWaterTemperature() {
		return waterTemperature;
	}
	public UIStationDetails setWaterTemperature(BigDecimal waterTemperature) {
		this.waterTemperature = waterTemperature;
		return this;
	}
	
	public double getWindChill() {
		return windChill;
	}
	public UIStationDetails setWindChill(double windChill) {
		this.windChill = windChill;
		return this;
	}
	
	public static UIStationDetails fromStation(Station station) {
		return new UIStationDetails()
			.setPhenomenon(station.getPhenomenon())
			.setVisibility(station.getVisibility())
			.setPrecipitations(station.getPrecipitations())
			.setAirPressure(station.getAirPressure())
			.setRelativeHumidity(station.getRelativeHumidity())
			.setAirTemperature(station.getAirTemperature())

			.setWindDirection(station.getWindDirection())
			.setWindSpeed(station.getWindSpeed())
			.setWindSpeedMax(station.getWindSpeedMax())

			.setWaterLevel(station.getWaterLevel())
			.setWaterTemperature(station.getWaterTemperature());
	}
}

package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model;

import java.math.BigDecimal;

public class Station {
	private String name;
	private String wmoCode;
	
	private String longitude;
	private String latitude;
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWmoCode() {
		return wmoCode;
	}
	public void setWmoCode(String wmoCode) {
		this.wmoCode = wmoCode;
	}
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getPhenomenon() {
		return phenomenon;
	}
	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
	}
	
	public BigDecimal getVisibility() {
		return visibility;
	}
	public void setVisibility(BigDecimal visibility) {
		this.visibility = visibility;
	}
	
	public int getPrecipitations() {
		return precipitations;
	}
	public void setPrecipitations(int precipitations) {
		this.precipitations = precipitations;
	}
	
	public BigDecimal getAirPressure() {
		return airPressure;
	}
	public void setAirPressure(BigDecimal airPressure) {
		this.airPressure = airPressure;
	}
	
	public int getRelativeHumidity() {
		return relativeHumidity;
	}
	public void setRelativeHumidity(int relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}
	
	public BigDecimal getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(BigDecimal airTemperature) {
		this.airTemperature = airTemperature;
	}
	
	public int getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	
	public BigDecimal getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	public BigDecimal getWindSpeedMax() {
		return windSpeedMax;
	}
	public void setWindSpeedMax(BigDecimal windSpeedMax) {
		this.windSpeedMax = windSpeedMax;
	}
	
	public int getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}
	
	public BigDecimal getWaterTemperature() {
		return waterTemperature;
	}
	public void setWaterTemperature(BigDecimal waterTemperature) {
		this.waterTemperature = waterTemperature;
	}
}

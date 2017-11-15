package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="station")
@XmlAccessorType(XmlAccessType.FIELD)
public class Station {
	@XmlElement
	private String name;
	@XmlElement(name="wmocode")
	private String wmoCode;

	@XmlElement
	private String longitude;
	@XmlElement
	private String latitude;

	@XmlElement
	private String phenomenon;
	@XmlElement
	private BigDecimal visibility;
	@XmlElement
	private int precipitations;
	@XmlElement(name="airpressure")
	private BigDecimal airPressure;
	@XmlElement(name="relativehumidity")
	private int relativeHumidity;
	@XmlElement(name="airtemperature")
	private BigDecimal airTemperature;

	@XmlElement(name="winddirection")
	private int windDirection;
	@XmlElement(name="windspeed")
	private BigDecimal windSpeed;
	@XmlElement(name="windspeedmax")
	private BigDecimal windSpeedMax;

	@XmlElement(name="waterlevel")
	private int waterLevel;
	@XmlElement(name="watertemperature")
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

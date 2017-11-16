package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.ui;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource.Station;

public class UIStation {
	private String name;
	private String wmoCode;
	
	private String longitude;
	private String latitude;
	
	private UIStationDetails details;
	
	public String getName() {
		return name;
	}
	public UIStation setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getWmoCode() {
		return wmoCode;
	}
	public UIStation setWmoCode(String wmoCode) {
		this.wmoCode = wmoCode;
		return this;
	}
	
	public String getLongitude() {
		return longitude;
	}
	public UIStation setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}
	
	public String getLatitude() {
		return latitude;
	}
	public UIStation setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}
	
	public UIStationDetails getDetails() {
		return details;
	}
	public UIStation setDetails(UIStationDetails details) {
		this.details = details;
		return this;
	}
	
	public static UIStation fromStation(Station station) {
		return fromStationBasic(station)
			.setDetails(UIStationDetails.fromStation(station));
	}
	
	public static UIStation fromStationBasic(Station station) {
		return new UIStation()
			.setName(station.getName())
			.setWmoCode(station.getWmoCode())
			.setLatitude(station.getLatitude())
			.setLongitude(station.getLongitude());
	}
}

package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model;

import java.util.List;

public class Observations {
	private List<Station> stations;
	private int timestamp;
	
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
}

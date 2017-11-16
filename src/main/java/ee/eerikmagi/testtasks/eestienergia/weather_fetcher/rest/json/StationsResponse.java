package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json;

import java.util.List;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.ui.UIStation;

public class StationsResponse extends JsonResponse {
	private List<UIStation> stations;

	public List<UIStation> getStations() {
		return stations;
	}
	public StationsResponse setStations(List<UIStation> stations) {
		this.stations = stations;
		return this;
	}
}

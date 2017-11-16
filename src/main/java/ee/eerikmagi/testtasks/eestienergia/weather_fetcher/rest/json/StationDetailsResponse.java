package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.ui.UIStation;

public class StationDetailsResponse extends JsonResponse {
	private UIStation station;

	public UIStation getStation() {
		return station;
	}
	public StationDetailsResponse setStation(UIStation station) {
		this.station = station;
		return this;
	}
}

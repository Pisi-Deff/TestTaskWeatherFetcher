package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json;

/**
 * A simple class for a JSON response for REST API requests.
 */
public class JsonResponse {
	private boolean success;

	public boolean isSuccess() {
		return success;
	}
	public JsonResponse setSuccess(boolean success) {
		this.success = success;
		return this;
	}
}

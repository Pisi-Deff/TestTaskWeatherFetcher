package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.fetcher;

@SuppressWarnings("serial")
public class FetchException extends RuntimeException {

	public FetchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FetchException(String message, Throwable cause) {
		super(message, cause);
	}

	public FetchException(String message) {
		super(message);
	}

	public FetchException(Throwable cause) {
		super(cause);
	}

}

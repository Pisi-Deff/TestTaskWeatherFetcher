package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app.context.ConstraintViolationExceptionMapper;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app.context.ObjectMapperProvider;

@ApplicationPath("api")
public class WeatherFetcherApplication extends ResourceConfig {
	public WeatherFetcherApplication() {
		// for JSON support
		register(ObjectMapperProvider.class);
		register(JacksonFeature.class);
		
		// bean validation exception handler
		register(ConstraintViolationExceptionMapper.class);
		
		// read resource classes
		packages("ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest");
	}
}

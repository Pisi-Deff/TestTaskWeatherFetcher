package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app.context.ObjectMapperProvider;

@ApplicationPath("")
public class WeatherFetcherApplication extends ResourceConfig {
	public WeatherFetcherApplication() {
		// Freemarker templating support for rendering html
		property(FreemarkerMvcFeature.TEMPLATE_BASE_PATH, "freemarker");
		register(FreemarkerMvcFeature.class);
		
		// for JSON support
		register(ObjectMapperProvider.class);
		register(JacksonFeature.class);
		
		// read resource classes
		packages("ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest");
	}
}

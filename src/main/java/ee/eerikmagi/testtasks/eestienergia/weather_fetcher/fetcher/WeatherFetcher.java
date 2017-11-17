package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.fetcher;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource.Observations;

public class WeatherFetcher implements IFetcher<Observations> {
	private static final String ENDPOINT_URL = "http://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";

	public Observations fetch() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(
			UriBuilder.fromUri(ENDPOINT_URL).build()
		);
		
		try {
			Observations observations = target
				.request()
				.accept(MediaType.TEXT_XML)
				.get(Observations.class);
			
			return observations;
		} catch (Throwable t) {
			throw new FetchException("Unable to fetch weather", t);
		}
	}
}

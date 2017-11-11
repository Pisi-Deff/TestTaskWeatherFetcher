package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

/**
 * Resource that handles requests related to the website part of the application.
 */
@Path("")
public class IndexResource {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable index() {
		Map<String, Object> context = new HashMap<>();
		
		return new Viewable("/index.ftl", context);
	}
	
}

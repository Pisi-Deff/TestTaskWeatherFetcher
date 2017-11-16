package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.fetcher.FetcherCache;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.fetcher.WeatherFetcher;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.logic.WindChillCalculator;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource.Observations;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource.Station;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.ui.UIStation;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json.JsonResponse;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json.StationDetailsRequest;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json.StationDetailsResponse;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json.StationsResponse;

/**
 * Resource that handles API requests
 */
@Path("")
public class APIResource {
	private static final Duration cacheLifetime = Duration.ofMinutes(20);
	private static final FetcherCache<Observations, WeatherFetcher> weatherFetcher =
		new FetcherCache<>(cacheLifetime, new WeatherFetcher());
	
	private static final JsonResponse JSON_RESPONSE_FAILURE =
			new JsonResponse().setSuccess(false);
	
	@Path("stations")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStations() {
		Observations obs = weatherFetcher.get();
		if (obs == null) {
			return Response.serverError()
				.entity(JSON_RESPONSE_FAILURE)
				.build();
		}
		
		List<UIStation> stations = obs.getStations().stream()
			.map(station -> UIStation.fromStationBasic(station))
			.sorted((a,b) -> a.getName().compareTo(b.getName()))
			.collect(Collectors.toList());
		
		return Response.ok(
			new StationsResponse()
				.setStations(stations)
				.setSuccess(true)
		).build();
	}
	
	@Path("stations")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStationDetails(
		@Valid StationDetailsRequest req
	) {
		String name = req.getName();
		
		Observations obs = weatherFetcher.get();
		if (obs == null) {
			return Response.serverError()
				.entity(JSON_RESPONSE_FAILURE)
				.build();
		}
		
		Optional<Station> station = obs.getStations().stream()
			.filter(s -> {
				return s.getName().trim().equalsIgnoreCase(name.trim());
			})
			.findAny();
		
		if (!station.isPresent()) {
			return Response.status(Status.NOT_FOUND)
				.entity(JSON_RESPONSE_FAILURE)
				.build();
		}
		
		UIStation uiStation = UIStation.fromStation(station.get());
		
		Double windChill = WindChillCalculator.calculate(
			uiStation.getDetails().getAirTemperature(),
			uiStation.getDetails().getWindSpeed()
		);
		uiStation.getDetails().setWindChill(windChill);
		
		return Response.ok(
			new StationDetailsResponse()
				.setStation(uiStation)
				.setSuccess(true)
		).build();
	}
	
}

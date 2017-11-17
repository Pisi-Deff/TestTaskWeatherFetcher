package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app.context;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.fetcher.FetchException;
import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json.JsonResponse;

@Provider
@Priority(Priorities.USER)
public class FetchExceptionMapper implements ExceptionMapper<FetchException> {
	@Override
	public Response toResponse(FetchException exception) {
		return Response
			.serverError()
			.entity(new JsonResponse().setSuccess(false))
			.build();
	}

}

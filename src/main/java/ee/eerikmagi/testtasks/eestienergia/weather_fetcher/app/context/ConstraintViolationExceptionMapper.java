package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.app.context;

import javax.annotation.Priority;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ee.eerikmagi.testtasks.eestienergia.weather_fetcher.rest.json.JsonResponse;

@Provider
@Priority(Priorities.USER)
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response
			.status(400)
			.entity(new JsonResponse().setSuccess(false))
			.build();
	}

}

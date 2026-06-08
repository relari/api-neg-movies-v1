package pe.com.relari.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;
import pe.com.relari.config.ApplicationProperties;
import pe.com.relari.config.ErrorProperties;
import pe.com.relari.model.common.ApiResponse;
import pe.com.relari.model.common.ErrorType;

/**
 * <b>Class:</b> DemoResource.<br/>
 * <b>Description:</b> Simple demo REST resource used to expose health/greeting and error examples.
 * It demonstrates usage of configuration properties and centralized error handling.
 *
 * @author Relari
 */
@Path("/v1")
@RequiredArgsConstructor
public class DemoResource {
  
  private static final Logger log = Logger.getLogger(DemoResource.class);

  private final ErrorProperties errorProperties;
  private final ApplicationProperties applicationProperties;

  @GET
  @Path("/greeting")
  @Produces(MediaType.TEXT_PLAIN)
  public String greeting(
      @Context HttpHeaders headers) {
    log.info(headers.getHeaderString("Authorization"));
    return applicationProperties.getMessage();
  }

  @GET
  @Path("/error")
  @Produces(MediaType.APPLICATION_JSON)
  public Response errorResponse() {
    log.info(String.format("errorMessage=%s, status=%s", errorProperties.defaultMessage(), errorProperties.status()));
    return ApiResponse.errorResponse(ErrorType.INTERNAL_SERVER_ERROR, errorProperties.defaultMessage());
  }

}

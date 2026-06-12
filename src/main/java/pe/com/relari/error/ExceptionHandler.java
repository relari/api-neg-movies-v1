package pe.com.relari.error;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;
import pe.com.relari.config.ErrorProperties;
import pe.com.relari.model.common.ApiResponse;

/**
 * <b>Class:</b> ExceptionHandler.<br/>
 * <b>Description:</b> JAX-RS provider that maps {@link ApiException} to HTTP responses using the
 * application's {@link pe.com.relari.model.common.ErrorType} and {@code ApiResponse} format.
 * Centralizes transformation of domain errors into API error responses.
 *
 * @author Relari
 */
@Provider
@RequiredArgsConstructor
public class ExceptionHandler implements ExceptionMapper<ApiException> {

  private static final Logger log = Logger.getLogger(ExceptionHandler.class);

  private final ErrorProperties errorProperties;

  @Override
  public Response toResponse(ApiException apiException) {
    var errorCategory = errorProperties.categories().get(apiException.getCatalog());

    log.errorf(apiException, "[ApiException] {} - Message: {}",
            apiException.getCatalog(), apiException.getMessage());

    return ApiResponse.errorResponse(errorCategory);
  }

}

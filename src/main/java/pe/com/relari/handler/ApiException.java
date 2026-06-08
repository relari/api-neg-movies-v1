package pe.com.relari.handler;

import lombok.Getter;
import pe.com.relari.model.common.ErrorType;

/**
 * <b>Class:</b> ApiException.<br/>
 * <b>Description:</b> Runtime exception used to represent business or API errors with an
 * associated {@link pe.com.relari.model.common.ErrorType} so the exception handler can map
 * it to a proper HTTP response.
 *
 * @author Relari
 */
@Getter
public class ApiException extends RuntimeException {

  private final ErrorType errorType;

  public ApiException(ErrorType errorType, String message) {
    super(message);
    this.errorType = errorType;
  }

  public ApiException(ErrorType errorType, String message, Throwable cause) {
    super(message, cause);
    this.errorType = errorType;
  }

}

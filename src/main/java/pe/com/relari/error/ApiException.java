package pe.com.relari.error;

import lombok.Getter;

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

//  private final ErrorType errorType;
  private final String catalog;


  public ApiException(String catalog) {
    super();
    this.catalog = catalog;
  }

  public ApiException(String catalog, String message) {
    super(message);
    this.catalog = catalog;
  }

}

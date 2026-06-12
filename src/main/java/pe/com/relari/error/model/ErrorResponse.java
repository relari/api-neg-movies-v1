package pe.com.relari.error.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Class:</b> ErrorResponse.<br>
 *
 * @author Relari
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  private String code;
  private String description;
  private String timestamp;
  private Map<String, String> metadata;
  private String throwable;
  private Object details;

  /**
   * Constructor para respuestas de error desde categoría configurada.
   *
   * @param category Categoría de error desde YAML
   */
  public ErrorResponse(ErrorCategory category) {
    this.code = category.code();
    this.description = category.description();
    this.timestamp = LocalDateTime.now().toString();
    this.metadata = Map.of();
  }

  public ErrorResponse(ErrorCategory category, String message) {
    this.code = category.code();
    this.description = message != null ? message : category.description();
    this.timestamp = LocalDateTime.now().toString();
    this.metadata = Map.of();
  }

//  /**
//   * Constructor para respuestas de error genéricas.
//   *
//   * @param status Código HTTP
//   * @param description Descripción del error
//   */
//  public ErrorResponse(Integer status, String description) {
//    this.status = status;
//    this.description = description;
//    this.timestamp = LocalDateTime.now().toString();
//    this.metadata = Map.of();
//  }
//
//  /**
//   * Constructor para error de API con stack trace.
//   * El stack trace se incluye en la respuesta según la configuración.
//   *
//   * @param category Categoría de error
//   * @param throwable Excepción con stack trace
//   * @param includeStackTrace Si debe incluir el stack trace
//   */
//  public ErrorResponse(ErrorCategory category, Throwable throwable, boolean includeStackTrace) {
//    this(category);
//    if (includeStackTrace && throwable != null) {
//      this.throwable = getStackTrace(throwable);
//    }
//  }
//
//  /**
//   * Extrae el stack trace de una excepción en formato String.
//   * Método estático para reutilización en diferentes contextos.
//   *
//   * @param throwable Excepción
//   * @return Stack trace formateado
//   */
//  public static String getStackTraceStatic(Throwable throwable) {
//    if (throwable == null) {
//      return null;
//    }
//
//    StringBuilder sb = new StringBuilder();
//    sb.append(throwable.getClass().getName()).append(": ").append(throwable.getMessage()).append("\n");
//
//    for (StackTraceElement element : throwable.getStackTrace()) {
//      sb.append("\tat ").append(element).append("\n");
//    }
//
//    if (throwable.getCause() != null) {
//      sb.append("Caused by: ").append(getStackTraceStatic(throwable.getCause()));
//    }
//
//    return sb.toString();
//  }
//
//  /**
//   * Extrae el stack trace de una excepción en formato String (método privado).
//   *
//   * @param throwable Excepción
//   * @return Stack trace formateado
//   */
//  private static String getStackTrace(Throwable throwable) {
//    return getStackTraceStatic(throwable);
//  }

}

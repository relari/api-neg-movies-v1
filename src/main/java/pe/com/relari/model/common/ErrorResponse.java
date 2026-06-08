package pe.com.relari.model.common;

/**
 * <b>Class:</b> ErrorResponse.<br/>
 * <b>Description:</b> Immutable record representing an error payload with an {@code ErrorType}
 * and a human-readable message. Used inside {@code ApiResponse} for error cases.
 *
 * @author Relari
 */
public record ErrorResponse(ErrorType errorCode, String errorMessage) {}

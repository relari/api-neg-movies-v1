package pe.com.relari.config;

import io.smallrye.config.ConfigMapping;

/**
 * <b>Class:</b> ErrorProperties.<br/>
 * <b>Description:</b> Configuration properties for error handling in the application.
 *
 * @author Relari
 */

@ConfigMapping(prefix = "app.error")
public interface ErrorProperties {

  String defaultMessage();
  Integer status();

}

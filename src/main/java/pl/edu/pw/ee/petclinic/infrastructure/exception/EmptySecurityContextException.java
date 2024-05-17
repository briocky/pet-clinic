package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptySecurityContextException extends RuntimeException{

  private EmptySecurityContextException(String exceptionMessage) {
    super(exceptionMessage);
  }

  public static EmptySecurityContextException of(String message) {
    return new EmptySecurityContextException(message);
  }
}

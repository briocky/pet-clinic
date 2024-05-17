package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPasswordException extends RuntimeException {

  private InvalidPasswordException(String exceptionMessage) {
    super(exceptionMessage);
  }

  public static InvalidPasswordException of(String message) {
    return new InvalidPasswordException(message);
  }
}

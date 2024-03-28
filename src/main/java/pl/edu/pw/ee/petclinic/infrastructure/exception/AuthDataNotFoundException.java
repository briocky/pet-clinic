package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthDataNotFoundException extends RuntimeException {

  private AuthDataNotFoundException(String exceptionMessage) {
    super(exceptionMessage);
  }

  public static AuthDataNotFoundException of(String message) {
    return new AuthDataNotFoundException(message);
  }
}

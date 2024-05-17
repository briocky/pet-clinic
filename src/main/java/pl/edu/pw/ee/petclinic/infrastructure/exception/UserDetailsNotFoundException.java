package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDetailsNotFoundException extends RuntimeException {

  private UserDetailsNotFoundException(String exceptionMessage) {
    super(exceptionMessage);
  }

  public static UserDetailsNotFoundException of(String message) {
    return new UserDetailsNotFoundException(message);
  }
}

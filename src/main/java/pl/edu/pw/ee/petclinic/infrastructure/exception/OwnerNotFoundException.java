package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {

  private OwnerNotFoundException(String exceptionMessage) {
    super(exceptionMessage);
  }

  public static OwnerNotFoundException of(String message) {
    return new OwnerNotFoundException(message);
  }
}

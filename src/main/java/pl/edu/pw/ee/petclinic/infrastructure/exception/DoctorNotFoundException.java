package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends RuntimeException {

  private DoctorNotFoundException(String exceptionMessage) {
    super(exceptionMessage);
  }

  public static DoctorNotFoundException of(String message) {
    return new DoctorNotFoundException(message);
  }
}

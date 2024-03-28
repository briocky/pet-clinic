package pl.edu.pw.ee.petclinic.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TokenException extends RuntimeException {

  private TokenException(String message) {
    super(message);
  }

  public static TokenException of(String message) {
    return new TokenException(message);
  }
}

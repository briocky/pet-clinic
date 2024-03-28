package pl.edu.pw.ee.petclinic.domain.user.data;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.infrastructure.exception.AuthDataNotFoundException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthDataService {

  final AuthDataRepository authDataRepository;

  public AuthData getAuthDataByEmail(String userEmail) {
    return authDataRepository
        .findAuthDataByEmail(userEmail)
        .orElseThrow(() ->
            AuthDataNotFoundException.of(
                String.format("Auth data for email=%s cannot be found", userEmail)
            )
        );
  }

  public AuthData getAuthDataById(Long userId) {
    return authDataRepository
        .findById(userId)
        .orElseThrow(() ->
            AuthDataNotFoundException.of(
                String.format("Auth data for id=%d cannot be found", userId)
            )
        );
  }

  public boolean isEmailTaken(String userEmail) {
    return authDataRepository
        .existsByEmail(userEmail);
  }
}

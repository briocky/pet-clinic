package pl.edu.pw.ee.petclinic.domain.user.data;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.infrastructure.exception.AuthDataNotFoundException;
import pl.edu.pw.ee.petclinic.infrastructure.exception.EmptySecurityContextException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthDataService {

  final AuthDataRepository authDataRepository;

  @Transactional
  public AuthData getAuthDataByEmail(String userEmail) {
    return authDataRepository
        .findAuthDataByEmail(userEmail)
        .orElseThrow(() ->
            AuthDataNotFoundException.of(
                String.format("Auth data for email=%s cannot be found", userEmail)
            )
        );
  }

  public AuthData getCurrentUserAuthData() {
    return (AuthData) Optional
        .ofNullable(
            SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        )
        .orElseThrow(() ->
            EmptySecurityContextException.of("SecurityContextHolder is empty")
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

  public AuthData saveAuthData(AuthData authData) {
    return authDataRepository.save(authData);
  }
}

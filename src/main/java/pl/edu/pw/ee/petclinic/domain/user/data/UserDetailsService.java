package pl.edu.pw.ee.petclinic.domain.user.data;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;
import pl.edu.pw.ee.petclinic.infrastructure.exception.UserDetailsNotFoundException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsService {

  final UserDetailsRepository userDetailsRepository;

  public UserDetails saveUserDetails(UserDetails userDetails) {
    return userDetailsRepository.save(userDetails);
  }

  public UserDetails getUserDetailsByEmail(String email) {
    return userDetailsRepository
      .findUserDetailsByEmail(email)
      .orElseThrow(() ->
          UserDetailsNotFoundException.of(
            String.format("UserDetails for email=%s could not be found", email)
          )
      );
  }
}

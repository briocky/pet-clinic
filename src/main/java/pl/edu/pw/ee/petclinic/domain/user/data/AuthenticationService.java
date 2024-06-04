package pl.edu.pw.ee.petclinic.domain.user.data;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.owner.dto.LoginRequest;
import pl.edu.pw.ee.petclinic.domain.owner.dto.LoginResponse;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;
import pl.edu.pw.ee.petclinic.infrastructure.exception.InvalidPasswordException;
import pl.edu.pw.ee.petclinic.infrastructure.security.JwtGenerator;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationService {

  final UserDetailsService userDetailsService;
  final AuthDataService authDataService;
  final PasswordEncoder passwordEncoder;
  final JwtGenerator jwtGenerator;

  public LoginResponse authenticateUser(LoginRequest request) {
    AuthData authDataByEmail = authDataService.getAuthDataByEmail(request.getEmail());
    if (!passwordEncoder.matches(request.getPassword(), authDataByEmail.getPassword())) {
      throw InvalidPasswordException.of(
          String.format("Password for email=%s is invalid", request.getEmail())
      );
    }

    UserDetails userDetailsByEmail = userDetailsService.getUserDetailsByEmail(request.getEmail());
    return LoginResponse.builder()
        .id(userDetailsByEmail.getId())
        .birthDate(userDetailsByEmail.getBirthDate())
        .address(userDetailsByEmail.getAddress())
        .imageUrl(userDetailsByEmail.getImageUrl())
        .phoneNumber(userDetailsByEmail.getPhoneNumber())
        .email(authDataByEmail.getEmail())
        .systemRole(userDetailsByEmail.getSystemRole())
        .name(userDetailsByEmail.getName())
        .accessToken(jwtGenerator.generateAccessToken(authDataByEmail))
        .refreshToken(jwtGenerator.generateRefreshToken(authDataByEmail))
        .build();
  }

}

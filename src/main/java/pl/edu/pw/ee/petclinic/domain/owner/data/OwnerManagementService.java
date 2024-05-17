package pl.edu.pw.ee.petclinic.domain.owner.data;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.owner.dto.OwnerDto;
import pl.edu.pw.ee.petclinic.domain.owner.dto.RegistrationRequest;
import pl.edu.pw.ee.petclinic.domain.owner.dto.RegistrationResponse;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;
import pl.edu.pw.ee.petclinic.domain.owner.mapper.OwnerMapper;
import pl.edu.pw.ee.petclinic.domain.user.data.AuthDataService;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;
import pl.edu.pw.ee.petclinic.infrastructure.exception.EmailTakenException;
import pl.edu.pw.ee.petclinic.infrastructure.exception.OwnerNotFoundException;
import pl.edu.pw.ee.petclinic.infrastructure.security.JwtGenerator;

@Service
@Slf4j
@RequiredArgsConstructor
public class OwnerManagementService {

  private final OwnerRepository ownerRepository;
  private final OwnerMapper ownerMapper;
  private final AuthDataService authDataService;
  private final JwtGenerator jwtGenerator;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public RegistrationResponse createUser(RegistrationRequest request) {
    if (authDataService.isEmailTaken(request.getEmail())) {
      throw EmailTakenException.of(
          String.format("Email %s already taken", request.getEmail())
      );
    }

    final String hashedPassword = passwordEncoder.encode(request.getPassword());
    Owner owner = ownerMapper.getOwner(request);
    owner.getAuthData().setPassword(hashedPassword);
    owner.getUserDetails().setSystemRole(SystemRole.USER);

    ownerRepository.save(owner);
    return RegistrationResponse.builder()
        .id(owner.getId())
        .email(owner.getAuthData().getEmail())
        .name(owner.getUserDetails().getFirstName() + " " + owner.getUserDetails().getLastName())
        .accessToken(jwtGenerator.generateAccessToken(owner.getAuthData()))
        .refreshToken(jwtGenerator.generateRefreshToken(owner.getAuthData()))
        .build();
  }

  public OwnerDto getAccountDetails() {
    Owner owner = getOwnerByEmail(authDataService.getCurrentUserAuthData().getUsername());
    return ownerMapper.getOwnerDto(owner);
  }

  public Owner getOwnerByEmail(String email) {
    return ownerRepository
        .findOwnerByAuthDataEmail(email)
        .orElseThrow(() ->
            OwnerNotFoundException.of(
                String.format("Owner entity for email=%s cannot be found", email)
            )
        );
  }
}

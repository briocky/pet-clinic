package pl.edu.pw.ee.petclinic.domain.owner.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.appointment.dto.RegistrationRequest;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;
import pl.edu.pw.ee.petclinic.domain.owner.mapper.OwnerMapper;
import pl.edu.pw.ee.petclinic.domain.user.data.AuthDataService;
import pl.edu.pw.ee.petclinic.infrastructure.exception.EmailTakenException;
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

  public void createUser(RegistrationRequest request) {
    if (authDataService.isEmailTaken(request.getEmail())) {
      throw EmailTakenException.of(
          String.format("Email %s already taken", request.getEmail())
      );
    }

    final String hashedPassword = passwordEncoder.encode(request.getPassword());
    Owner owner = ownerMapper.getOwner(request);
    owner.getAuthData().setPassword(hashedPassword);

    ownerRepository.save(owner);
  }
}

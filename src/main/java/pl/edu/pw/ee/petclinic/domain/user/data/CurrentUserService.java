package pl.edu.pw.ee.petclinic.domain.user.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.doctor.data.DoctorManagementService;
import pl.edu.pw.ee.petclinic.domain.owner.data.OwnerManagementService;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.SystemUser;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;
@Service
@Slf4j
@RequiredArgsConstructor
public class CurrentUserService {

  private final AuthDataService authDataService;
  private final UserDetailsService userDetailsService;
  private final OwnerManagementService ownerManagementService;
  private final DoctorManagementService doctorManagementService;

  public SystemUser getCurrentSystemUser() {
    AuthData currentUser = authDataService.getCurrentUserAuthData();
    SystemRole systemRole = userDetailsService.getUserDetailsByEmail(
        currentUser.getEmail()).getSystemRole();

    if (systemRole == SystemRole.USER) {
      return ownerManagementService.getOwnerByEmail(currentUser.getEmail());
    }

    return doctorManagementService.getDoctorByEmail(currentUser.getEmail());
  }
}

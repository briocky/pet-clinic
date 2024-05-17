package pl.edu.pw.ee.petclinic.domain.user.entity;

import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;

public interface SystemUser {
  Long getId();
  UserDetails getUserDetails();
  AuthData getAuthData();
  SystemRole getSystemRole();
}

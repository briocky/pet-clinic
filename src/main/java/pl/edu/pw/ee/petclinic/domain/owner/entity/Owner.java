package pl.edu.pw.ee.petclinic.domain.owner.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.SystemUser;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;

@Entity
@Table(name = "owners")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Owner implements SystemUser {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "owners_seq"
  )
  @SequenceGenerator(name = "owners_seq", allocationSize = 1)
  Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_details_id", referencedColumnName = "id")
  UserDetails userDetails;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_data_id", referencedColumnName = "id")
  AuthData authData;

  @Override
  public SystemRole getSystemRole() {
    return SystemRole.USER;
  }
}

package pl.edu.pw.ee.petclinic.domain.owner.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;

@Entity
@Table(name = "owners")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Owner {

  @Id
  Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_details_id", referencedColumnName = "id")
  UserDetails userDetails;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_data_id", referencedColumnName = "id")
  AuthData authData;
}

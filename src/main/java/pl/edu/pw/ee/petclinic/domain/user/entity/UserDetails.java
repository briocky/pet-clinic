package pl.edu.pw.ee.petclinic.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_details")
public class UserDetails {
  @Id
  Long id;
  String firstName;
  String lastName;
  String phoneNumber;
  String address;
  LocalDateTime birthDate;
}

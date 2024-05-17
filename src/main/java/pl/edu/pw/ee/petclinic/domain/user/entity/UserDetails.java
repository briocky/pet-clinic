package pl.edu.pw.ee.petclinic.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "user_details")
public class UserDetails {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "user_details_seq"
  )
  @SequenceGenerator(name = "user_details_seq", allocationSize = 1)
  Long id;
  String firstName;
  String lastName;
  String email;
  String phoneNumber;
  String address;
  LocalDateTime birthDate;
  String imageUrl;
  @Enumerated(EnumType.STRING)
  SystemRole systemRole;

  public String getName() {
    return firstName + " " + lastName;
  }
}

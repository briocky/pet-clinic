package pl.edu.pw.ee.petclinic.domain.user.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsDto {
  Long id;
  String firstName;
  String lastName;
  String email;
  String phoneNumber;
  String address;
  LocalDateTime birthDate;
  String imageUrl;
  SystemRole systemRole;
}

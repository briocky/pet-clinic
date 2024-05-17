package pl.edu.pw.ee.petclinic.domain.owner.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientRegistrationDto;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequest {

  @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
  @Size(min = 2, max = 255)
  @NotNull
  String email;

  @Size(min = 1, max = 15)
  @NotNull
  String password;

  @Size(min = 1, max = 15)
  @NotNull
  String confirmPassword;

  @Size(min = 1, max = 60)
  @NotNull
  String firstName;

  @Size(min = 1, max = 150)
  @NotNull
  String lastName;

  @NotNull
  @Size(min = 1, max = 255)
  String address;

  @NotNull
  String phoneNumber;

  @NotNull
  LocalDate birthDate;

  List<PatientRegistrationDto> pets;
}

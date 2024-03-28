package pl.edu.pw.ee.petclinic.domain.patient.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.patient.enums.Species;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientRegistrationDto {
  String name;
  Species species;
  String breed;
  LocalDateTime birthDate;
}

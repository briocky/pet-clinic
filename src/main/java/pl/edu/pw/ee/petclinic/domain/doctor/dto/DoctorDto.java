package pl.edu.pw.ee.petclinic.domain.doctor.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.doctor.enums.Specialization;
import pl.edu.pw.ee.petclinic.domain.user.dto.UserDetailsDto;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorDto {
  Long id;
  UserDetailsDto userDetailsDto;
  Specialization specialization;
}

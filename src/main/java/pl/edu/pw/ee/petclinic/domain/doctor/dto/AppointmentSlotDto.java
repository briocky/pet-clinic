package pl.edu.pw.ee.petclinic.domain.doctor.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentSlotDto {
  Long id;
  LocalDate date;
  LocalTime timeFrom;
  LocalTime timeTo;
  Long doctorId;
}

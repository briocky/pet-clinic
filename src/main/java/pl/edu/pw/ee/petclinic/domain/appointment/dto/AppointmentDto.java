package pl.edu.pw.ee.petclinic.domain.appointment.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.doctor.dto.DoctorDto;
import pl.edu.pw.ee.petclinic.domain.invoice.dto.InvoiceDto;
import pl.edu.pw.ee.petclinic.domain.owner.dto.OwnerDto;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientDto;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentDto {
  Long id;
  LocalDateTime dateTime;
  PatientDto patientDto;
  OwnerDto ownerDto;
  DoctorDto doctorDto;
  InvoiceDto invoiceDto;
}

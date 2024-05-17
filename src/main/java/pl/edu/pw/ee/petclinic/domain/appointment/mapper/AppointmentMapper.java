package pl.edu.pw.ee.petclinic.domain.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.pw.ee.petclinic.domain.appointment.dto.AppointmentDto;
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
  @Mapping(target = "patientDto", source = "patient")
  @Mapping(target = "ownerDto", source = "owner")
  @Mapping(target = "invoiceDto", source = "invoice")
  @Mapping(target = "doctorDto", source = "doctor")
  AppointmentDto getAppointmentDto(Appointment source);
}

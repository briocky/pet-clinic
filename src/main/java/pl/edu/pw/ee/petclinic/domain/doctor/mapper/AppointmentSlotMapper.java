package pl.edu.pw.ee.petclinic.domain.doctor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.pw.ee.petclinic.domain.doctor.dto.AppointmentSlotDto;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.AppointmentSlot;

@Mapper(componentModel = "spring")
public interface AppointmentSlotMapper {
  @Mapping(target = "id", source = "id")
  @Mapping(target = "timeFrom", ignore = true)
  @Mapping(target = "timeTo", ignore = true)
  @Mapping(target = "date", source = "date")
  @Mapping(target = "doctorId", source = "doctor.id")
  AppointmentSlotDto getAppointmentSlotDays(AppointmentSlot source);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "timeFrom", source = "timeFrom")
  @Mapping(target = "timeTo", source = "timeTo")
  @Mapping(target = "date", source = "date")
  @Mapping(target = "doctorId", source = "doctor.id")
  AppointmentSlotDto getAppointmentSlotHours(AppointmentSlot source);
}

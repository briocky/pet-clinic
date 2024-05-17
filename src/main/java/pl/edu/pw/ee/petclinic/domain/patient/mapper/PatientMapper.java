package pl.edu.pw.ee.petclinic.domain.patient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientDto;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientRegistrationDto;
import pl.edu.pw.ee.petclinic.domain.patient.entity.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {
  PatientDto getPatientDto(Patient source);

  @Mapping(target = "owner", ignore = true)
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "appointments", ignore = true)
  Patient getPatientFromPatientRegistration(PatientRegistrationDto source);
}

package pl.edu.pw.ee.petclinic.domain.doctor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.pw.ee.petclinic.domain.doctor.dto.DoctorDto;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.Doctor;
import pl.edu.pw.ee.petclinic.domain.user.mapper.UserDetailsMapper;

@Mapper(componentModel = "spring", uses = {UserDetailsMapper.class})
public interface DoctorMapper {
  @Mapping(target = "userDetailsDto", source = "userDetails")
  DoctorDto getDoctorDto(Doctor source);
}

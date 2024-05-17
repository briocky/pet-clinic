package pl.edu.pw.ee.petclinic.domain.user.mapper;

import org.mapstruct.Mapper;
import pl.edu.pw.ee.petclinic.domain.user.dto.UserDetailsDto;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
  UserDetailsDto getUserDetailsDto(UserDetails userDetails);
}

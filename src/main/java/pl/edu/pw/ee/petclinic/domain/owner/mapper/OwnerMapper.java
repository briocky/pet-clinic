package pl.edu.pw.ee.petclinic.domain.owner.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.pw.ee.petclinic.domain.owner.dto.OwnerDto;
import pl.edu.pw.ee.petclinic.domain.owner.dto.RegistrationRequest;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "authData.email", source = "email")
  @Mapping(target = "authData.password", source = "password")
  @Mapping(target = "userDetails.address", source = "address")
  @Mapping(target = "userDetails.birthDate", source = "birthDate")
  @Mapping(target = "userDetails.firstName", source = "firstName")
  @Mapping(target = "userDetails.lastName", source = "lastName")
  @Mapping(target = "userDetails.phoneNumber", source = "phoneNumber")
  @Mapping(target = "userDetails.email", source = "email")
  Owner getOwner(RegistrationRequest source);

  OwnerDto getOwnerDto(Owner source);
}

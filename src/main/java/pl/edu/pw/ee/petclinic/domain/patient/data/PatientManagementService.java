package pl.edu.pw.ee.petclinic.domain.patient.data;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.owner.data.OwnerManagementService;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientDto;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientRegistrationDto;
import pl.edu.pw.ee.petclinic.domain.patient.entity.Patient;
import pl.edu.pw.ee.petclinic.domain.patient.mapper.PatientMapper;
import pl.edu.pw.ee.petclinic.domain.user.data.AuthDataService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientManagementService {

  final PatientRepository patientRepository;
  final OwnerManagementService ownerManagementService;
  final PatientMapper patientMapper;
  final AuthDataService authDataService;

  public List<PatientDto> getOwnerPets() {
    Owner owner = getCurrentOwner();
    List<Patient> patients = patientRepository.findPatientsByOwnerId(
      owner.getId()
    );
    return patients.stream().map(patientMapper::getPatientDto).toList();
  }

  public PatientDto addNewPet(PatientRegistrationDto registrationDto) {
    Patient patient = patientMapper
      .getPatientFromPatientRegistration(registrationDto);
    Owner ownerByEmail = ownerManagementService.getOwnerByEmail(
        authDataService.getCurrentUserAuthData().getEmail());
    patient.setOwner(ownerByEmail);
    return patientMapper.getPatientDto(patientRepository.save(patient));
  }

  private Owner getCurrentOwner() {
    return ownerManagementService.getOwnerByEmail(
        authDataService.getCurrentUserAuthData().getUsername()
    );
  }
}

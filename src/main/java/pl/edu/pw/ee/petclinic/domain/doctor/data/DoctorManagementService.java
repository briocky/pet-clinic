package pl.edu.pw.ee.petclinic.domain.doctor.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.Doctor;
import pl.edu.pw.ee.petclinic.infrastructure.exception.DoctorNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorManagementService {

  private final DoctorRepository doctorRepository;

  public Doctor getDoctorByEmail(String email) {
    return doctorRepository.findDoctorByAuthDataEmail(email)
        .orElseThrow(() -> DoctorNotFoundException.of(
            String.format("Doctor with email %s could not be found", email)));
  }
}

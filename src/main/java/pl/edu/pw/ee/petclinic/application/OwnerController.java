package pl.edu.pw.ee.petclinic.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.ee.petclinic.domain.appointment.data.AppointmentService;
import pl.edu.pw.ee.petclinic.domain.appointment.dto.AppointmentDto;
import pl.edu.pw.ee.petclinic.domain.owner.data.OwnerManagementService;
import pl.edu.pw.ee.petclinic.domain.owner.dto.OwnerDto;
import pl.edu.pw.ee.petclinic.domain.patient.data.PatientManagementService;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientDto;
import pl.edu.pw.ee.petclinic.domain.patient.dto.PatientRegistrationDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/owner")
@Slf4j
public class OwnerController {

  final PatientManagementService patientManagementService;
  final OwnerManagementService ownerManagementService;
  final AppointmentService appointmentService;

  // gets all owner's pets
  @GetMapping("/pets/all")
  public ResponseEntity<List<PatientDto>> getPets() {
    return ResponseEntity.ok(patientManagementService.getOwnerPets());
  }

  // adds new pet
  @PostMapping("/pets/new")
  public ResponseEntity<PatientDto> addNewPet(
    @RequestBody PatientRegistrationDto registrationDto
  ) {
    return new ResponseEntity<>(
      patientManagementService.addNewPet(registrationDto),
      HttpStatus.CREATED
    );
  }

  // delete & update pets

  // owner's account details
  @GetMapping("/details")
  public ResponseEntity<OwnerDto> getAccountDetails() {
    return ResponseEntity.ok(
        ownerManagementService.getAccountDetails()
    );
  }

  //dostep do tego moze miec tylko uzytkownik(nie doktor) - przez PreAuthorize
  // order appointments
  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/appointments/upcoming")
  public ResponseEntity<List<AppointmentDto>> getUpcomingAppointments() {
    return ResponseEntity.ok(
        appointmentService.getUpcomingAppointments()
    );
  }

  // to order an appointment, current doctor's calendar is needed..
  // you make a meeting suitable for doctor's calendar
  public ResponseEntity<AppointmentDto> orderAppointment() {
    return null;
  }

  //chatWithDoctor
  //getAppointmentsForPet
}

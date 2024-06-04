package pl.edu.pw.ee.petclinic.domain.doctor.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.doctor.dto.AppointmentSlotDto;
import pl.edu.pw.ee.petclinic.domain.doctor.dto.DoctorDto;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.AppointmentSlot;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.Doctor;
import pl.edu.pw.ee.petclinic.domain.doctor.mapper.AppointmentSlotMapper;
import pl.edu.pw.ee.petclinic.domain.doctor.mapper.DoctorMapper;
import pl.edu.pw.ee.petclinic.infrastructure.exception.DoctorNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorManagementService {

  private final DoctorRepository doctorRepository;
  private final DoctorMapper doctorMapper;
  private final AppointmentSlotMapper appointmentSlotMapper;
  private final AppointmentSlotRepository appointmentSlotRepository;

  public Doctor getDoctorByEmail(String email) {
    return doctorRepository.findDoctorByAuthDataEmail(email)
        .orElseThrow(() -> DoctorNotFoundException.of(
            String.format("Doctor with email %s could not be found", email)));
  }

  public List<DoctorDto> getAvailableDoctors() {
    return doctorRepository.findAll().stream().map(doctorMapper::getDoctorDto).toList();
  }

  public List<AppointmentSlotDto> getDoctorAvailableAppointmentDays(Long id) {
    return appointmentSlotRepository.findByDoctor_Id(id).stream().map(appointmentSlotMapper::getAppointmentSlotDays).toList();
  }

  public List<AppointmentSlotDto> getDoctorAvailableAppointmentHourSlots(Long id, LocalDate date) {
    return appointmentSlotRepository.findByDoctor_IdAndDate(id, date).stream().map(appointmentSlotMapper::getAppointmentSlotHours).toList();
  }
}

package pl.edu.pw.ee.petclinic.domain.appointment.data;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.petclinic.domain.appointment.dto.AppointmentDto;
import pl.edu.pw.ee.petclinic.domain.appointment.mapper.AppointmentMapper;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;
import pl.edu.pw.ee.petclinic.domain.user.data.CurrentUserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final CurrentUserService currentUserService;
  private final AppointmentMapper appointmentMapper;

  //dostep do tego moze miec tylko uzytkownik(nie doktor) - przez PreAuthorize
  public List<AppointmentDto> getUpcomingAppointments() {
    Owner currentUser = (Owner) currentUserService.getCurrentSystemUser();
    return appointmentRepository.findAppointmentsByOwnerAndDateTimeAfter(currentUser, LocalDateTime.now())
        .stream().map(appointmentMapper::getAppointmentDto).toList();
  }
}

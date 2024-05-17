package pl.edu.pw.ee.petclinic.domain.appointment.data;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  List<Appointment> findAppointmentsByOwnerAndDateTimeAfter(Owner owner, LocalDateTime timeNow);
}

package pl.edu.pw.ee.petclinic.domain.doctor.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.AppointmentSlot;

import java.time.LocalDate;
import java.util.List;

@Repository
interface AppointmentSlotRepository extends JpaRepository<AppointmentSlot, Long> {
  List<AppointmentSlot> findByDoctor_Id(Long id);

  List<AppointmentSlot> findByDoctor_IdAndDate(Long id, LocalDate date);
}

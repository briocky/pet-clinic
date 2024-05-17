package pl.edu.pw.ee.petclinic.domain.doctor.data;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  Optional<Doctor> findDoctorByAuthDataEmail(String email);
}

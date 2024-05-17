package pl.edu.pw.ee.petclinic.domain.patient.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.petclinic.domain.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
  List<Patient> findPatientsByOwnerId(Long ownerId);
}

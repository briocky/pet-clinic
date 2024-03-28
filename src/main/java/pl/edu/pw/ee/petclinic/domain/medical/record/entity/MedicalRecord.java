package pl.edu.pw.ee.petclinic.domain.medical.record.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.patient.entity.Patient;

@Entity
@Table(name = "medical_records")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class MedicalRecord {
  @Id
  Long id;
  @OneToOne
  @JoinColumn(name = "patient_id", referencedColumnName = "id")
  Patient patient;
  @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  Set<MedicalExamination> medicalExaminations;
}

package pl.edu.pw.ee.petclinic.domain.medical.record.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.Doctor;

@Entity
@Table(name = "medical_examinations")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class MedicalExamination {

  @Id
  Long id;
  @ManyToOne
  @JoinColumn(name = "medical_record_id", referencedColumnName = "id")
  MedicalRecord medicalRecord;
  LocalDateTime examinationTime;
  @ManyToOne
  @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  Doctor doctor;
  @ManyToOne
  @JoinColumn(name = "appointment_id", referencedColumnName = "id")
  Appointment appointment;
  String description;
  String diagnose;
  String recommendations;
}

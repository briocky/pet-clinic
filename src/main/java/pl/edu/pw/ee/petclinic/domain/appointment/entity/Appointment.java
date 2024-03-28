package pl.edu.pw.ee.petclinic.domain.appointment.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.doctor.entity.Doctor;
import pl.edu.pw.ee.petclinic.domain.invoice.entity.Invoice;
import pl.edu.pw.ee.petclinic.domain.patient.entity.Patient;

@Entity
@Table(name = "appointments")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  LocalDateTime dateTime;
  @ManyToOne
  @JoinColumn(name = "patient_id", referencedColumnName = "id")
  Patient patient;
  @ManyToOne
  @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  Doctor doctor;
  @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
  Invoice invoice;
}

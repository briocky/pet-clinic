package pl.edu.pw.ee.petclinic.domain.doctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments_slots")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AppointmentSlot {
  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "appointments_slots_seq"
  )
  @SequenceGenerator(name = "appointments_slots_seq", allocationSize = 1)
  Long id;
  LocalDate date;
  LocalTime timeFrom;
  LocalTime timeTo;
  @ManyToOne
  @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  Doctor doctor;
}

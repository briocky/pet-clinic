package pl.edu.pw.ee.petclinic.domain.patient.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;
import pl.edu.pw.ee.petclinic.domain.owner.entity.Owner;
import pl.edu.pw.ee.petclinic.domain.patient.enums.Breed;
import pl.edu.pw.ee.petclinic.domain.patient.enums.Species;

@Entity
@Table(name = "patients")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Patient {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "patients_seq"
  )
  @SequenceGenerator(name = "patients_seq", allocationSize = 1)
  Long id;
  String name;
  Species species;
  @Enumerated(EnumType.STRING)
  Breed breed;
  LocalDate birthDate;
  @ManyToOne
  @JoinColumn(name = "owner_id", referencedColumnName = "id")
  Owner owner;
  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  Set<Appointment> appointments;
}

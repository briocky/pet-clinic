package pl.edu.pw.ee.petclinic.domain.doctor.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;
import pl.edu.pw.ee.petclinic.domain.doctor.enums.Specialization;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;

@Entity
@Table(name = "doctors")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Doctor {

  @Id
  Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_details_id", referencedColumnName = "id")
  UserDetails userDetails;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_data_id", referencedColumnName = "id")
  AuthData authData;
  @Enumerated(EnumType.STRING)
  Specialization specialization;
  @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
  Set<Appointment> appointments;
}
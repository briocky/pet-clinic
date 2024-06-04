package pl.edu.pw.ee.petclinic.domain.doctor.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;
import pl.edu.pw.ee.petclinic.domain.doctor.enums.Specialization;
import pl.edu.pw.ee.petclinic.domain.user.entity.AuthData;
import pl.edu.pw.ee.petclinic.domain.user.entity.SystemUser;
import pl.edu.pw.ee.petclinic.domain.user.entity.UserDetails;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "doctors")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Doctor implements SystemUser {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "doctors_seq"
  )
  @SequenceGenerator(name = "doctors_seq", allocationSize = 1)
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
  @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
  List<AppointmentSlot> appointmentsSlots;

  @Override
  public SystemRole getSystemRole() {
    return SystemRole.DOCTOR;
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass = o instanceof HibernateProxy
        ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
        : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy
        ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    Doctor doctor = (Doctor) o;
    return getId() != null && Objects.equals(getId(), doctor.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }
}

package pl.edu.pw.ee.petclinic.domain.invoice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.appointment.entity.Appointment;

@Entity
@Table(name = "invoices")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Invoice {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "invoices_seq"
  )
  @SequenceGenerator(name = "invoices_seq", allocationSize = 1)
  Long id;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "appointment_id", referencedColumnName = "id")
  Appointment appointment;
  double price;
  String description;
  LocalDateTime issuedAt;
  boolean isPaid;
}

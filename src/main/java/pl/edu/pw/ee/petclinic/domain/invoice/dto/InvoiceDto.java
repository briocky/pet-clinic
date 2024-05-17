package pl.edu.pw.ee.petclinic.domain.invoice.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceDto {
  Long id;
  double price;
  String description;
  LocalDateTime issuedAt;
  boolean isPaid;
}

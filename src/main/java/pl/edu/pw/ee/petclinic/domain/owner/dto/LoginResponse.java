package pl.edu.pw.ee.petclinic.domain.owner.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.pw.ee.petclinic.domain.user.enums.SystemRole;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
  String email;
  String name;
  SystemRole systemRole;
  String accessToken;
  @JsonIgnore
  String refreshToken;
}

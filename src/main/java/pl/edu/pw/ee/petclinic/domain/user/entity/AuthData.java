package pl.edu.pw.ee.petclinic.domain.user.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "auth_data")
public class AuthData implements UserDetails {

  @Id
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "auth_datas_seq"
  )
  @SequenceGenerator(name = "auth_datas_seq", allocationSize = 1)
  Long id;
  String email;
  String password;
  boolean accountExpired;
  boolean accountLocked;
  boolean credentialsExpired;
  boolean enabled = true;
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "auth_data_roles", joinColumns = @JoinColumn(name = "auth_data_id"))
  @Column(name = "role")
  @Builder.Default
  Collection<String> roles = new ArrayList<>(List.of("ROLE_USER"));

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return !accountExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !accountLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return !credentialsExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}

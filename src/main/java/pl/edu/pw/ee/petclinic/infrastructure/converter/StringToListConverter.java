package pl.edu.pw.ee.petclinic.infrastructure.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Converter
public class StringToListConverter implements AttributeConverter<Collection<? extends GrantedAuthority>, String> {

  @Override
  public String convertToDatabaseColumn(Collection<? extends GrantedAuthority> list) {
    if(list == null || list.isEmpty()) return "";
    return String.join(",", list.stream().map(GrantedAuthority::getAuthority).toList());
  }

  @Override
  public Collection<? extends GrantedAuthority> convertToEntityAttribute(String joined) {
    if(joined == null) return List.of();
    return Arrays.stream(joined.split(","))
        .map(SimpleGrantedAuthority::new).toList();
  }
}

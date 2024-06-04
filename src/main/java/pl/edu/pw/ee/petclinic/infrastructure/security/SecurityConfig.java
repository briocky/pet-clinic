package pl.edu.pw.ee.petclinic.infrastructure.security;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityConfig {

  final JwtTokenFilter jwtTokenFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
      throws Exception {
    httpSecurity.cors(Customizer.withDefaults());
    httpSecurity.csrf(AbstractHttpConfigurer::disable);

    httpSecurity.sessionManagement(session ->
        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );

    httpSecurity.addFilterBefore(
        jwtTokenFilter,
        UsernamePasswordAuthenticationFilter.class
    );

    httpSecurity.authorizeHttpRequests(matchingRegistry -> {
      //Auth endpoints
      matchingRegistry.requestMatchers("/api/login").permitAll();
      matchingRegistry.requestMatchers("/api/register").permitAll();

      //Other endpoints
      matchingRegistry.anyRequest().authenticated();
    });

    return httpSecurity.build();
  }
}

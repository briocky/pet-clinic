package pl.edu.pw.ee.petclinic.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

  private static final String JWT_TOKEN_HEADER = "Authorization";
  private static final String JWT_TOKEN_PREFIX = "Bearer ";
  private final static String REFRESH_TOKEN_ENDPOINT = "/api/refresh-token";

  private final JwtGenerator jwtGenerator;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain
  ) throws ServletException, IOException {
    final String token = extractJwtFromRequest(request);

    if (token == null) {
      filterChain.doFilter(request, response);
      return;
    }

    final String userEmail = !REFRESH_TOKEN_ENDPOINT.equals(
        request.getServletPath()
    )
    ? jwtGenerator.extractUserSubjectFromAccessToken(token)
    : jwtGenerator.extractUserSubjectFromRefreshToken(token);

    attemptAuthenticateUser(token, userEmail, request);

    filterChain.doFilter(request, response);
  }

  private void attemptAuthenticateUser(String token, String userEmail, HttpServletRequest request) {
    final UserDetails userDetails = userDetailsService.loadUserByUsername(
        userEmail
    );

    final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
        userDetails,
        null,
        userDetails.getAuthorities()
    );

    jwtGenerator.validateToken(token, userDetails);

    authentication.setDetails(
        new WebAuthenticationDetailsSource().buildDetails(request)
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    log.debug("Successfully authenticated user with email=[{}]", userEmail);
  }

  private String extractJwtFromRequest(HttpServletRequest request) {
    final String userToken = request.getHeader(JWT_TOKEN_HEADER);

    if (userToken == null || !userToken.startsWith(JWT_TOKEN_PREFIX)) {
      return null;
    }

    return userToken.replace(JWT_TOKEN_PREFIX, "");
  }
}

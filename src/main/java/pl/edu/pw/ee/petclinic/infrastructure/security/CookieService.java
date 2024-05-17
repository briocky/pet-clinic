package pl.edu.pw.ee.petclinic.infrastructure.security;

import jakarta.servlet.http.Cookie;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CookieService {

  public static final String ACCESS_TOKEN_COOKIE_NAME = "accessToken";
  public static final String REFRESH_TOKEN_COOKIE_NAME = "refreshToken";

  @Value("${app.cookie.domain}")
  String domain;

  @Value("${app.cookie.max-age}")
  int maxAge;

  public Cookie createAccessTokenCookie(String accessToken) {
    Cookie cookie = new Cookie(ACCESS_TOKEN_COOKIE_NAME, accessToken);
    cookie.setHttpOnly(true);
    cookie.setDomain(domain);
    cookie.setMaxAge(maxAge);
    return cookie;
  }

  public Cookie createRefreshTokenCookie(String refreshToken) {
    final String cookieUrl = "/api/refresh-token";
    Cookie cookie = new Cookie(REFRESH_TOKEN_COOKIE_NAME, refreshToken);
    cookie.setHttpOnly(true);
    cookie.setDomain(domain);
    cookie.setPath(cookieUrl);
    cookie.setMaxAge(maxAge);
    return cookie;
  }
}

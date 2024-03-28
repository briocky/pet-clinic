package pl.edu.pw.ee.petclinic.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pl.edu.pw.ee.petclinic.infrastructure.exception.TokenException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtGenerator {
  public static final String REFRESH_TOKEN_CLAIM_NAME = "isRefreshToken";

  private final TokenProperties tokenProperties;
  private final Clock clock;

  public String generateAccessToken(UserDetails userDetails) {
    JwtBuilder accessTokenBuilder = generateTokenForUserDetails(
        tokenProperties.getAccessTokenExpirationLength(),
        userDetails
    );

    final Map<String, Object> refreshTokenClaims = Map.ofEntries(
        Map.entry(REFRESH_TOKEN_CLAIM_NAME, Boolean.FALSE)
    );
    accessTokenBuilder.addClaims(refreshTokenClaims);

    return accessTokenBuilder.compact();
  }

  public String generateRefreshToken(UserDetails userDetails) {
    JwtBuilder refreshTokenBuilder = generateTokenForUserDetails(
        tokenProperties.getRefreshTokenExpirationLength(),
        userDetails
    );

    final Map<String, Object> refreshTokenClaims = Map.ofEntries(
        Map.entry(REFRESH_TOKEN_CLAIM_NAME, Boolean.TRUE)
    );
    refreshTokenBuilder.addClaims(refreshTokenClaims);

    return refreshTokenBuilder.compact();
  }

  public String extractUserSubjectFromAccessToken(String accessToken) {
    Claims accessTokenClaims = extractTokenClaims(accessToken);

    Boolean isRefreshToken = accessTokenClaims.get(
        JwtGenerator.REFRESH_TOKEN_CLAIM_NAME,
        Boolean.class
    );

    if (Boolean.TRUE.equals(isRefreshToken)) {
      throw TokenException.of(
          "Attempt to extract subject from accessToken when refreshToken was provided"
      );
    }

    return accessTokenClaims.getSubject();
  }

  public String extractUserSubjectFromRefreshToken(String refreshToken) {
    final Claims refreshTokenClaims = extractTokenClaims(refreshToken);

    Boolean isRefreshToken = refreshTokenClaims.get(
        JwtGenerator.REFRESH_TOKEN_CLAIM_NAME,
        Boolean.class
    );

    if (Boolean.FALSE.equals(isRefreshToken)) {
      throw TokenException.of(
          "Attempt to extract subject from refreshToken when accessToken was provided"
      );
    }

    return refreshTokenClaims.getSubject();
  }

  public void validateToken(String userToken, UserDetails userDetails) {
    final byte[] secretKey = tokenProperties
        .getTokenSecretKey()
        .getBytes();
    Claims claimsJws = Jwts
        .parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(userToken)
        .getBody();
    final Date expirationDate = claimsJws.getExpiration();
    final Date now = new Date();
    final String userName = claimsJws.getSubject();

    if (now.after(expirationDate)) {
      throw new IllegalStateException("User token has expired");
    } else if (!userName.equals(userDetails.getUsername())) {
      throw new IllegalStateException("UserToken does not equals userDetails");
    }
  }

  private Claims extractTokenClaims(String userToken) {
    final byte[] secretKey = tokenProperties
        .getTokenSecretKey()
        .getBytes();

    return Jwts
        .parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(userToken)
        .getBody();
  }

  private JwtBuilder generateTokenForUserDetails(
      int tokenExpirationTimeInMinutes,
      UserDetails userDetails
  ) {
    final String userEmail = userDetails.getUsername();
    final Instant issuedAt = clock.instant();
    final Instant expirationDate = issuedAt.plus(
        tokenExpirationTimeInMinutes,
        ChronoUnit.MINUTES
    );
    final byte[] secretKey = tokenProperties
        .getTokenSecretKey()
        .getBytes();

    return Jwts
        .builder()
        .setSubject(userEmail)
        .setIssuedAt(Date.from(issuedAt))
        .setExpiration(Date.from(expirationDate))
        .signWith(Keys.hmacShaKeyFor(secretKey), SignatureAlgorithm.HS512);
  }
}

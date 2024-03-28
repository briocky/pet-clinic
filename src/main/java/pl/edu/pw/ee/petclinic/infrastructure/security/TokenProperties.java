package pl.edu.pw.ee.petclinic.infrastructure.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app.token")
@Component
@Getter
@Setter
class TokenProperties {

	private int accessTokenExpirationLength;
	private int refreshTokenExpirationLength;
	private String tokenSecretKey;
}

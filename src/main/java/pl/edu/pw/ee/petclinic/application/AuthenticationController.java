package pl.edu.pw.ee.petclinic.application;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.ee.petclinic.domain.owner.data.OwnerManagementService;
import pl.edu.pw.ee.petclinic.domain.owner.dto.LoginRequest;
import pl.edu.pw.ee.petclinic.domain.owner.dto.LoginResponse;
import pl.edu.pw.ee.petclinic.domain.owner.dto.RegistrationRequest;
import pl.edu.pw.ee.petclinic.domain.owner.dto.RegistrationResponse;
import pl.edu.pw.ee.petclinic.domain.user.data.AuthenticationService;
import pl.edu.pw.ee.petclinic.infrastructure.security.CookieService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
class AuthenticationController {

	private final OwnerManagementService ownerManagementService;
	private final CookieService cookieService;
	private final AuthenticationService authenticationService;

	/**
	 * Register the pet's owner into the system.
	 * Doctor is registered in other way. (e.g. manually by admin)
	 */
	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> createUser(
		@RequestBody @Valid RegistrationRequest registrationDTO,
		HttpServletResponse response
	) {
		RegistrationResponse registerResponse = ownerManagementService.createUser(registrationDTO);
		response.addCookie(
				cookieService.createAccessTokenCookie(registerResponse.getAccessToken())
		);
		response.addCookie(
				cookieService.createRefreshTokenCookie(registerResponse.getRefreshToken())
		);
		return new ResponseEntity<>(
			registerResponse,
			HttpStatus.CREATED
		);
	}

	/**
	 * Login endpoint for every "kind" of user (owner, doctor etc.)
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticateUser(
		@RequestBody LoginRequest loginRequest,
		HttpServletResponse response
	) {
		LoginResponse loginResponse = authenticationService.authenticateUser(
			loginRequest
		);
		response.addCookie(
				cookieService.createAccessTokenCookie(loginResponse.getAccessToken())
		);
		response.addCookie(
				cookieService.createRefreshTokenCookie(loginResponse.getRefreshToken())
		);

		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}
//
//	@GetMapping("/refresh-token")
//	public ResponseEntity<TokenAuthResponse> handleRefreshToken(
//		HttpServletRequest httpServletRequest
//	) {
//		Try<TokenAuthResponse> refreshTry = userAuthenticationFacade.refreshToken(
//			httpServletRequest
//		);
//
//		if (refreshTry.isFailure()) {
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		}
//
//		return new ResponseEntity<>(refreshTry.get(), HttpStatus.OK);
//	}
}

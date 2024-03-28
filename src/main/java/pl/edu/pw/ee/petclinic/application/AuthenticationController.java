package pl.edu.pw.ee.petclinic.application;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.ee.petclinic.domain.appointment.dto.RegistrationRequest;
import pl.edu.pw.ee.petclinic.domain.appointment.dto.RegistrationResponse;
import pl.edu.pw.ee.petclinic.domain.owner.data.OwnerManagementService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
class AuthenticationController {

//	private final OwnerManagementService ownerManagementService;
//	private final UserAuthenticationFacade userAuthenticationFacade;
//
//	@PostMapping("/register")
//	public ResponseEntity<RegistrationResponse> createUser(
//		@RequestBody @Valid RegistrationRequest registrationDTO
//	) {
//		return new ResponseEntity<>(
//			ownerManagementService.createUser(registrationDTO),
//			HttpStatus.CREATED
//		);
//	}
//
//	@PostMapping("/login")
//	public ResponseEntity<UserLoginResponse> authenticateUser(
//		@RequestBody UserLoginRequest userLoginRequestDTO
//	) {
//		UserLoginResponse userLoginResponse = userAuthenticationFacade.authenticateUserCredentials(
//			userLoginRequestDTO
//		);
//
//		return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
//	}
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

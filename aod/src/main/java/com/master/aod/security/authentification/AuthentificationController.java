package com.master.aod.security.authentification;

import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.master.aod.common.Error;
import com.master.aod.security.AuthentificationRequest;
import com.master.aod.security.TokenUtils;
import com.master.aod.security.UserAuthentificationInscription;
import com.master.aod.security.service.JwtAuthentificationResponse;
import com.master.aod.security.service.UserService;

@CrossOrigin(origins = { "http://localhost:4200" }, maxAge = 3000)
@RestController
public class AuthentificationController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AuthentificationController.class);

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtils jwtTokenUtil;

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("jwtUserDetailsService")
	private UserDetailsService userDetailsService;


	@RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthentificationRequest authenticationRequest)
			throws AuthenticationException {
		return ResponseEntity
				.ok(authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	}

	@RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
	public ResponseEntity<?> registerUserForAuthentification(
			@Valid @RequestBody final UserAuthentificationInscription inscription, Errors errors) {
		if (errors.hasErrors()) {
			logger.warn(errors.getAllErrors().toString());
			return new ResponseEntity<>(errors.getAllErrors().stream()
					.map(a -> new Error(a.getDefaultMessage(), a.getCodes())).collect(Collectors.toList()),
					HttpStatus.BAD_REQUEST);
		}
		logger.warn("Registration start now");
		userService.registerUser(inscription);
		return ResponseEntity.ok(authenticate(inscription.getUserName(), inscription.getPassword()));

	}

	private JwtAuthentificationResponse authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			JwtAuthentificationResponse token = new JwtAuthentificationResponse(
					jwtTokenUtil.generateToken(userDetails));
			logger.warn("Token is generated");
			return token;

		} catch (DisabledException e) {
			throw new BadCredentialsException("User is disabled!", e);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Bad credentials!", e);
		}
	}

	// Fix-Me Please !!!!
	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
	}

}

package com.master.aod.security.service;

import java.sql.Date;
import java.time.Instant;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.master.aod.entities.User.Authority;
import com.master.aod.entities.User.AuthorityName;
import com.master.aod.entities.User.User;
import com.master.aod.entities.repository.AuthorityRepository;
import com.master.aod.security.UserAuthentificationInscription;

@Component
public class UserAuthentificationToUserConverter implements Function<UserAuthentificationInscription, User> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuthorityRepository repoAuthority;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User apply(UserAuthentificationInscription t) {
		User userForInscrption = new User();
		userForInscrption.setEmail(t.getEmail());
		userForInscrption.setUserName(t.getUserName());
		userForInscrption.setPassword(passwordEncoder.encode(t.getPassword()));
		userForInscrption.setFirstName(t.getFirstName());
		userForInscrption.setLastNamme(t.getLastName());
		userForInscrption.setLastPasswordRestDate(Date.from(Instant.now()));
		userForInscrption.setEnabled(true);
		userForInscrption.setAuthorities(setAuthoritiesForUser());
		return userForInscrption;
	}

	// Fix-Me
	public Set<Authority> setAuthoritiesForUser() {
		boolean isPresent = repoAuthority.findByName(AuthorityName.ROLE_USER).isPresent();
		if (isPresent) {
			Authority auth = repoAuthority.findByName(AuthorityName.ROLE_USER).get();
			return Stream.of(auth).collect(Collectors.toSet());
		} else {
			logger.warn("couldn't find ROLE_USER In data base ---> Look to the User Converter Authentification");
			return null;
		}
	}

}

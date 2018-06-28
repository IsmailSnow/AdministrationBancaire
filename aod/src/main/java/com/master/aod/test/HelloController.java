package com.master.aod.test;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.master.aod.entities.User.AuthorityName;
import com.master.aod.entities.User.User;
import com.master.aod.entities.repository.UserRepository;
import com.master.aod.security.TokenUtils;

@RestController
public class HelloController {

	// set les credentiels to authentification , so we can test the authentication

	@Autowired
	private UserRepository userRepository;

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hello getHelloWorld() {
		return new Hello("Sending a Hello from the backend ! , Here is the existing users :"
				+ userRepository.findAll().stream().map(User::getEmail).collect(Collectors.joining("/")));
	}

}

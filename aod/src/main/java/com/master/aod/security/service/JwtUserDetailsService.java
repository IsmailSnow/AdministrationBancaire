package com.master.aod.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.master.aod.entities.repository.UserRepository;
import com.master.aod.security.UserAuthentificationFactory;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		if (userRepository.findByUsername(username).isPresent()) {
			return UserAuthentificationFactory.create(userRepository.findByUsername(username).get());
		} else {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}
	}

}

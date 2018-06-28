package com.master.aod.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.master.aod.entities.User.Authority;
import com.master.aod.entities.User.User;

public class UserAuthentificationFactory {

	private UserAuthentificationFactory() {
	}

	public static UserAuthentification create(User user) {
		return new UserAuthentification(
				user.getId(),
				user.getUserName(),
				user.getFirstName(),
				user.getLastNamme(),
				user.getEmail(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getAuthorities()),
				user.getEnabled(),
				user.getLastPasswordRestDate());
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Authority> set) {
		return set
				.stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
				.collect(Collectors.toList());
	}

}

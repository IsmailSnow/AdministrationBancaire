package com.master.aod.security;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class AuthentificationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2109941392988061239L;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;

	public AuthentificationRequest() {
		super();
	}

	public AuthentificationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

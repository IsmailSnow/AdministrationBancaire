package com.master.aod.security;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import com.master.aod.validation.UserNameValidation;

public class UserAuthentificationInscription {

	@NotEmpty
	@UserNameValidation
	private String userName;
	@NotEmpty
	private String password;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String email;

	public UserAuthentificationInscription(String userName, String password, String lastName, String firstName,
			String email, Date birthDay) {
		super();
		this.userName = userName;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	public UserAuthentificationInscription() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

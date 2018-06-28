package com.master.aod.security.service;

import com.master.aod.security.UserAuthentificationInscription;

public interface UserService {

	public void createUser(UserAuthentificationInscription user);
	
	public void registerUser(UserAuthentificationInscription inscription);
}

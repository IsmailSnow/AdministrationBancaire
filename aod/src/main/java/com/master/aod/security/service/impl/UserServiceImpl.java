package com.master.aod.security.service.impl;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.aod.entities.repository.UserRepository;
import com.master.aod.security.UserAuthentificationInscription;
import com.master.aod.security.service.UserAuthentificationToUserConverter;
import com.master.aod.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserAuthentificationToUserConverter converterToUser;

	@Autowired
	private UserRepository userRepo;

	@Override
	public void createUser(UserAuthentificationInscription userInscription) {
		userRepo.save(converterToUser.apply(userInscription));
	}

	@Transactional(readOnly = true)
	@Override
	public void registerUser(UserAuthentificationInscription inscription) {
		this.createUser(inscription);
	}

}

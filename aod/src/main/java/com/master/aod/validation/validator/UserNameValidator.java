package com.master.aod.validation.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.master.aod.entities.repository.UserRepository;
import com.master.aod.validation.UserNameValidation;

public class UserNameValidator implements ConstraintValidator<UserNameValidation, String> {

	@Autowired
	private UserRepository repo;

	public UserNameValidator(UserRepository repo) {
		this.repo = repo;
	}

	public void initialize(UserNameValidation constraint) {
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return Objects.isNull(username) && !repo.findByUsername(username).isPresent();
	}

}

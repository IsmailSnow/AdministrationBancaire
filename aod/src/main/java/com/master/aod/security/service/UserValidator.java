//package com.master.aod.security.service;
//
//import java.util.Objects;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import com.master.aod.security.UserAuthentificationInscription;
//
//@Component
//public class UserValidator implements Validator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return UserAuthentificationInscription.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors e) {
//
//		UserAuthentificationInscription user = (UserAuthentificationInscription) target;
//		if (Objects.isNull(user.getEmail())) {
//			e.rejectValue("email", "email invalide ");
//		}
//		if (Objects.isNull(user.getFirstName())) {
//			e.rejectValue("firstName", "firstName invalide ");
//		}
//		if (Objects.isNull(user.getLastName())) {
//			e.rejectValue("lastName", "lastName invalide ");
//		}
//		if (Objects.isNull(user.getPassword())) {
//			e.rejectValue("password", "password invalide ");
//		}
//		if (Objects.isNull(user.getUserName())) {
//			e.rejectValue("userName", "userName invalide ");
//		}
//
//	}
//
//}

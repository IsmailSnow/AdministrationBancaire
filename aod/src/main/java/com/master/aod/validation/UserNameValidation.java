package com.master.aod.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.master.aod.validation.validator.UserNameValidator;

@Documented
@Constraint(validatedBy = UserNameValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNameValidation {

	String message() default "this username is  user Already taken,Try Using another username ! Thanks you";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

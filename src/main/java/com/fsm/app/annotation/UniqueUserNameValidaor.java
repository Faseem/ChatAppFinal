package com.fsm.app.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsm.app.repository.UserRepository;

public class UniqueUserNameValidaor implements ConstraintValidator<UniqueUser, String>{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueUser constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(userRepository == null){
		return true;
		}
		return userRepository.findByName(value)==null;
	}

}

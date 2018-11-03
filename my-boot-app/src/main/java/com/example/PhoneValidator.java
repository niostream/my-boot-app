package com.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
	
	private boolean onlyNumber;
	
	public void initialize(Phone phone) {
		this.onlyNumber = phone.onlyNumber();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		if (onlyNumber) {
			return value.matches("[0-9]*");
		} else {
			return value.matches("[0-9()-]*");
		}
	}

}

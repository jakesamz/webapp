package com.linjw.business.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GlobalValidator  implements Validator {

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void validate(Object target, Errors errors) {
		
		errors.reject("calling GlobalValidator, added a global error...");
	}

}

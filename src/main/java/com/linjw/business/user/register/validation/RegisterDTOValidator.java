package com.linjw.business.user.register.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.linjw.business.user.register.dto.RegisterDTO;
import com.linjw.spring.validation.beans.ValidationBean;

public class RegisterDTOValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return RegisterDTO.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
	
		RegisterDTO dto = (RegisterDTO)target;
		
		ValidationBean vbean = validateUsername(dto.getUsername());
		if(vbean.getIsNotValid()) {
			errors.rejectValue("username", vbean.getMessage());
		}
		
	}
	
	public ValidationBean validateUsername(String username) {
		return new ValidationBean(true, "does not valid");
	}

}

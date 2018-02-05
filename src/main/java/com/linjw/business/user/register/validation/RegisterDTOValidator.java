package com.linjw.business.user.register.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.linjw.business.user.register.dto.RegisterDTO;
import com.linjw.business.utils.Result;
import com.linjw.business.utils.check.CheckUserNameTaken;
import com.linjw.business.utils.check.ICheckObj;
import com.linjw.spring.validation.beans.ValidationBean;

public class RegisterDTOValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return RegisterDTO.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
	
		RegisterDTO dto = (RegisterDTO)target;
		
		ICheckObj<String> checker = new CheckUserNameTaken();
		Result r = checker.check(dto.getUsername());
		
		if(!r.getFlag()) {
			errors.rejectValue("username", r.getMsg());
		}
		
	}

}

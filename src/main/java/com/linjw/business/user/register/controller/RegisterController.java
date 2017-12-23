package com.linjw.business.user.register.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjw.business.user.register.dto.RegisterDTO;
import com.linjw.business.user.register.validation.RegisterDTOValidator;

@Controller
public class RegisterController {

	@RequestMapping("register-page")
	public void registerPage() {}

	@RequestMapping("register")
	@ResponseBody
	public List<FieldError> register(
		HttpServletRequest req,
		HttpServletResponse resp,
		@Valid RegisterDTO dto, BindingResult result) {
		
		System.out.println(result);
		List<FieldError> fieldErrors = result.getFieldErrors();
		return fieldErrors;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new RegisterDTOValidator());
	}
	
}

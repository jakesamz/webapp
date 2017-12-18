package com.linjw.business.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linjw.business.validation.beans.Person;
import com.linjw.business.validation.validator.PersonValidator;

@Controller
public class ValidationController {

	@RequestMapping(value="personpage")
	public void personpage() {
	}
	
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public void person(@Valid Person person, BindingResult bindingResult) {
		bindingResult.hasErrors();
		System.out.println(bindingResult);
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new PersonValidator());
    }
}

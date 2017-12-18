package com.linjw.business.validation.test;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.linjw.business.validation.beans.Person;
import com.linjw.business.validation.validator.PersonValidator;

public class TestPersonValidation {

	
	public static void main(String[] args) {
		Person person = new Person();
		person.setAge(190);
		person.setName(null);
		DataBinder db = new DataBinder(person, person.getClass().getName());
		db.setValidator(new PersonValidator());
		db.validate();
		BindingResult br = db.getBindingResult();
		System.out.println(br);
		List<ObjectError> list = br.getAllErrors();
		for (ObjectError objectError : list) {
			FieldError fe = (FieldError)objectError;
			System.out.println(fe.getField());
			System.out.println(fe.getRejectedValue());
			System.out.println(fe.getCode());
		}
		
	}
	
}

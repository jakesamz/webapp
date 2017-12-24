package com.linjw.spring.conversion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjw.spring.conversion.beans.Person;


@Controller
public class ConversionController {

	
	@RequestMapping("conversionpage")
	public void conversionpage(Person p) {
		
	}
	
	@RequestMapping("conversion")
	public void conversion(Person p) {
		System.out.println(p.getHiredDate().getTime());;
		System.out.println(p);
	}
	
	
}

package com.linjw.business.conversion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjw.business.conversion.beans.Person;


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

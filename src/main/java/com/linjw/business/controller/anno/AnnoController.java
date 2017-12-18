package com.linjw.business.controller.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjw.business.beans.Emp;
import com.linjw.business.controller.anno.bean.Test;

@Controller
public class AnnoController {

	
	@Bean
	@Qualifier("thistest")
	public Test publicInstance() {
		return new Test();
	}
	
	@Autowired
	public Emp emp;
	
	@RequestMapping("/anno")
	public void getAnno() {
		System.out.println(emp);
	}
	
}

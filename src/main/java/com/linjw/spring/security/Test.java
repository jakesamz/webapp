package com.linjw.spring.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class Test {
	
	
	public static void main(String[] args) {
		
		final int i = 1;
		final int j = 3;
		final Student s = new Student(1);
		s.setAge(1);
	}

}

class Student {
	private int age;
	public Student(int age) {
		this.age = age;
	}
	public void setAge(int age) {this.age = age;}
}
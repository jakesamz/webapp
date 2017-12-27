package com.linjw.spring.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class Test {
	
	
	public static void main(String[] args) {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
	}

}

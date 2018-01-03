package com.linjw.business.user.login;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class UserLoginService extends InMemoryUserDetailsManager {
	
	public UserLoginService() {
		UserBuilder users = User.withDefaultPasswordEncoder();
		this.createUser(users.username("user").password("password").roles("USER").build());
		this.createUser(users.username("admin").password("1234").roles("USER","ADMIN").build());
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return super.loadUserByUsername(username);
	}

}

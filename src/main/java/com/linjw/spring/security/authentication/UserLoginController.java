package com.linjw.spring.security.authentication;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLoginController {

	@RequestMapping("/loginpage")
	public String login() {
		return "login";
	}
	
	
}

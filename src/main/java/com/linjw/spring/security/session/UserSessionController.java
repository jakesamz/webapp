package com.linjw.spring.security.session;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 从Session中获取User的Controller
 * @author Administrator
 *
 */
@Controller
public class UserSessionController {

	/**
	 * 用spring-security提供的方法获取（推荐用此种方法）
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getUser() {
		System.out.println(UserSessionService.getUser());
		return null;
	}

	/**
	 * 手动从session中获取User
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/user2", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getUser(HttpSession httpSession) {
		System.out.println(UserSessionService.getUser2(httpSession));
		return null;
	}

}

package com.linjw.spring.security.session;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 此类用两种方法说明在spring-security如何从Session中获得user的登录信息。<br>
 * <br>
 * 
 * 1.用spring-security提供的方法获取（推荐用此种方法）<br>
 * 2.手动从session中获取<br><br>
 * 
 * SecurityContextHolder中存放着user的信息，用Authentication来表示。
 * 另外，SecurityContext的实例对象存放在thread-local中。
 * 详细参考spring-security 文档 
 * 9.2 Components
 * 
 * <pre>
 * Core Component的作用如下：
 * 
 * SecurityContextHolder, to provide access to the SecurityContext.
 * SecurityContext, to hold the Authentication and possibly request-specific security information.
 * Authentication, to represent the principal in a Spring Security-specific manner.
 * GrantedAuthority, to reflect the application-wide permissions granted to a principal.
 * UserDetails, to provide the necessary information to build an Authentication object from your application’s DAOs or other source of security data.
 * UserDetailsService, to create a UserDetails when passed in a String-based username (or certificate ID or the like).
 * </pre>
 * @author linjw
 *
 */
public class UserSessionService {

	/**
	 * 用spring-security提供的方法获取User（推荐用此种方法）
	 * @return
	 */
	public static UserDetails getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails)principal);
		}
		return null;
	}
	
	/**
	 * 手动从session中获取User
	 * @param httpSession
	 * @return
	 */
	public static User getUser2(HttpSession httpSession) {
		Authentication au;
		User userDetail = null;
		SecurityContext ctx = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		if (ctx != null) {
			au = ctx.getAuthentication();
			userDetail = (User) au.getPrincipal();
		}
		return userDetail;
	}
}

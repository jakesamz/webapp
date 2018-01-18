package com.linjw.spring.security.session;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ���������ַ���˵����spring-security��δ�Session�л��user�ĵ�¼��Ϣ��<br>
 * <br>
 * 
 * 1.��spring-security�ṩ�ķ�����ȡ���Ƽ��ô��ַ�����<br>
 * 2.�ֶ���session�л�ȡ<br><br>
 * 
 * SecurityContextHolder�д����user����Ϣ����Authentication����ʾ��
 * ���⣬SecurityContext��ʵ����������thread-local�С�
 * ��ϸ�ο�spring-security �ĵ� 
 * 9.2 Components
 * @author linjw
 *
 */
public class UserSessionService {

	/**
	 * ��spring-security�ṩ�ķ�����ȡUser���Ƽ��ô��ַ�����
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
	 * �ֶ���session�л�ȡUser
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

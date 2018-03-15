package com.linjw.business.user.findpwd;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;

public class ResetPwd {
	
	
	public void doReset() {
		/*
		- generate code, send message, startCodeTimer;
		- match code.
		- do reset.
		*/
		String sql = "update user set pwd = 'xxx' where userid = xxx";
	}
	
	public static void send() {
		/*AuthenticationStrategy stragety = new AuthenticationStrategyByPhone();
		stragety.send();*/
		ClassPathXmlApplicationContext classPathXmlApplicationContext = 
				new ClassPathXmlApplicationContext("classpath:xvxcv.xml"); 
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo("3178017167@qq.com");
		/*AuthenticationStrategy<SimpleMailMessage> authenticationStrategyByMail = new AuthenticationStrategyByMail();
		authenticationStrategyByMail.send(sm);*/
		
		AbstractAuthenticationStrategy strategy = classPathXmlApplicationContext.getBean(AuthenticationStrategyByMail.class);
		strategy.sendAuthCodeMessage();
		//strategy.removeCode(null);
	}
	
	public static void main(String[] args) {
		send();
	}
	
	private static void startCodeTimer() {
		// TODO Auto-generated method stub
		
	}

	public static void domatch() {
		
	}
	

}

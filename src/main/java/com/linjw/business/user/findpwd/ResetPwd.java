package com.linjw.business.user.findpwd;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;

public class ResetPwd {
	
	
	public void doReset() {
		/*
		1.store code and send time
		2.send message;
		3.match code.
		4.do reset.
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
		
		AuthenticationStrategy<SimpleMailMessage> strategy = classPathXmlApplicationContext.getBean(AuthenticationStrategyByMail.class);
		strategy.send(sm);
	}
	
	public static void main(String[] args) {
		send();
	}
	
	public static void domatch() {
		
	}
	

}

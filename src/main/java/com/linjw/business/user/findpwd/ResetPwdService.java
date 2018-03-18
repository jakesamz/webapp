package com.linjw.business.user.findpwd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ResetPwdService {
	
	@Autowired
    private ApplicationContext applicationContext;

	public void send() {
		//Sender sender = new MailSender();
		Sender sender = applicationContext.getBean(MailSender.class);
		Sender sender1 = applicationContext.getBean(MailSender.class);
		System.out.println(sender);
		System.out.println(sender1);
		AbstractAuthenticationStrategy strategy = new AuthenticationStrategyByMail(sender);
		strategy.sendAuthCodeMessage();
	}
	

}

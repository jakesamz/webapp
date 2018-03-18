package com.linjw.business.user.findpwd;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class ResetPwdService {
	
	public void send() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Sender sender = new MailSender(simpleMailMessage);
		AbstractAuthenticationStrategy strategy = new AuthenticationStrategyByMail(sender);
		strategy.sendAuthCodeMessage();
	}
	

}

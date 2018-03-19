package com.linjw.business.user.findpwd;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjw.business.utils.Result;

@Service
public class ResetPwdService {
	
	
	@Transactional
	public Result send() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Sender sender = new MailSender(simpleMailMessage);
		AbstractAuthenticationStrategy strategy = new AuthenticationStrategyByMail(sender);
		return strategy.sendAuthCodeMessage();
	}
	

}

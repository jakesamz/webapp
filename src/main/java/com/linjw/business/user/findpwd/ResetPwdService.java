package com.linjw.business.user.findpwd;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linjw.business.utils.Result;
import com.linjw.context.SpringContext;

@Service
public class ResetPwdService {

	private SystemParams systemParams = SpringContext.getContext().getBean(SystemParams.class);

	private ThreadLocal<SimpleMailMessage> smmTl = new ThreadLocal<SimpleMailMessage>() {
		@Override
		protected SimpleMailMessage initialValue() {
			SimpleMailMessage smm = new SimpleMailMessage();
			smm.setFrom(systemParams.getValue("app.mail.from"));
			smm.setSentDate(new Date());
			return smm;
		}
	};

	@Transactional
	public Result send() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Sender sender = new MailSender();
		AbstractAuthenticationStrategy strategy = new AuthenticationStrategyByMail(sender);
		return strategy.sendAuthCodeMessage();
	}

}

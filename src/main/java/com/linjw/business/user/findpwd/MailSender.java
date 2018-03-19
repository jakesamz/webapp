package com.linjw.business.user.findpwd;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.Assert;

import com.linjw.business.utils.Result;
import com.linjw.context.SpringContext;

public class MailSender extends AbstractSender {

	private JavaMailSenderImpl mailSender = SpringContext.getContext().getBean(JavaMailSenderImpl.class);
	
	private SystemParams systemParams = SpringContext.getContext().getBean(SystemParams.class);
	
	private SimpleMailMessage mailMessage;
	
	public MailSender(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	public Result send() {
		Assert.notNull(mailMessage, "mailMessage is required");
		mailMessage.setFrom(systemParams.getValue("app.mail.from"));
		//t.setTo(to);
		//t.setSubject(systemParams.getValue("app.mail.resetPwd.subject"));
		mailMessage.setSentDate(new Date());
		//t.setText(content);
		mailSender.send(mailMessage);
		return new Result(true, "” œ‰∑¢ÀÕ≥…π¶");
	}

}

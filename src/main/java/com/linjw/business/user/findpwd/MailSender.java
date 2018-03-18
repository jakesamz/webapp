package com.linjw.business.user.findpwd;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MailSender implements Sender, Command {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private SystemParams systemParams;
	
	
	private SimpleMailMessage t = new SimpleMailMessage();
	

	public boolean send() {
		try {
			t.setFrom(systemParams.getValue("app.mail.from"));
			//t.setTo(to);
			//t.setSubject(systemParams.getValue("app.mail.resetPwd.subject"));
			t.setSentDate(new Date());
			//t.setText(content);
			mailSender.send(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public Object execute() {
		// TODO Auto-generated method stub
		return this;
	}

}

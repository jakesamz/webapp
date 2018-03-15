package com.linjw.business.user.findpwd;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailSender implements Sender {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private SystemParams systemParams;
	
	
	private String content;
	
	private String[] to;
	

	public boolean send() {
		try {
			SimpleMailMessage t = new SimpleMailMessage();
			t.setFrom(systemParams.getValue("app.mail.from"));
			t.setTo(to);
			t.setSubject(systemParams.getValue("app.mail.resetPwd.subject"));
			t.setSentDate(new Date());
			t.setText(content);
			System.out.println(systemParams.getValue("app.mail.from"));
			mailSender.send(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

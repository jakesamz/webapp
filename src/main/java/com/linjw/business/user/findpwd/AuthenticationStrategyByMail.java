package com.linjw.business.user.findpwd;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class AuthenticationStrategyByMail extends AbstractAuthenticationStrategy<SimpleMailMessage> {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private SystemParams systemParams;

	@Override
	public int getCodeBits() {
		return 6;
	}

	@Override
	protected void doSend(SimpleMailMessage t) {
		try {
			// t.setFrom(systemParams.getObject().getProperty("app.mail.from"));
			t.setFrom(systemParams.getValue("app.mail.from"));
			t.setSubject(systemParams.getValue("app.mail.resetPwd.subject"));
			t.setSentDate(new Date());
			t.setText(systemParams.getValue("app.resetPwd.mail.content", this.getCode()));
			System.out.println(systemParams.getValue("app.mail.from"));
			mailSender.send(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getCodeAttrName() {
		return "checkCode";
	}

}

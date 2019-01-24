package com.linjw.business.user.findpwd.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindPwdByEmailService implements FindPwdService {
	
	private static Map<String, String> mailCryptMapping = 
			new HashMap<String, String>();

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Transactional
	public void send() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("17876763070@163.com");
		simpleMailMessage.setTo("757255712@qq.com");
		String sid = Md5Crypt.md5Crypt("757255712@qq.com".getBytes(), RandomStringUtils.random(8, true, true), "");
		simpleMailMessage.setText("http://localhost:8080/WebApp/resetPwd?sid=" + sid);
		mailCryptMapping.put(sid, "757255712@qq.com");
		mailSender.send(simpleMailMessage);
		System.out.println("sent out");
	}
	
	public void reset(String sid) {
		String mail  = mailCryptMapping.get(sid);
	}

}

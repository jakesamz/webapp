package com.linjw.business.user.findpwd.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjw.business.user.findpwd.service.FindPwdService;

@Controller
public class FindPwdController {
	
	@Autowired
	private FindPwdService findPwdService;
	
	@RequestMapping("sendPwdEmail")
	public void sendPwdEmail(String email) {
		findPwdService.send();
	}
	
	public void resetPwd() {
		
	}
	
}

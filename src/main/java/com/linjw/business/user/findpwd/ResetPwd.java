package com.linjw.business.user.findpwd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjw.business.utils.Result;
import com.linjw.business.utils.WebUtils;

@Controller
public class ResetPwd {

	@Autowired
	ResetPwdService service;

	@RequestMapping("/resetPwd")
	public Result testSend(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println(req.getRemoteAddr());;
		
		String ip = WebUtils.getRemoteRealIPAddr(req);
		System.out.println(ip);
		
		return null;
	}

}

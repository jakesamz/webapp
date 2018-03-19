package com.linjw.business.user.findpwd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linjw.business.utils.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:xvxcv.xml")
public class ResetPwd {

	@Autowired
	ResetPwdService service;

	@Test
	public Result testSend() {
		try {
			return service.send();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "系统异常，请联系管理员");
		}
	}

}

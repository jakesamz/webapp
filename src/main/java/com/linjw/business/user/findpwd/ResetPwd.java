package com.linjw.business.user.findpwd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:xvxcv.xml")
public class ResetPwd {
	
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    ResetPwdService service;
	    

	@Test
	public void testSend() {
		service.send();
	}
	

}

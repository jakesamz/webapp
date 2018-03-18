package com.linjw.business.user.findpwd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.linjw.business.utils.Result;

@Component
@Scope("request")
public class PhoneSender extends AbstractSender {

	@Autowired
	private SystemParams systemParams;
	
	
	private PhoneMessage phoneMessage;
	

	public Result send() {
		try {
			return new Result();
		} catch (Exception e) {
			e.printStackTrace();
			return new Result();
		}
	}

}

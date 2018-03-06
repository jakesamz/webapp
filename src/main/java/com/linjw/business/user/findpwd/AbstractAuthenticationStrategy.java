package com.linjw.business.user.findpwd;

import java.util.Random;

public abstract class AbstractAuthenticationStrategy implements AuthenticationStrategy {

	public void send() {
		String code = generate();
		store(code);
		doSend(code);
	}

	public String generate() {
		String value = "";
		for (int i = 0; i < this.getCodeBits(); i++) {
			value += new Random().nextInt(10);
		}
		return value;
	}
	
	public void store(String code) {
		
	}
	
	public abstract void doSend(String message) ;
	
	public abstract int getCodeBits();

}

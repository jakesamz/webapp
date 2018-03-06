package com.linjw.business.user.findpwd;

public class AuthenticationStrategyByPhone extends AbstractAuthenticationStrategy {

	@Override
	public void doSend(String message) {
		
		System.out.println(message);
		
	}

	@Override
	public int getCodeBits() {
		return 6;
	}
	
}

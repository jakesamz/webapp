package com.linjw.business.user.findpwd;

public class AuthenticationStrategyByPhone extends AbstractAuthenticationStrategy<PhoneMessage> {

	@Override
	public int getCodeBits() {
		return 6;
	}

	@Override
	public void doSend(PhoneMessage t) {
		
	}

	@Override
	public String buildMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

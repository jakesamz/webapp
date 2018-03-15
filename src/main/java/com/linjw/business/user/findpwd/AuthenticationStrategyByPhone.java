package com.linjw.business.user.findpwd;

public class AuthenticationStrategyByPhone extends AbstractAuthenticationStrategy {

	public AuthenticationStrategyByPhone(Sender sender) {
		super(sender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeAttrName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean sendAuthCodeMessage() {
		// TODO Auto-generated method stub
		return false;
	}


}

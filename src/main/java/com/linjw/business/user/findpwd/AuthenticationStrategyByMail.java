package com.linjw.business.user.findpwd;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class AuthenticationStrategyByMail extends AbstractAuthenticationStrategy {

	public AuthenticationStrategyByMail(Sender sender) {
		super(sender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeAttrName() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

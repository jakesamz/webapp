package com.linjw.business.user.findpwd;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.linjw.business.utils.Result;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AuthenticationStrategyByMail extends AbstractAuthenticationStrategy {

	public AuthenticationStrategyByMail(Sender sender) {
		super(sender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeAttrName() {
		// TODO Auto-generated method stub
		return "code";
	}

	@Override
	public Result canSend() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

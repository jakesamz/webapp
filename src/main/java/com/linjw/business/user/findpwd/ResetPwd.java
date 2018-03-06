package com.linjw.business.user.findpwd;

public class ResetPwd {
	
	
	public void doReset() {
		/*
		1.store code and send time
		2.send message;
		3.match code.
		4.do reset.
		*/
		String sql = "update user set pwd = 'xxx' where userid = xxx";
	}
	
	public static void send() {
		AuthenticationStrategy stragety = new AuthenticationStrategyByPhone();
		stragety.send();
	}
	
	public static void main(String[] args) {
		send();
	}
	
	public static void domatch() {
		
	}
	

}

package com.linjw.business.user.findpwd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.linjw.business.utils.Result;

public class AuthenticationStrategyByPhone extends AbstractAuthenticationStrategy {
	
	@Autowired
	private SystemParams systemParams;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AuthenticationStrategyByPhone(Sender sender) {
		super(sender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeAttrName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result canSend() {
		String sql = "select sysdate - lastSendTime from user where phone = xxx";
		Integer actualInterval = jdbcTemplate.queryForObject(sql, Integer.class);
		boolean lessThanInterval = actualInterval < SEND_INTERVAL;
		if(lessThanInterval) {
			return new Result(false, systemParams.getValue("app.phone.send.lessThanInterval"));
		}
		return new Result(true, "");
	}
}

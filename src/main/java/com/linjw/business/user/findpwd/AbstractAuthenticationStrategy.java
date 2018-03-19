package com.linjw.business.user.findpwd;

import org.springframework.util.Assert;
import com.linjw.business.noGen.NoGenerator;
import com.linjw.business.noGen.random.RandomNoGenerator;
import com.linjw.business.utils.Result;

public abstract class AbstractAuthenticationStrategy implements AuthenticationCodeSendingStrategy {

	private NoGenerator noGenerator = new RandomNoGenerator();
	
	private Sender sender;
	
	private String code;
	
	public final static int SEND_INTERVAL = 120;
	
	public AbstractAuthenticationStrategy(Sender sender) {
		this.sender = sender;
	}
	
	public Result sendAuthCodeMessage() {
		Assert.notNull(noGenerator, "A Code Generator is required");
		Assert.notNull(sender, "A sender is required");
		Result canSend = canSend();
		if(!canSend.getFlag()) {
			return canSend;
		}
		setCode(noGenerator.generate());
		saveSenderCache();
		Result sent = sender.send();
		return sent;
	}
	
	public abstract Result canSend();

	private void saveSenderCache() {
		//save lastSendTime and ip.
		//
	}

	protected void setNoGenerator(NoGenerator noGenerator) {
		this.noGenerator = noGenerator;
	}
	
	//public abstract int getCodeBits();

	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}
	
	public abstract String getCodeAttrName();

/*
	public CustomCodeTimer getCustomTimer() {
		return codeTimer;
	}


	public void setCustomTimer(CustomCodeTimer customTimer) {
		this.codeTimer = customTimer;
	}


	public class DefaultCodeTimer implements CustomCodeTimer {
		public void start(){
			int effectiveSeconds = 5 * 60 * 1000;
			final Timer timer = new Timer();
			final String codeAttrName = AbstractAuthenticationStrategy.this.getCodeAttrName();
			timer.schedule(new TimerTask() {
				public void run() {
					HttpServletRequest request = 
							((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
					request.getSession().removeAttribute(codeAttrName);
					timer.cancel();
				}
			}, effectiveSeconds);
		}
	}*/
}

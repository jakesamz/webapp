package com.linjw.business.user.findpwd;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.linjw.business.noGen.NoGenerator;
import com.linjw.business.utils.Result;

public abstract class AbstractAuthenticationStrategy implements AuthenticationCodeSendingStrategy {

	private NoGenerator noGenerator = new DefaultCodeGenerator();
	
	private CustomCodeTimer codeTimer = new DefaultCodeTimer();
	
	private Sender sender;
	
	private String code;
	
	public final static int SEND_INTERVAL = 120;
	
	public AbstractAuthenticationStrategy(Sender sender) {
		this.sender = sender;
	}
	
	public Result sendAuthCodeMessage() {
		try {
			Result canSend = canSend();
			if(canSend.getFlag()) {
				setCode(noGenerator.generate());
				saveSenderCache();
				return sender.send();	
				//codeTimer.start();
			}else {
				return canSend;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(false, "ÏµÍ³³ö´í");
		}
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
	}

	public class DefaultCodeGenerator implements NoGenerator {

		public String generate() {
			String value = "";
			for (int i = 0; i < this.bits(); i++) {
				value += new Random().nextInt(10);
			}
			return value;
		}

		public int bits() {
			// TODO Auto-generated method stub
			return 6;
		}
		
	}

}

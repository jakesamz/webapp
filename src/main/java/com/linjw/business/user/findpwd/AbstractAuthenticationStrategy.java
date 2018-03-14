package com.linjw.business.user.findpwd;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.linjw.business.noGen.NoGenerator;

public abstract class AbstractAuthenticationStrategy<T> implements AuthenticationStrategy<T> {

	private NoGenerator noGenerator = new DefaultCodeGenerator();
	
	private CustomCodeTimer codeTimer = new DefaultCodeTimer();
	
	private String code;
	
	public boolean send(T t) {
		try {
			setCode(noGenerator.generate());
			doSend(t);	
			/*setCodeSession();
			codeTimer.start();*/
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

    public boolean sendAndContdown(T t) {
        send(t);
        setCodeSession();
        codeTimer.start();
    }


	private void setCodeSession() {
		HttpServletRequest request = 
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute(this.getCodeAttrName(), this.getCode());
	}
	
	protected void setNoGenerator(NoGenerator noGenerator) {
		this.noGenerator = noGenerator;
	}
	
	protected abstract void doSend(T t) ;
	
	//protected abstract String buildMessage() throws Exception;
	
	public abstract int getCodeBits();

	public String getCode() {
		return code;
	}

	private void setCode(String code) {
		this.code = code;
	}
	
	public abstract String getCodeAttrName();


	//protected abstract void setCodeAttrName(String codeAttrName);
	
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

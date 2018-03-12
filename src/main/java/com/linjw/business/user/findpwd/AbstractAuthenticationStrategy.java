package com.linjw.business.user.findpwd;

import java.io.IOException;
import java.util.Random;

import org.springframework.util.Assert;

import com.linjw.business.noGen.NoGenerator;

public abstract class AbstractAuthenticationStrategy<T> implements AuthenticationStrategy<T> {

	private NoGenerator noGenerator = new DefaultCodeGenerator();
	
	private String code;
	
	public boolean send(T t) {
		Assert.notNull(noGenerator, "A NoGenerator is required.");
		try {
			this.setCode(noGenerator.generate());
			store();
			doSend(t);	
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected void setNoGenerator(NoGenerator noGenerator) {
		this.noGenerator = noGenerator;
	}
	
	private void store() {
		
	}
	
	protected abstract void doSend(T t) ;
	
	protected abstract String buildMessage() throws Exception;
	
	protected abstract int getCodeBits();

	protected String getCode() {
		return code;
	}

	protected void setCode(String code) {
		this.code = code;
	}
	
	private class DefaultCodeGenerator implements NoGenerator {

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

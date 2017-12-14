package com.linjw.business.beans;

import org.springframework.beans.factory.annotation.Required;

public class ResultMessage {

	private String code;
	
	private String message;
	
	private boolean success;
	
	private String interalError;

	public String getCode() {
		return code;
	}

	@Required
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	@Required
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	@Required
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getInteralError() {
		return interalError;
	}

	public void setInteralError(String interalError) {
		this.interalError = interalError;
	}
	
	
	
}

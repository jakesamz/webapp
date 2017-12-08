package com.jake;

public class ResultMessage {

	private String code;
	
	private String message;
	
	private boolean success;
	
	private String interalError;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

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

package com.linjw.business.validation.beans;

public class ValidationBean {
	
	private Boolean isValid;
	private Boolean isNotValid;
	private String message;
	private String fieldValue;
	
	public ValidationBean() {}
	
	public ValidationBean(Boolean isNotValid, String message) {
		super();
		this.isNotValid = isNotValid;
		this.message = message;
	}
	
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public Boolean getIsNotValid() {
		return isNotValid;
	}

	public void setIsNotValid(Boolean isNotValid) {
		this.isNotValid = isNotValid;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	

}

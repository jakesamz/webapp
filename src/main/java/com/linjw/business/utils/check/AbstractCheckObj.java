package com.linjw.business.utils.check;

import com.linjw.business.utils.Result;

public abstract class AbstractCheckObj<T> implements ICheckObj<T> {
	
	public static String EXCEPTION_MSG = "system broke down";
	
	public AbstractCheckObj() {}
	
	public Result check(T obj) {
		boolean valid;
		try {
			valid = doCheck(obj);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(false, getExceptionMsg());
		}
		
		if(valid) {
			return new Result(true, getTrueMsg());
		}else {
			return new Result(false, getFalseMsg());
		}
	}

	public abstract boolean doCheck(T obj);

	protected String getTrueMsg() {
		return null;
	}
	
	protected String getFalseMsg() {
		return null;
	}
	
	protected String getExceptionMsg() {
		return EXCEPTION_MSG;
	}
	
}

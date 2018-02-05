package com.linjw.business.utils.check;

import java.util.Collection;

import com.linjw.business.utils.Result;

public abstract class AbstractCheckCollection<T> implements ICheckCollection<T> {
	
	public Result check(Collection<T> collection) {
		return check(collection, null, null);
	}

	public Result check(Collection<T> collection, String trueMsg, String falseMsg) {
		if(collection == null) {
			throw new IllegalArgumentException();
		}
		boolean valid = doCheck(collection);
		
		if(valid) {
			return new Result(true, trueMsg);
		}else {
			return new Result(false, falseMsg);
		}
	}

	public abstract boolean doCheck(Collection<T> collection);
	
	public abstract void doAfterCheckSuccuss(Collection<T> collection);
	
	public abstract void doAfterCheckFailed(Collection<T> collection);
	
}

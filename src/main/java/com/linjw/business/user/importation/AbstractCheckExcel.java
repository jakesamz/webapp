package com.linjw.business.user.importation;

import java.util.Collection;

import com.linjw.business.utils.excel.ICheckExcel;

public abstract class AbstractCheckExcel<T> implements ICheckExcel<T> {

	public void doImport(Collection<T> collent) {
		if(collent == null) {
			throw new IllegalArgumentException();
		}
		boolean valid = check(collent);
		
		if(valid) {
			this.doAfterCheckSuccuss(collent);
		}else {
			this.doAfterCheckFailed(collent);
		}
	}

	protected abstract boolean check(Collection<T> collent);
	
	protected abstract void doAfterCheckSuccuss(Collection<T> collent);
	
	protected abstract void doAfterCheckFailed(Collection<T> collent);
	
}

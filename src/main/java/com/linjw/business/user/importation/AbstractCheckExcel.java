package com.linjw.business.user.importation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.linjw.business.utils.excel.ICheckExcel;
import com.linjw.business.utils.excel.Student;

public abstract class AbstractCheckExcel implements ICheckExcel<Student> {

	public Map<String, String> doImport(Collection<Student> collent) {
		if(collent == null) {
			throw new IllegalArgumentException();
		}
		boolean valid = check(collent);
		
		if(valid) {
			return new HashMap<String, String>();
		}else {
			return getErrorMessage();
		}
	}
	
	protected abstract boolean check(Collection<Student> collent);
	
	protected abstract Map<String, String> getErrorMessage();
	
}

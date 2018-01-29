package com.linjw.business.user.importation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.linjw.business.utils.excel.ICheckExcel;
import com.linjw.business.utils.excel.Student;

public class ImportServiceImpl implements ImportService<Student> {

	public Map<String, String> doImport(Collection<Student> collent, ICheckExcel<Student> checkRules) {
		if(checkRules == null) {
			throw new IllegalArgumentException();
		}
		boolean valid = checkRules.check(collent);
		
		if(valid) {
			return new HashMap<String, String>();
		}else {
			return checkRules.getErrorMessage();
		}
	}
	
	public void doImportWithChecking(Collection<Student> collent) {
		// TODO Auto-generated method stub
		
	}

}

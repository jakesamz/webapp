package com.linjw.business.utils.excel;

import java.util.Collection;
import java.util.Map;

public abstract class AbstractCheckStudentExcel implements ICheckExcel<Student> {

	private Map<String,String> map = null;
	
	public Map<String, String> getErrorMessage() {
		return map;
	}

}

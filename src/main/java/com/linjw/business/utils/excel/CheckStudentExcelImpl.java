package com.linjw.business.utils.excel;

import java.util.Collection;
import java.util.Map;

import com.linjw.business.user.importation.AbstractCheckExcel;

public class CheckStudentExcelImpl extends AbstractCheckExcel {

	public boolean check(Collection<Student> collection) {
		return false;
	}

	public Map<String, String> getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}

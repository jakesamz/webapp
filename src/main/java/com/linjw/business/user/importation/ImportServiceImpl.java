package com.linjw.business.user.importation;

import java.util.Collection;

import com.linjw.business.utils.excel.ICheckExcel;
import com.linjw.business.utils.excel.Student;

public class ImportServiceImpl implements ImportService<Student> {

	public void doImport(Collection<Student> collent, ICheckExcel<Student> checkRules) {
		checkRules.check(collent);
	}

}

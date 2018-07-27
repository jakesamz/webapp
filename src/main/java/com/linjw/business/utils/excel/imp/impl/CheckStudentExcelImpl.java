package com.linjw.business.utils.excel.imp.impl;

import java.util.Collection;

import com.linjw.business.user.importation.AbstractCheckExcel;

public class CheckStudentExcelImpl extends AbstractCheckExcel<Student> {

	@Override
	protected boolean check(Collection<Student> collent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void doAfterCheckSuccuss(Collection<Student> collent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterCheckFailed(Collection<Student> collent) {
		// TODO Auto-generated method stub
		
	}
	
}
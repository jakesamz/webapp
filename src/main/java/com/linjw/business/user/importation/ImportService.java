package com.linjw.business.user.importation;

import java.util.Collection;

import com.linjw.business.utils.excel.ICheckExcel;


public interface ImportService<T> {
	
	
	public void doImport(Collection<T> collent, ICheckExcel<T> checkRules);

}

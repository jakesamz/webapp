package com.linjw.business.user.importation;

import java.util.Collection;
import java.util.Map;

import com.linjw.business.utils.excel.imp.ICheckExcel;


public interface ImportService<T> {
	
	
	public Map<String, String> doImport(Collection<T> collent, ICheckExcel<T> checkRules);

	
	public void doImportWithChecking(Collection<T> collent);
}

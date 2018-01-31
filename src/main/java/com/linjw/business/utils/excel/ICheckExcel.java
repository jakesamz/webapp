package com.linjw.business.utils.excel;

import java.util.Collection;
import java.util.Map;

public interface ICheckExcel<T> {
	
	Map<String, String> doImport(Collection<Student> collent);

}

package com.linjw.business.utils.excel;

import java.util.Collection;
import java.util.Map;

public interface ICheckExcel<T> {
	
	boolean check(Collection<T> collection);
	
	Map<String, String> getErrorMessage();

}

package com.linjw.business.utils.excel.imp;

import java.util.Collection;

public interface ICheckExcel<T> {
	
	void doImport(Collection<T> collent);

}

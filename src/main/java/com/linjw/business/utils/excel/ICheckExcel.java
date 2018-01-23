package com.linjw.business.utils.excel;

import java.util.Collection;

public interface ICheckExcel<T> {
	
	void check(Collection<T> collection);

}

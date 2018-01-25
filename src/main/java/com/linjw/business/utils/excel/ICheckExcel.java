package com.linjw.business.utils.excel;

import java.util.Collection;

import org.springframework.validation.BindingResult;

public interface ICheckExcel<T> {
	
	boolean check(Collection<T> collection);
	
	BindingResult getResult();

}

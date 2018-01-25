package com.linjw.business.user.importation;

import java.util.Collection;

import org.springframework.validation.BindingResult;

import com.linjw.business.utils.excel.ICheckExcel;


public interface ImportService<T> {
	
	
	public BindingResult saveExcel(Collection<T> collent, ICheckExcel<T> checkRules);

}

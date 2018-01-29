package com.linjw.business.user.importation;

import java.util.Collection;

import org.springframework.validation.BindingResult;

import com.linjw.business.utils.excel.ICheckExcel;

public abstract class BaseService<T> implements ImportService<T> {

	public BindingResult saveExcel(Collection<T> collent, ICheckExcel<T> excelChecking) {
		if(excelChecking.check(collent)) {
			return this.doSave(collent);
		}else {
			return excelChecking.getResult();
		}
	}
	
	public abstract BindingResult doSave(Collection<T> collent);

}

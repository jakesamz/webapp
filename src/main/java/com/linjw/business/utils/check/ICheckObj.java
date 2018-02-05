package com.linjw.business.utils.check;

import com.linjw.business.utils.Result;

public interface ICheckObj<T> {
	
	Result check(T obj);
	
}

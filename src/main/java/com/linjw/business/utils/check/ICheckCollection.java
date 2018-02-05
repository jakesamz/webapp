package com.linjw.business.utils.check;

import java.util.Collection;

import com.linjw.business.utils.Result;

public interface ICheckCollection<T> {
	
	Result check(Collection<T> collection);
	
	Result check(Collection<T> collection, String trueMsg, String falseMsg);
	
}

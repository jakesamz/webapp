package com.linjw.business.user.findpwd;

import com.linjw.business.utils.Result;

public interface AuthenticationStrategy<T> {
	
	boolean send(T t);

}

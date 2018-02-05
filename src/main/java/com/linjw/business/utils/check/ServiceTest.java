package com.linjw.business.utils.check;

import com.linjw.business.utils.Result;

public class ServiceTest {
	
	ICheckObj<String> checkUsernameTaken = new CheckUserNameTaken();
	
	public static void main(String[] args) {
		
		Result r = new ServiceTest().checkUsernameTaken.check(null);
		System.out.println(r);
	}

}

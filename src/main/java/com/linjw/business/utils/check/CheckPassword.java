package com.linjw.business.utils.check;

public class CheckPassword extends AbstractCheckObj<String> {

	public static String TRUE_MSG = "SSS";
	
	public static String FALSE_MSG = "XXX";
	
	@Override
	public boolean doCheck(String obj) {
		return obj.equals("1");
	}
	
	protected String getTrueMsg() {
		return TRUE_MSG;
	}
	
	protected String getFalseMsg() {
		return FALSE_MSG;
	}

}

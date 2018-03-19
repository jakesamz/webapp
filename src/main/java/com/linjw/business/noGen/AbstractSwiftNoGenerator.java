/*
 *File Name: YOUR FILE NAME
 *Copyright pccw.com. 2003-2011, All rights reserved.
 *Created by: YOUR  NAME
 *Created Date:  2013-04-22 10:14:34
 */
package com.linjw.business.noGen;

public abstract class AbstractSwiftNoGenerator implements NoGenerator {
	

	public static int START_VALUE = 1;
	public static int INCREMENT = 1;
	public static int MAX_VALUE = 9999;
	private int bits;
	private String userId;
	public AbstractSwiftNoGenerator(int bits, String userId) {
		this.setBits(bits);
		this.setUserId(userId);
	}
	public int getBits() {
		return bits;
	}
	public void setBits(int bits) {
		this.bits = bits;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}

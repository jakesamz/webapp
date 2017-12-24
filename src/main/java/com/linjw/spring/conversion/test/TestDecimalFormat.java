package com.linjw.spring.conversion.test;

import java.text.DecimalFormat;

public class TestDecimalFormat {

	
	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("0----k");
		String s = df.format(5);
		System.out.println(s);
	}
	
	
	
}

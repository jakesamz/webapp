package com.linjw.web.attacks.xss;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.util.JavaScriptUtils;

public class FilterScripting {

	public static void main(String[] args) {
		
		String afterEscape = JavaScriptUtils.javaScriptEscape("<script>alert('handsome boy')</script>");
		
		System.out.println(afterEscape);
		
		String afterEscape2 =  StringEscapeUtils.escapeHtml4("<script>alert('handsome boy')</script>");
		
		System.out.println(afterEscape2);
	}
	
	
}

package com.linjw.business.test;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linjw.business.noGen.SwiftNoGeneratorImpl;

public class Test {
	
	public static void main(String[] args) throws BeansException, Exception {
		
		ClassPathXmlApplicationContext classPathXmlApplicationContext = 
				new ClassPathXmlApplicationContext("classpath:xvxcv.xml"); 
		
		Object o = classPathXmlApplicationContext.getBean("swiftNoGeneratorImpl");
		SwiftNoGeneratorImpl s = (SwiftNoGeneratorImpl)o;
		s.afterPropertiesSet();
	}

}

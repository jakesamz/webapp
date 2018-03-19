/*
 *File Name: YOUR FILE NAME
 *Copyright pccw.com. 2003-2011, All rights reserved.
 *Created by: YOUR  NAME
 *Created Date:  2013-04-22 10:14:34
 */
package com.linjw.business.noGen;

import org.springframework.util.Assert;

public abstract class AbstractSystemAutoNoGenerator  implements NoGenerator {
	
	private AbstractSwiftNoGenerator snGenerator;
	

	public NoGenerator getSnGenerator() {
		return snGenerator;
	}

	public void setSnGenerator(AbstractSwiftNoGenerator snGenerator) {
		this.snGenerator = snGenerator;
	}

	public static String DEFAULT_SEPARATOR = "-";
	
	public String generate() {
		if(snGenerator == null) {
			Assert.isNull(snGenerator, "A swiftno generator is required.");
		}
		return this.getPrefix() + this.getSeparator() + this.getDate() + this.getSeparator() + snGenerator.generate();
	}
	
	protected String getSeparator() {
		return DEFAULT_SEPARATOR;
	}
	
	public abstract String getPrefix();
	
	public abstract String getDate();
	
}

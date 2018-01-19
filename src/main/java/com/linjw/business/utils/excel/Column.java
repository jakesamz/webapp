package com.linjw.business.utils.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation maps the excel header columns to Class Fields
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	
	String actualColName();
	
}

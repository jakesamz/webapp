package com.linjw.business.utils.excel;

/**
 * Thrown if the submitted file is not an excel file.
 * @author Administrator
 *
 */
public class NotAnExcelFileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2846107719770746608L;

	
	public NotAnExcelFileException(String message) {
		super(message);
	}
	
	
}

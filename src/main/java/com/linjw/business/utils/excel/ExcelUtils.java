package com.linjw.business.utils.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

public class ExcelUtils {

	/**
	 * suffix of excel 2003
	 */
	public static final String OFFICE_EXCEL_V2003_SUFFIX = "xls";
	/**
	 * suffix of excel 2007
	 */
	public static final String OFFICE_EXCEL_V2007_SUFFIX = "xlsx";
	/**
	 * suffix of excel 2010
	 */
	public static final String OFFICE_EXCEL_V2010_SUFFIX = "xlsx";


	/**
	 * Check which version of the submitted excel file is.
	 * If file is valid, then process... 
	 * 
	 * @param path
	 *            the Excel file
	 * @return a list that contains Student2s from Excel.
	 * @throws IllegalArgumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws TemplateFormatException
	 * @throws NotAnExcelFileException 
	 */
	public static <T> List<T> readExcel(String path, Class<T> clazz)
			throws FileNotFoundException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, TemplateFormatException, NotAnExcelFileException {

		String suffiex = AbstractExcelReader.getSuffiex(path);
		ExcelReader er = null;
		if (OFFICE_EXCEL_V2003_SUFFIX.equals(suffiex)) {
			er = new Excel2003Reader();
		} else if (OFFICE_EXCEL_V2007_SUFFIX.equals(suffiex)) {
			er = new Excel2007Reader();
		} else if (OFFICE_EXCEL_V2010_SUFFIX.equals(suffiex)) {
			er = new Excel2007Reader();
		} else {
			throw new NotAnExcelFileException("file is empty or not an excel");
		}
		return (List<T>) er.read(path, clazz);
	}
	

}

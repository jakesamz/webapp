package com.linjw.business.utils.excel;

import java.beans.IntrospectionException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	 * @throws IntrospectionException 
	 */
	public static <T> List<T> readExcel(String path, Class<T> clazz)
			throws FileNotFoundException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException, TemplateFormatException, NotAnExcelFileException, IllegalArgumentException, IntrospectionException {

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
	
	@SuppressWarnings("serial")
	public static void export(List list, String filePath, String sheetName) throws Exception {
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		workbook.createCellStyle();
		XSSFSheet sheet = workbook.createSheet(sheetName);
		Map<String, String> headerMap = new HashMap<String, String>() {{
			put("id","xxx");
		}};
		for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {
			XSSFRow row = sheet.createRow(rowIndex);
			for (int colIndex = 0; colIndex < headerMap.size(); colIndex++) {
				Object obj = list.get(colIndex);
				XSSFCell cell = row.createCell(colIndex);
			}
		}
		
	}

}

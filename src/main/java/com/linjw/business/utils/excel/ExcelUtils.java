package com.linjw.business.utils.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;

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

	public static final String EMPTY = "";
	public static final String DOT = ".";
	public static final String LIB_PATH = "lib";
	public static final String NOT_EXCEL_FILE = " is Not a Excel file!";
	public static final String PROCESSING = "Processing...";

	public static void main(String[] args) throws IOException {
		String filePath = ExcelUtils.class.getResource("").getPath() + "student-data.xlsx";
		List<?> list = null;
		try {
			list = readExcel(filePath, Student.class);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotAnExcelFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}

	/**
	 * Check which version of The Excel file is. Throw exception if Excel file path
	 * is illegal.
	 * 
	 * @param path
	 *            the Excel file
	 * @return a list that contains Student2s from Excel.
	 * @throws IllegalArgumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws TemplateFormatException
	 * @throws NotAnExcelFileException 
	 */
	public static List<Object> readExcel(String path, Class<?> clazz)
			throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
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
			throw new NotAnExcelFileException();
		}
		return er.read(path, clazz);
	}

}

package com.linjw.business.utils.excel;

import java.beans.IntrospectionException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.linjw.business.utils.excel.export.Column;
import com.linjw.business.utils.excel.export.ExcelExportConfig;
import com.linjw.business.utils.excel.imp.AbstractExcelReader;
import com.linjw.business.utils.excel.imp.Excel2003Reader;
import com.linjw.business.utils.excel.imp.Excel2007Reader;
import com.linjw.business.utils.excel.imp.ExcelReader;
import com.linjw.business.utils.excel.imp.NotAnExcelFileException;
import com.linjw.business.utils.excel.imp.TemplateFormatException;

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
	
	public static<T> void export(List<T> list, ExcelExportConfig export) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createCellStyle();
		XSSFSheet sheet = workbook.createSheet(export.getSheetName());
		Map<String, Column> headerMap = export.getHeaderMap();
		
		int rowIndex = export.getStartRowIndex() - 1;
		if(!export.printHeader()) {
			rowIndex--;
		}else {
			XSSFRow row = sheet.createRow(rowIndex);
			Object[] colNames = headerMap.values().toArray();
			for (int colIndex = 0; colIndex < colNames.length; colIndex++) {
				XSSFCell cell = row.createCell(colIndex);
				Column column = (Column)colNames[colIndex];
				sheet.setColumnWidth(colIndex, column.getWidth());
				cell.setCellStyle(export.getHeaderCellStyle(workbook));
				cell.setCellValue(((Column)colNames[colIndex]).getColumnDisplayName());
			}
		}
		
		for (int listIndex = 0; listIndex < list.size(); listIndex++) {
			int colIndex = 0;
			T rowObj = list.get(listIndex);
			XSSFRow row = sheet.createRow(++rowIndex);
			for (String colField : headerMap.keySet()) {
				Object colVaule = PropertyUtils.getProperty(rowObj, colField);
				XSSFCell cell = row.createCell(colIndex);
				cell.setCellValue(colVaule.toString());
				colIndex++;
			}
		}
		
		FileOutputStream fos = new FileOutputStream(export.getOutputFilePath());
		workbook.write(fos);
		fos.flush();
		fos.close();
	}

}

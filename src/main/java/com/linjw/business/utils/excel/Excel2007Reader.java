package com.linjw.business.utils.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.cglib.core.ReflectUtils;

/**
 * Read Excel 2007 file
 * @author Administrator
 *
 */
public class Excel2007Reader extends AbstractExcelReader {

	public <T> List<T> read(String filePath, Class<T> clazz) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, TemplateFormatException, NoSuchMethodException, SecurityException {

		System.out.println("" + filePath);
		InputStream is = new FileInputStream(filePath);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		List<T> list = new ArrayList<T>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < 1; numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row

			int rowNum = xssfSheet.getLastRowNum();
			Map<String, Field> map = getColToFieldMap(clazz);
			String[] columnHeader = readColumnHeader(xssfSheet, map, 0);
			for (int curRowNum = 1; curRowNum <= rowNum; curRowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					T obj = clazz.newInstance();
					for (int curColNum = 0; curColNum < columnHeader.length; curColNum++) {
						String columnName = columnHeader[curColNum];
						Field field = map.get(columnName);
						String fieldName = field.getName();
						String setMethodName = "set" + String.valueOf(fieldName.charAt(0)).toUpperCase()
								+ fieldName.substring(1);
						Method method = clazz.getMethod(setMethodName, String.class);
						xssfRow.getCell(curColNum).setCellType(Cell.CELL_TYPE_STRING);
						method.invoke(obj, xssfRow.getCell(curColNum).getStringCellValue());
					}
					list.add(obj);
				}

			}
		}
		return list;
	}

}

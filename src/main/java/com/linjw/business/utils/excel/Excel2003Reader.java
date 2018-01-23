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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.cglib.core.ReflectUtils;

public class Excel2003Reader extends AbstractExcelReader {

	public <T> List<T> read(String filePath, Class<T> clazz) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {

		System.out.println("processing " + filePath);
		InputStream is = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

		List<T> list = new ArrayList<T>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < 1; numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			int rowNum = hssfSheet.getLastRowNum();
			int colNum = hssfSheet.getLastRowNum();
			String[] columnHeader = readColumnHeader(hssfSheet);
			for (int curRowNum = 1; curRowNum <= rowNum; curRowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					T obj = clazz.newInstance();
					for (int curColNum = 0; curColNum < colNum; curColNum++) {
						String columnName = columnHeader[curColNum];
						Field[] f = clazz.getFields();
						for (Field field : f) {
							Column col = field.getDeclaredAnnotation(Column.class);
							if (columnName.equals(col.actualColName())) {
								String fieldName = field.getName();
								String setMethodName = "set" + String.valueOf(fieldName.charAt(0)).toUpperCase()
										+ fieldName.substring(2);
								Method method = ReflectUtils.findMethod(setMethodName);
								method.invoke(obj, hssfRow.getCell(curColNum).getStringCellValue());
							}
							;
						}
					}
					list.add(obj);
				}

			}
		}
		return list;
	}

}

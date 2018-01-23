package com.linjw.business.utils.excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public abstract class AbstractExcelReader implements ExcelReader {

	public static String getSuffiex(String path) {
		if (StringUtils.isBlank(path)) {
			return null;
		}
		int index = path.lastIndexOf(".");
		if (index == -1) {
			throw null;
		}
		return path.substring(index + 1, path.length());
	}

	public static String[] readColumnHeader(XSSFSheet xssfSheet, Map<String, Field> map, Integer headerRowNum)
			throws TemplateFormatException {
		if (xssfSheet == null) {
			return null;
		}
		if (headerRowNum == null) {
			headerRowNum = 0;
		}
		XSSFRow xssfRow = xssfSheet.getRow(headerRowNum);
		int colNum = xssfRow.getLastCellNum();
		String[] columnHeader = new String[colNum];
		List<String> wrongCols = new ArrayList<String>();
		for (int curColNum = 0; curColNum < colNum; curColNum++) {
			XSSFCell cell = xssfRow.getCell(curColNum);
			/*if (cell == null) {
				wrongCols.add("col number: " + curColNum + ",col name : blank");
				continue;
			}*/
			if(cell == null) {
				columnHeader[curColNum] = null;
			}
			String columnValue = cell.getStringCellValue();
			if (map.get(columnValue) == null) {
				wrongCols.add("col number: " + curColNum + ",col value :" + columnValue);
			} else {
				columnHeader[curColNum] = columnValue;
			}
		}

		if (!wrongCols.isEmpty()) {
			String[] wrongColsArr = new String[wrongCols.size()];
			throw new TemplateFormatException(
					"Your submitted template has wrong coulmns: " + Arrays.toString(wrongCols.toArray(wrongColsArr)));
		}
		return columnHeader;
	}

	public static String[] readColumnHeader(HSSFSheet hssfSheet) {
		return readColumnHeader(hssfSheet, 0);
	}

	public static String[] readColumnHeader(HSSFSheet hssfSheet, Integer headerRowNum) {
		if (hssfSheet == null) {
			return null;
		}
		if (headerRowNum == null) {
			headerRowNum = 0;
		}
		HSSFRow hssfRow = hssfSheet.getRow(headerRowNum);
		int colNum = hssfRow.getLastCellNum();
		String[] columnHeader = new String[colNum];
		for (int curColNum = 0; curColNum < colNum; curColNum++) {
			HSSFCell cell = hssfRow.getCell(curColNum);
			columnHeader[curColNum] = cell.getStringCellValue();
		}
		return columnHeader;
	}

	public static Map<String, Field> getColToFieldMap(Class clazz) {
		Map<String, Field> map = new HashMap<String, Field>();
		Field[] f = clazz.getDeclaredFields();
		for (Field field : f) {
			Column col = field.getDeclaredAnnotation(Column.class);
			map.put(col.actualColName(), field);
		}
		return map;
	}

	private static String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

	private static String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

}

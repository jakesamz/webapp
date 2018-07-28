package com.linjw.business.utils.excel.export;

import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelExportConfig {
	
	boolean printHeader();
	
	LinkedHashMap<String, Column> getHeaderMap();
	
	String getOutputFilePath();

	int getStartRowIndex();
	
	String getOutputFileName();

	String getSheetName();

	CellStyle getHeaderCellStyle(XSSFWorkbook workbook);

}

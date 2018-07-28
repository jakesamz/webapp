package com.linjw.business.utils.excel.export.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.linjw.business.utils.excel.export.AbstractDefaultExcelExportConfig;
import com.linjw.business.utils.excel.export.Column;

public class CourseExportConfig extends AbstractDefaultExcelExportConfig {
	
	public LinkedHashMap<String, Column> getHeaderMap() {
		return new LinkedHashMap<String, Column>(){{
			put("id", new Column(""));
		}} ;
	}
	
	@Override
	public boolean printHeader() {
		return false;
	}

	public CellStyle getHeaderCellStyle(XSSFWorkbook workbook) {
		CellStyle cs = workbook.createCellStyle();
		Font titleFont = workbook.createFont();  
        titleFont.setFontHeightInPoints((short) 18);  
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);  
        cs.setAlignment(CellStyle.ALIGN_CENTER);  
        cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);  
        cs.setFont(titleFont);
		return cs;  
	}


	public int getStartRowIndex() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getOutputFileName() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getSheetName() {
		// TODO Auto-generated method stub
		return null;
	}


}

package com.linjw.business.utils.excel.export.impl;

import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.linjw.business.utils.excel.export.Column;
import com.linjw.business.utils.excel.export.ExcelExportConfig;

public class CourseExportConfig implements ExcelExportConfig {
	
	@Override
	public LinkedHashMap<String, Column> getHeaderMap() {
		return new LinkedHashMap<String, Column>(){{
			put("id", new Column("Course Id", 10000));
			put("name", new Column("Course Name", 10000));
		}};
	}


	@Override
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


	@Override
	public boolean printHeader() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getOutputFilePath() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getStartRowIndex() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getOutputFileName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getSheetName() {
		// TODO Auto-generated method stub
		return "STREAMXINSDFSDF";
	}

}

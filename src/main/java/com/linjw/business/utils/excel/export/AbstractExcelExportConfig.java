package com.linjw.business.utils.excel.export;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractExcelExportConfig implements ExcelExportConfig {
	
	private LinkedHashMap<String, Column> headerMap;
	
	private boolean printHeader = true;
	
	private int startRowIndex = 0;
	
	private String outputFilePath = "d://";
	
	private String sheetName = "default sheet name";
	
	private String outputFileName = "default file name";

	public boolean printHeader() {
		return printHeader;
	}

	public void setPrintHeader(boolean printHeader) {
		this.printHeader = printHeader;
	}

	public int getStartRowIndex() {
		return startRowIndex;
	}

	public void setStartRowIndex(int startRowIndex) {
		this.startRowIndex = startRowIndex;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public LinkedHashMap<String, Column> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(Map<String, Column> headerMap) {
		//this.headerMap = headerMap;
	}

}

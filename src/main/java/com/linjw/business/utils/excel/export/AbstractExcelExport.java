package com.linjw.business.utils.excel.export;

public abstract class AbstractExcelExport implements ExcelExportConfig {
	
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

}

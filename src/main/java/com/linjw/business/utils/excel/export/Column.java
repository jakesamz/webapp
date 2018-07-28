package com.linjw.business.utils.excel.export;

import org.apache.poi.ss.usermodel.CellStyle;

public class Column {
	
	private String columnDisplayName;
	
	private int width;
	
	private CellStyle cellStyle;
	
	public Column(String columnDisplayName) {
		setColumnDisplayName(columnDisplayName);
	}
	
	public Column(String columnDisplayName, int width) {
		this.columnDisplayName = columnDisplayName;
		this.width = width;
	}

	public String getColumnDisplayName() {
		return columnDisplayName;
	}

	public void setColumnDisplayName(String columnDisplayName) {
		this.columnDisplayName = columnDisplayName;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public CellStyle getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(CellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}
	
}

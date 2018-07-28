package com.linjw.business.utils.excel.export;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDefaultExcelExportConfig extends AbstractExcelExportConfig {
	
	
	@Override
	public String getOutputFilePath() {
		ApplicationContext cxt =  null;
		JdbcTemplate template = cxt.getBean(JdbcTemplate.class);
		String path = template.queryForObject("select path from sys_params", String.class);
		return path;
	}

}

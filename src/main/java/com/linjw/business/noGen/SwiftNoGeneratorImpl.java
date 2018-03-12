/*
 *File Name: YOUR FILE NAME
 *Copyright pccw.com. 2003-2011, All rights reserved.
 *Created by: YOUR  NAME
 *Created Date:  2013-04-22 10:14:34
 */
package com.linjw.business.noGen;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class SwiftNoGeneratorImpl extends AbstractSwiftNoGenerator{
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PropertiesFactoryBean systemParams;
	
	public SwiftNoGeneratorImpl(int bits, String userId) {
		super(bits, userId);
	}
	
	public Integer getCurrSwiftNo() {
		String sql = "select current_val from EMS_IRU_PO_PROCESS_SEQ where year = to_char(sysdate,'yyyy')";
		Integer swiftNo = new JdbcTemplate().queryForObject(sql, Integer.class);
		return swiftNo;
	}
	
	public Integer getNewSwiftNo () {
		Integer currSwiftNo = getCurrSwiftNo();
		if(currSwiftNo == null) {
			String insertSql = "insert into EMS_IRU_PO_PROCESS_SEQ(id, year, current_val, created_by, created_date, last_updated_by, last_updated_date) "
					+ "values (to_char(sysdate,'yyyy'),to_char(sysdate,'yyyy'),1,?,sysdate,?,sysdate)";
			new JdbcTemplate().update(insertSql, new Object[]{this.getUserId(),this.getUserId()});
			return START_VALUE;
		}
		
		int newSwiftNo = currSwiftNo + INCREMENT;
		if(newSwiftNo > MAX_VALUE) {
			newSwiftNo = START_VALUE;
		}
		String updateSql = "update EMS_IRU_PO_PROCESS_SEQ set current_val = " + newSwiftNo + ", last_updated_by = ?, last_updated_date = sysdate where year = to_char(sysdate,'yyyy')";
		new JdbcTemplate().update(updateSql, new Object[]{this.getUserId()});

		return newSwiftNo;
	}
	
	public String getFormattedSwiftNo() {
		String format = "%0" + String.valueOf(this.getBits()) + "d";
		return String.format(format, getNewSwiftNo());
	}

	public String generate() {
		return getFormattedSwiftNo();
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println(jdbcTemplate);
		int list = jdbcTemplate.queryForObject("select count(*) from  px_s_ge_ma_roadshow_loc", Integer.class);
		System.out.println(list);
		System.out.println(systemParams.getObject().get("app.mail.from"));;
	}
	
	
	
}

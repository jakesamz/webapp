package com.linjw.db;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.linjw.business.beans.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/spring-context-test.xml","/spring-web-mvc-config-test.xml",})
public class TestDB {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	@Transactional(rollbackFor=RuntimeException.class)
	public void test() {
		
		//List<Emp> emp = jdbcTemplate.query("select * from emp", BeanPropertyRowMapper.newInstance(Emp.class));
		//List<Map<String, Object>> emp = jdbcTemplate.queryForList("select * from emp");
		//List<String> emp = jdbcTemplate.queryForList("select first_name from emp", String.class);
		//Map<String, Object> emp = jdbcTemplate.queryForMap("select first_name from emp where rownum = 1");

		//System.out.println(emp);
		jdbcTemplate.update("update emp set salary = 24001 where employee_id = 100");
		int i = 1/0;
	}

}

package db;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import webmvc.TestSuperClass;

public class TestDB extends TestSuperClass {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	@Transactional(rollbackFor = RuntimeException.class)
	public void test() {
		
		// List<Emp> emp = jdbcTemplate.query("select * from emp",
		// BeanPropertyRowMapper.newInstance(Emp.class));
		// List<Map<String, Object>> emp = jdbcTemplate.queryForList("select * from
		// emp");
		// List<String> emp = jdbcTemplate.queryForList("select first_name from emp",
		// String.class);
		// Map<String, Object> emp = jdbcTemplate.queryForMap("select first_name from
		// emp where rownum = 1");

		// System.out.println(emp);
		jdbcTemplate.update("update emp set salary = 24001 where employee_id = 100");
		// int i = 1/0;
		
		String updateSql = "";
		
		jdbcTemplate.update(updateSql);
	}

}

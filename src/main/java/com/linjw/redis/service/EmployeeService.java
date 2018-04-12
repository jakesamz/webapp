package com.linjw.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.linjw.business.beans.Emp;

@Service
public class EmployeeService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Emp> findAllEmp(){
		
		return jdbcTemplate.query("select * from emp", 
				BeanPropertyRowMapper.newInstance(Emp.class));
		
	} 
	
	@Cacheable(cacheNames="accountCache")
	public List<Emp> findAllEmpCacheable(){
		
		return jdbcTemplate.query("select * from emp", 
				BeanPropertyRowMapper.newInstance(Emp.class));
		
	}

}




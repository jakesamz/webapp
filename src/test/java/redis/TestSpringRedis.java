package redis;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.linjw.business.beans.Emp;
import com.linjw.redis.service.EmployeeService;

import webmvc.TestSuperClass;

public class TestSpringRedis extends TestSuperClass {

	@Autowired
	EmployeeService service;
	
	
	@Test
	public void service() {
		
		List<Emp> list = service.findAllEmp();

		System.out.println("find list first time");
		System.out.println(list);
		System.out.println(list);
		
		list = service.findAllEmp();

		System.out.println("find list 2nd time");
		System.out.println(list);
		
		List<Emp> list2 = service.findAllEmpCacheable();
		System.out.println("find list2 first time");
		System.out.println(list2);

		
		System.out.println("find list2 2nd time");
		
		
		list2 = service.findAllEmpCacheable();
		System.out.println(list2);
		
	}
	
	
	
	
}

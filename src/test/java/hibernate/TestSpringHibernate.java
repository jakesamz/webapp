package hibernate;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import webmvc.TestSuperClass;


public class TestSpringHibernate extends TestSuperClass {

	
	@Autowired
	Service serviceImpl;//This is a proxy object that implemented Service.
	@Test
	public void service() {
		System.out.println(serviceImpl instanceof Proxy);
		//serviceImpl.service();
		serviceImpl.invokeService();
	}
	
}

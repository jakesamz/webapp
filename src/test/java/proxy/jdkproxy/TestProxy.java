package proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import hibernate.Service;

public class TestProxy {
	
	
	public static void main(String[] args) {
		
		Service s1 = new ServiceImpl();
		
		Service s = (Service) Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(), 
				new Class[] {Service.class}, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						System.out.println("--start transaction--");
						method.invoke(s1, args);
						System.out.println("--end transaction--");
						return null;
					}
				});
		s.service();
		s.invokeService();
		
		
	}
	
	

}

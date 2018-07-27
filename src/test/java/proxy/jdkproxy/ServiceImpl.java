package proxy.jdkproxy;

import hibernate.Service;

public class ServiceImpl implements Service {

	public void service() {
		System.out.println("service");
		this.invokeService();
	}

	@Override
	public void invokeService() {
		System.out.println("invokeService");
	}
	
}

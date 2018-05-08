package basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			/*es.submit(*/
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					String name = Thread.currentThread().getName();
					System.out.println(name);
				}
			});
		}
		
		es.shutdown();
	}

	
	/*jre: ����������java���������⣨��java��׼��API���Լ�Java�����. jdk�����˰���jre��Ҳ�����˿���java����Ĺ���*/
}

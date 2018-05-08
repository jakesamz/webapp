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

	
	/*jre: 包含了运行java程序各种类库（即java标准库API）以及Java虚拟机. jdk：除了包含jre，也包含了开发java代码的工具*/
}

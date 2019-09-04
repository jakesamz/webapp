package basic.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
	
	private static AtomicInteger ai = new AtomicInteger(0);
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 1000; j++) {
						ai.incrementAndGet();
					}
				}
			}).start();;
		}
		
		while(Thread.activeCount() > 1) {
			Thread.yield();
		}
		
		System.out.println(ai);
	}

}

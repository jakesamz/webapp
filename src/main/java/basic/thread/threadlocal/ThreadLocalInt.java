package basic.thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalInt {
	
	private static final AtomicInteger nextId = new AtomicInteger(1);
	
	private static ThreadLocal<Integer> t = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return nextId.getAndAdd(3);
		};
	};
	
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					System.out.println(t.get());;
				};
			}.start();
		}
		
	}
	

}

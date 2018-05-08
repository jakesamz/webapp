package basic.thread.threadlocal;

public class TestThreadLocal {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.set(Thread.currentThread().getName());
		
		System.out.println(tl.get());;
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				tl.set(Thread.currentThread().getName());
				System.out.println(tl.get());
			}
		});
		t.start();
		t.join();
		System.out.println(tl.get());;
	}

}

package basic.thread.threadlocal;

public class TestThreadLocal {
	//线程本地变量，每个线程在使用到该变量时初始化一个自己的副本...
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadLocal<String> tl = new ThreadLocal<String>(){
			@Override
			public String get() {
				return super.get();
			}
		};
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

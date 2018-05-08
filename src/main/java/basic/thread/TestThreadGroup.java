package basic.thread;

public class TestThreadGroup {
	
	public static void main(String[] args) {
		
		//QuartzScheduler z;
		
		String name = Thread.currentThread().getThreadGroup().getName();
		System.out.println(name);
		
		ThreadGroup tg = new ThreadGroup("thread group 1");
		Thread t = new Thread(tg, "first thread");
		
		name = t.getThreadGroup().getName();
		System.out.println(name);
		
		System.out.println(tg.getParent());
		
	}

}

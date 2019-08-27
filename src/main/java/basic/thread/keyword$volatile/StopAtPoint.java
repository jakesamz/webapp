package basic.thread.keyword$volatile;

public class StopAtPoint {
	
	
	public static boolean stop = false;
	
	static class Thread1 extends Thread {
		@Override
		public void run() {
			int i = 0;
			System.out.println(stop + Thread.currentThread().getName());
			while(!stop) {
				i++;
			}
			System.out.println(i);
			System.out.println(stop + Thread.currentThread().getName());
		}
	}
	
	static class Thread2 extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stop = true;
			System.out.println(stop + Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {

		Thread1 t1 = new Thread1();;
		t1.start();
		Thread2 t2 = new Thread2();

		t2.start();
		//t2.join();
		
		
	}

}

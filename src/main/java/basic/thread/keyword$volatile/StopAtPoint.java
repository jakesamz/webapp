package basic.thread.keyword$volatile;

public class StopAtPoint {
	
	
	public static volatile boolean stop = false;
	
	/*
	public void doWork(){
		
		int i = 0;
		while(!stop) {
			i++;
		}
	}*/
	
	public static void doStop(){
		stop = true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int i = 0;
					while(!stop) {
						i++;
					}
					System.out.println(i);
				}
			}).start();
		}
		
		Thread.sleep(1000);
		
		StopAtPoint.doStop();
		
	}

}

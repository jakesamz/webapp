package basic.thread.ticket;

public class TestSellTicket2 {
	
	static int total = 20;
	
	public static void sell() {
		//这里延迟1毫秒，使得结果明显 
        try { 
            Thread.sleep(1); 
        } catch (InterruptedException e) { 
        } 
		total--;
	}
	
	public static void main(String[] args) throws InterruptedException {
		/*ExecutorService es = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 20; i++) {
			es.submit(
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					new TestSellTicket().sell();
				}
			});
		}*/
		for (int i = 0; i < 20; i++) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					TestSellTicket2.sell();
				}
			});
			t.join();t.start();
		}
		System.out.println(Thread.currentThread().getName() + ": left ticket num :" + total);
	}

}

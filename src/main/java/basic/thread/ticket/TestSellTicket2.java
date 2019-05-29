package basic.thread.ticket;

public class TestSellTicket2 {
	
	private static int total = 1000;
	
	public static void sell() {
		//这里延迟1毫秒，使得结果明显 
        try { 
            Thread.sleep(100); 
        } catch (InterruptedException e) { 
        } 
		total--;
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < total; i++) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					TestSellTicket2.sell();
				}
			});
			t.start();
		}
		while (Thread.activeCount() > 1) {
            Thread.yield();
        }
		System.out.println(Thread.currentThread().getName() + ": left ticket num :" + total);
	}

}

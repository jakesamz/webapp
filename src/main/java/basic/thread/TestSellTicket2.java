package basic.thread;

public class TestSellTicket2 {
	
	static Ticket ticket = new Ticket();
	
	public void sell() {
			;
	}
	
	public static void main(String[] args) {
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
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						synchronized (ticket) {
							if(ticket.getTotal() > 0) {
								ticket.sellTicket();
								System.out.println(Thread.currentThread().getName() + ": left ticket num :" + ticket.getTotal());
							}else {
								break;
							}
						}
					}
					
				}
			}).start();;
		}
	}

}

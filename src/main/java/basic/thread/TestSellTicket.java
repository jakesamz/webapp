package basic.thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestSellTicket {
	
	static Queue<String> tickets = new ConcurrentLinkedQueue<>();
	
	static{
	        for(int i=1;i<=100;i++) tickets.add("第" + i + "张票");//2.往容器中放1000张票
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
						 String ticket = tickets.poll();//4.一张张票出队列
	                     if(ticket == null) break;
	                     else System.out.println( Thread.currentThread().getName() + "-销售--" + ticket);
					}
					
				}
			}).start();;
		}
	}

}

class Ticket {
	int total = 100;
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void sellTicket(){
		if(total > 0) {
			--total;
		}
	}
}

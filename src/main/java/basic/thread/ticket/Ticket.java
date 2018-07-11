package basic.thread.ticket;

public class Ticket {
	int total = 20;
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void sellTicket(){
		//这里延迟1毫秒，使得结果明显 
        try { 
            Thread.sleep(1); 
        } catch (InterruptedException e) { 
        } 
		--total;
	}
}

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
		//�����ӳ�1���룬ʹ�ý������ 
        try { 
            Thread.sleep(1); 
        } catch (InterruptedException e) { 
        } 
		--total;
	}
}

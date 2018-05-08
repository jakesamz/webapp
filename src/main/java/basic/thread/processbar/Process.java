package basic.thread.processbar;

import java.text.DecimalFormat;

public class Process extends Thread {
	
	private String percent;
	
	private double curIndex;
	
	public void run() {
		
		for (; curIndex < 100; curIndex=curIndex+0.6) {
			try {
				Thread.sleep(1524);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DecimalFormat df = new DecimalFormat("0.00%");  
			setPercent(df.format(curIndex/100d));
			System.out.println(getPercent());
		}
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

}

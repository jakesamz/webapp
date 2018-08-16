package basic.designpattern.strategyfactory;

public class Alipay implements PayStrategy {
	
	public void pay(double total) {
		System.out.println("pay with alipay: " + total);
	}

}

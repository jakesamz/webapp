package basic.designpattern.strategyfactory;

public class EbankPay implements PayStrategy {
	
	public void pay(double total) {
		System.out.println("pay with ebankpay: " + total);
	}

}

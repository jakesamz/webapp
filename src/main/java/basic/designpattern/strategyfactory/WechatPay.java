package basic.designpattern.strategyfactory;

public class WechatPay implements PayStrategy {
	
	public void pay(double total) {
		System.out.println("pay with wechatpay: " + total);
	}

}

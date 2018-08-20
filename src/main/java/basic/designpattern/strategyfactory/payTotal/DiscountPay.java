package basic.designpattern.strategyfactory.payTotal;

public class DiscountPay implements PayTotalCalculator {
	
	private double total;
	
	DiscountPay(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
	
}

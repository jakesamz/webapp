package basic.designpattern.strategyfactory.payTotal;

public class NormalPay implements PayTotalCalculator {
	
	private double total;
	
	NormalPay(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}
	
}

package basic.designpattern.factory.abstr.fastfood;

public class Client {
	
	public static void main(String[] args) {
		
		FastFoodFactory factory = new KFC();
		factory.createBeverage();
		factory.createBurger();
		
		factory = new MCDonalds();
		factory.createBeverage();
		factory.createBurger();
		
		KFC kfc = new KFC();
		kfc.createBeverage();
	}

}

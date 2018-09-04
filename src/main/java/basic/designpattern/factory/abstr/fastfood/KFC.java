package basic.designpattern.factory.abstr.fastfood;

public class KFC implements FastFoodFactory {

	@Override
	public Beverage createBeverage() {
		// TODO Auto-generated method stub
		System.out.println("CocaCola from KFC");
		return new CocaCola();
	}

	@Override
	public Burger createBurger() {
		// TODO Auto-generated method stub
		System.out.println("Hamburger from KFC");
		return new Hamburger();
	}

}

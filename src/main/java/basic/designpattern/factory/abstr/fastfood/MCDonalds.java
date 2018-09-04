package basic.designpattern.factory.abstr.fastfood;

public class MCDonalds implements FastFoodFactory {

	@Override
	public Beverage createBeverage() {
		// TODO Auto-generated method stub
		System.out.println("CocaCola from Mac Donald's");
		return new CocaCola();
	}

	@Override
	public Burger createBurger() {
		// TODO Auto-generated method stub
		System.out.println("Hamburger from Mac Donald's");
		return new Hamburger();
	}

}

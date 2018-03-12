package basic.oop.association.aggr;


public class Driver {
	
	public Car car;
	
	public Driver() {
		car = new Car();
	}
	
	public void drive() {
		car.start();//Æô¶¯
	}

}

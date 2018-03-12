package com.linjw.spring.ioc.car;

public class TestCar {
	
	public static void main(String[] args) {
		
		Car car = new Car();
		car.setFramework(new Framework());
	}

}

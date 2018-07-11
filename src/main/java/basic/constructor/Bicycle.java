package basic.constructor;

public class Bicycle {
	private int gear = 6;
	private int cadence;
	private int speed;
	public Bicycle(int startCadence, int startSpeed, int startGear) {
		System.out.println(gear);
	    gear = startGear;
	    cadence = startCadence;
	    speed = startSpeed;
	}
	
	public static void main(String[] args) {
		new Bicycle(1, 2, 3);
	}

}

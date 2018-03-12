package basic.oop.extension;

public class Client {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		animal.grow();
		
		animal = new Lion();
		animal.grow();
		
	}
	
	
}

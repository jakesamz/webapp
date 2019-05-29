package basic.jvm.chapter8;

public class StaticDispatch {
	
	static abstract class Human{}
	
	static  class Man extends Human{}
	
	static  class Woman extends Human{}
	
	public void sayHello(Human human){
		System.out.println("hi guy");
	}
	
	public void sayHello(Man human){
		System.out.println("hi man");
	}
	
	public void sayHello(Woman human){
		System.out.println("hi woman");
	}
	
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		Man man1 = new Man();
		
		StaticDispatch sd = new StaticDispatch();
		sd.sayHello(man);
		sd.sayHello(woman);
		sd.sayHello(man1);
		sd.sayHello(new Man());
	}

}

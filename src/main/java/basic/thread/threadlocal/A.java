package basic.thread.threadlocal;

public class A {
	
	
	public int i = 1;
	
	protected String s = "1";
	
	public void setI() {
		//;
	}
	
	public int getI() {
		this.setI();
		return i;
	}
	
	public static void main(String[] args) {
		
		A a = new A() {
			{i = 2;}
			@Override
			public void setI() {
				this.i = 3;
			}
		};
		
		a.getI();
		System.out.println(a.i);
		
		
	}
	

}

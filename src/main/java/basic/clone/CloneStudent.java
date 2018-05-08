package basic.clone;

public class CloneStudent {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Student s = new Student();
		s.setId("1");
		s.setC(new Course());
		System.out.println(s);
		Object o = s.clone();
		System.out.println(o);
		Student s2 = (Student) o;
		System.out.println(s2.getId());
		System.out.println(s.getC());
		System.out.println(s2.getC());
	}
	
	
}

class Student implements Cloneable {
	
	private String id;
	
	private Course c;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setC(Course c) {
		this.c = c;
	}
	
	public Course getC() {
		return c;
	}	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student s = (Student) super.clone();
		s.setC((Course) s.getC().clone());
		return s;
	}
	
}

class Course implements Cloneable {
	private String name;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

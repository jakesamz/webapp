package basic.oop.association.aggr;

import java.util.List;

public class Class {
	
	private List<Student> students;
	
	public Class() {}
	
	public Class(List<Student> students) {
		this.students = students;
	}
	
	public void printAllStudent() {
		for (Student student : students) {
			System.out.println(student.getName());
		}
	}

}

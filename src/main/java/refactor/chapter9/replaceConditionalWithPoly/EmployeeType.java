package refactor.chapter9.replaceConditionalWithPoly;

public abstract class EmployeeType {

	public static final String Engineer = "1";
	
	public static final String Saleman = "2";
	
	public abstract double getPayAmount(Employee e); 
	
}

package refactor.chapter9.replaceConditionalWithPoly;

public class Client {
	
	public void getPayAmount(){
		double amount = 0;
		Employee e = new Employee();
		switch (e.getType()) {
		case EmployeeType.Engineer:
			amount = 1000;
			break;
		case EmployeeType.Saleman:
			amount = 800;
			break;
		default:
			break;
		}
		
	}

}

package utils;

public class TestValidationUtils {

	public static void main(String[] args) {
		
		System.out.println(ValidationUtils.isDigits("6.25"));;
		
		System.out.println(ValidationUtils.isNumber("1225."));;
		
		System.out.println(ValidationUtils.isPossiveNumber("2.9s"));
		
		System.out.println(ValidationUtils.isNegativeNumber("2.9s"));
	}
	
	
}

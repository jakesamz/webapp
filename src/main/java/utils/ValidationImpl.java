package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {

	public boolean validateUserAccount(String userAccount) {
		return false;
	}
	
	public boolean validatePassword(String password) {
		return false;
	}
	
	public boolean validatePhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("(13|14|15|17|18)[0-9]{9}");
        Matcher m =pattern.matcher(phoneNumber);
        return m.matches();
	}
	
}

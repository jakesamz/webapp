import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


public class ValidateUtils {

	/**
	 * 验证字符串是否都是数字
	 */
	public static boolean isDigits(String str){
		return NumberUtils.isDigits(str);
		//or StringUtils.isNumeric(str)
	}
	
	/**
	 * 验证字符串是否只包含字母
	 * @param str
	 * @return
	 */
	public static boolean isAlpha(String str){
		return StringUtils.isAlpha(str);
	}
	
	/**
	 * 用户名首字母为字母 且长度大于等于8
	 * @param username
	 * @return true if username is valid
	 */
	public static boolean userNameValid(String username){
		Pattern pattern = Pattern.compile("[a-zA-Z]\\w{7,}");
		Matcher m =pattern.matcher(username);
		return m.matches();
	}
	
	/**
	 * 验证手机号码格式是否正确
	 * @param phoneNumber
	 * @return true if phone number is valid
	 */
	public static boolean phoneNumberValid(String phoneNumber){
		Pattern pattern = Pattern.compile("(13|14|15|17|18)[0-9]{9}");
		Matcher m =pattern.matcher(phoneNumber);
		return m.matches();
	}
	
	public static void main(String[] args) {
		
		System.out.println(NumberUtils.isDigits("1231a3"));;
		System.out.println(StringUtils.isNumeric("123"));;
		System.out.println(Character.isDigit('a'));
		System.out.println(Character.isDigit("a".charAt(0)));
		System.out.println(NumberUtils.isParsable("1.2"));
		System.out.println(StringUtils.isAlpha("123"));
		System.out.println(phoneNumberValid("132012458479"));
		System.out.println(userNameValid("a_______"));
	}
}

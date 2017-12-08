package utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class ValidationUtils {

	// public Validation validation = new ValidationImpl();
	/***/
	public static final String REGEX_USERACCOUNT = "";

	public static final String REGEX_PHONENUMBER = "";

	public static final String REGEX_URL = "";

	public static final String REGEX_PASSWORD = "";

	public static final String REGEX_EMAIL = "";

	/** 身份证 */
	public static final String REGEX_IDCARD = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";

	/**
	 * 验证字符串是否为空
	 * 
	 * @param cs
	 * @return
	 */
	public boolean isBlank(final CharSequence cs) {
		return StringUtils.isBlank(cs);
	}

	/**
	 * 验证字符串是否不为空
	 * 
	 * @param cs
	 * @return
	 */
	public boolean isNotBlank(final CharSequence cs) {
		return StringUtils.isNotBlank(cs);
	}

	/**
	 * 验证字符串是否是纯数字字符串
	 */
	public static boolean isDigits(final CharSequence cs) {
		return StringUtils.isNumeric(cs);
	}

	/**
	 * 验证字符串是否是数字型字符串，包括小数
	 */
	public static boolean isNumber(String str) {
		return NumberUtils.isParsable(str);
	}
	
	public static boolean isPossiveNumber(String str){
		if(!isNumber(str)){
			return false;
		}
		return Double.valueOf(str) > 0;
	}
	
	public static boolean isNegativeNumber(String str){
		if(!isNumber(str)){
			return false;
		}
		return Double.valueOf(str) < 0;
	}
	
	/**
	 * 验证字符串是否是纯字母字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isAlpha(String str) {
		return StringUtils.isAlpha(str);
	}

	/**
	 * 验证是否是url
	 * 
	 * @param url
	 * @return
	 */
	public boolean isUrl(String str) {
		return match(REGEX_URL, str);
	}

	/**
	 * 验证手机号码是否合法
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean isPhoneNumber(String str) {
		return match(REGEX_PHONENUMBER, str);
	}

	/**
	 * 验证账户是否合法
	 * 
	 * @param userAccount
	 * @return
	 */
	public boolean isUserAccountValid(String str) {
		return match(REGEX_USERACCOUNT, str);
	}

	/**
	 * 验证密码
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPasswordValid(String str) {
		return match(REGEX_PASSWORD, str);
	}

	/**
	 * 验证邮箱
	 * 
	 * @param str
	 * @return
	 */
	public boolean isEmail(String str) {
		return match(REGEX_EMAIL, str);
	}

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	private static boolean match(String regex, String str) {
		return Pattern.compile(regex).matcher(str).matches();
	}

}

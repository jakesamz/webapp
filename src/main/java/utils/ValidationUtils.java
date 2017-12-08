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

	/** ���֤ */
	public static final String REGEX_IDCARD = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";

	/**
	 * ��֤�ַ����Ƿ�Ϊ��
	 * 
	 * @param cs
	 * @return
	 */
	public boolean isBlank(final CharSequence cs) {
		return StringUtils.isBlank(cs);
	}

	/**
	 * ��֤�ַ����Ƿ�Ϊ��
	 * 
	 * @param cs
	 * @return
	 */
	public boolean isNotBlank(final CharSequence cs) {
		return StringUtils.isNotBlank(cs);
	}

	/**
	 * ��֤�ַ����Ƿ��Ǵ������ַ���
	 */
	public static boolean isDigits(final CharSequence cs) {
		return StringUtils.isNumeric(cs);
	}

	/**
	 * ��֤�ַ����Ƿ����������ַ���������С��
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
	 * ��֤�ַ����Ƿ��Ǵ���ĸ�ַ���
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isAlpha(String str) {
		return StringUtils.isAlpha(str);
	}

	/**
	 * ��֤�Ƿ���url
	 * 
	 * @param url
	 * @return
	 */
	public boolean isUrl(String str) {
		return match(REGEX_URL, str);
	}

	/**
	 * ��֤�ֻ������Ƿ�Ϸ�
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean isPhoneNumber(String str) {
		return match(REGEX_PHONENUMBER, str);
	}

	/**
	 * ��֤�˻��Ƿ�Ϸ�
	 * 
	 * @param userAccount
	 * @return
	 */
	public boolean isUserAccountValid(String str) {
		return match(REGEX_USERACCOUNT, str);
	}

	/**
	 * ��֤����
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPasswordValid(String str) {
		return match(REGEX_PASSWORD, str);
	}

	/**
	 * ��֤����
	 * 
	 * @param str
	 * @return
	 */
	public boolean isEmail(String str) {
		return match(REGEX_EMAIL, str);
	}

	/**
	 * @param regex
	 *            ������ʽ�ַ���
	 * @param str
	 *            Ҫƥ����ַ���
	 * @return ���str ���� regex��������ʽ��ʽ,����true, ���򷵻� false;
	 */
	private static boolean match(String regex, String str) {
		return Pattern.compile(regex).matcher(str).matches();
	}

}

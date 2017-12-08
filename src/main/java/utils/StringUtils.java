package utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	

	public static String wrapWithSingleQuotes(String str){
	    return wrap(str, ",", "'");
	}

	/**
	 * ���ַ������ݱ����ŷָ�����ÿ��С���� ���߶����ϵ����š��ʺ�д���ݿ�sql in��� ʱƴ��ʹ��
	 * <pre>
	 * ����
	 * a ת��'a',
	 * a,b,c ת��'a','b','c'
	 * null����ַ��� ת�� ��
	 * </pre>
	 * @param str
	 * @param separator
	 * @param wrapWith
	 * @return
	 */
	public static String wrap(String str, String separator, String wrapWith){
		if(isBlank(str) || isBlank(separator) || isBlank(wrapWith)) {
	        return EMPTY;
	    }
		return wrapWith
				.concat(str.replace(separator, wrapWith.concat(separator).concat(wrapWith)))
				.concat(wrapWith);
	}
	
	/**
	 * Same functionality as wrap
	 * @param str
	 * @param separator
	 * @param wrapWith
	 * @return
	 */
	public static String wrap2(String str, String separator, String wrapWith){
		if(isBlank(str) || isBlank(separator) || isBlank(wrapWith)) {
	        return EMPTY;
	    }
	    return wrapWith
	    		.concat(join(str.split(separator),wrapWith + separator + wrapWith))
	    		.concat(wrapWith);
	}
	
	public static void main(String[] args) {
		System.out.println(wrapWithSingleQuotes("1,2,3,4"));
	}
	
}

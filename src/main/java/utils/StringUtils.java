package utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	

	public static String wrapWithSingleQuotes(String str){
	    return wrap(str, ",", "'");
	}

	/**
	 * 把字符串内容被逗号分隔开的每个小部分 两边都加上单引号。适合写数据库sql in语句 时拼接使用
	 * <pre>
	 * 例如
	 * a 转成'a',
	 * a,b,c 转成'a','b','c'
	 * null或空字符串 转成 ”
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

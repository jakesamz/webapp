package basic.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

/**
 * 为Java类提供更多操作数字的方法
 * @author linjw
 *
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

	@Deprecated
	public static boolean compareFloatNumber(String a, String b) {
		BigDecimal aDem = new BigDecimal(a);
		BigDecimal bDem = new BigDecimal(b);
		return 0 == aDem.compareTo(bDem);
	}
	
	/**
	 * 比较任何两个小数的大小，先保留两位小数，再做比较动作
	 * <p>
	 * <b>关于“著名的” 0.1 + 0.2 != 0.3 问题</b><br>
	 * </p>
	 * <p>
	 * 因为0.1和0.2无法用二进制精确的表示，
	 * <pre>
	 * 0.1(十进制) = 0.0001100110011001(二进制)
	 * 0.2(十进制) = 0.0011001100110011(二进制)
	 * </pre>
	 * 
	 * 所以在计算机运算中，0.1+0.2 = 0.30000000000000004
	 * </p>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean compareDecimalNumber(Number a, Number b) {
		String aStr = formatNumberWithTwoScales(a);
		String bStr = formatNumberWithTwoScales(b);
		return aStr.equals(bStr);
	}
	
	/**
	 * 保留两位小数位数字
	 * 
	 * @param number
	 * @return 含两位小数位数字
	 */
	public static String formatNumberWithTwoScales(Number number) {
		DecimalFormat format = new DecimalFormat("#0.00");
		return format.format(number);
	}
	
	/**
	 * 保留两位小数且含数字分隔符，通过使用<code>#,##0.00</code>格式
	 * 
	 * <pre>
	 * NumberUtils.formatNumber(958412.241) == 958,412.24
	 * </pre>
	 * 
	 * @param number
	 * @return
	 */
	public static String formatNumber(Number number) {
		DecimalFormat format = new DecimalFormat("#,##0.00");  
		return format.format(number);
	}
	
	/**
	 * 百分比形式显示数字，保留两位小数，通过使用<code>#0.00%</code>格式
	 * @param number
	 * @return
	 */
	public static String formatNumberToPercent(Number number) {
		DecimalFormat format = new DecimalFormat("#0.00%");  
		return format.format(number);
	}
	
	
	@Test
	public void test() {
		System.out.println(formatNumberWithTwoScales(0.037));
		System.out.println(compareDecimalNumber(0.1+0.2, 0.3));
		
		System.out.println(formatNumberToPercent(0.36));
		
		
	}
}

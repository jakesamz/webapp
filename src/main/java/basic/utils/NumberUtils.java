package basic.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;

/**
 * ΪJava���ṩ����������ֵķ���
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
	 * �Ƚ��κ�����С���Ĵ�С���ȱ�����λС���������Ƚ϶���
	 * <p>
	 * <b>���ڡ������ġ� 0.1 + 0.2 != 0.3 ����</b><br>
	 * </p>
	 * <p>
	 * ��Ϊ0.1��0.2�޷��ö����ƾ�ȷ�ı�ʾ��
	 * <pre>
	 * 0.1(ʮ����) = 0.0001100110011001(������)
	 * 0.2(ʮ����) = 0.0011001100110011(������)
	 * </pre>
	 * 
	 * �����ڼ���������У�0.1+0.2 = 0.30000000000000004
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
	 * ������λС��λ����
	 * 
	 * @param number
	 * @return ����λС��λ����
	 */
	public static String formatNumberWithTwoScales(Number number) {
		DecimalFormat format = new DecimalFormat("#0.00");
		return format.format(number);
	}
	
	/**
	 * ������λС���Һ����ַָ�����ͨ��ʹ��<code>#,##0.00</code>��ʽ
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
	 * �ٷֱ���ʽ��ʾ���֣�������λС����ͨ��ʹ��<code>#0.00%</code>��ʽ
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

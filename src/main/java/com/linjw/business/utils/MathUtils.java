package com.linjw.business.utils;

import java.math.BigDecimal;

public class MathUtils {
	
	public static Double add(Double val1, Double val2, int scale) {
		if (null == val1) {
			val1 = new Double(0);
		}
		if (null == val2) {
			val2 = new Double(0);
		}
		return new BigDecimal(Double.toString(val1)).add(new BigDecimal(Double.toString(val2)))
				.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double addAll(Double[] vals, int scale) {
		BigDecimal result = new BigDecimal("0");
		for (Double val : vals) {
			if(val == null) continue;
			result = result.add(new BigDecimal(Double.toString(val))).setScale(scale, BigDecimal.ROUND_HALF_UP);
		}
		return result.doubleValue();
	}

	public static Double subtract(Double val1, Double val2, int scale) {
		if (null == val1) {
			val1 = new Double(0);
		}
		if (null == val2) {
			val2 = new Double(0);
		}
		return new BigDecimal(Double.toString(val1)).subtract(new BigDecimal(Double.toString(val2)))
				.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static Double multiply(Double val1, Double val2, int scale) {
		if (null == val1) {
			val1 = new Double(0);
		}
		if (null == val2) {
			val2 = new Double(0);
		}
		return new BigDecimal(Double.toString(val1)).multiply(new BigDecimal(Double.toString(val2)))
				.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static Double divide(Double val1, Double val2, int scale) {
		if (null == val1) {
			val1 = new Double(0);
		}
		if (null == val2 || val2 == 0) {
			val2 = new Double(1);
		}
		return new BigDecimal(Double.toString(val1)).divide(new BigDecimal(Double.toString(val2)))
				.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

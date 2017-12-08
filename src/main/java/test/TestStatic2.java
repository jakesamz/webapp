package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;


public class TestStatic2 {

	public static void main(String[] args) {
		
		//testDecimalFormat();
		//new TestStatic2().print();
		//new TestStatic2().print("with arg");
		
		/*new TestStatic2().multi();
		new TestStatic2().multi("with arg");
		new TestStatic2().multi("with arg", 1, "wtf");*/
		List<String> list = new ArrayList<String>();
		list.add("Capex");
		list.add("Opex");
		list.add("Capex");
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		System.out.println(set.size());
	}
	
	public void multi(Object ...objects){
		for (Object object : objects) {
			System.out.print(object + ",");
		}
		System.out.println();
	}
	
	public void print(){
		System.out.println("default");
	}
	
	public void print(String arg){
		System.out.println(arg);
	}
	
	
	
	public static void testDecimalFormat(){
		/*DecimalFormat format = new DecimalFormat("#0.00");   
		System.out.println(format.format(958412.241));  
		
		format = new DecimalFormat("#,##0.00");   
		System.out.println(format.format(958412.241));
		
		format.applyPattern("#0.00%");   
		System.out.println(format.format(0.23));   
		
		NumberFormat fm = NumberFormat.getInstance(Locale.getDefault());
		if(fm instanceof DecimalFormat){
			((DecimalFormat) fm).setDecimalSeparatorAlwaysShown(true);
		}*/
		
		/*Double i = 1500000.0d;
		Double i2 = 24.9d;
		System.out.println(i);
		System.out.println(i2);
		BigDecimal i3 = new BigDecimal(String.valueOf(i)).add(new BigDecimal(String.valueOf(i2)));
		System.out.println(new BigDecimal(String.valueOf(i+i2)) );
		System.out.println(new BigDecimal(String.valueOf(i3)) );
		
		
		BigDecimal amountSum = new BigDecimal(0);
		BigDecimal totalTax = new BigDecimal(0d);
		BigDecimal zero = new BigDecimal(0d);
			amountSum.add( new BigDecimal(String.valueOf(24.05d)));
			totalTax.add(new BigDecimal(String.valueOf(24.05d)));
			System.out.println(amountSum);
			System.out.println(totalTax);
			
			BigDecimal totalAmount = new BigDecimal(0);  
			totalAmount = totalAmount.add(new BigDecimal("5000"));  
			System.out.println(totalAmount);  
			System.out.print(new String("1") ==new String("1") );
System.out.println("1" == new String("1"));
String s = "1";
s = new String("2");
System.out.println(s);*/
		
		/*Double i = 1500000.0d;
		Double i2 = 67830.49d;
		System.out.println(new BigDecimal(i));
		System.out.println(new BigDecimal(i2));
		BigDecimal i3 = new BigDecimal(String.valueOf(i)).add(new BigDecimal(String.valueOf(i2)));
		System.out.println(new BigDecimal(i) );
		System.out.println(new BigDecimal(String.valueOf(i2)) );*/
		
		BigDecimal amountSum = new BigDecimal(0);
		
		amountSum = amountSum.add(new BigDecimal(String.valueOf(27138.74)));
		amountSum = amountSum.add(new BigDecimal(String.valueOf(753130.68)));
		amountSum = amountSum.add(new BigDecimal(String.valueOf(5169.28)));
		amountSum = amountSum.add(new BigDecimal(String.valueOf(420004.25)));
		System.out.println(amountSum);
		
		String s = null;
		String b = "b" + s;
		System.out.println(b);
		
		int i = 838860822;
		System.out.println(i);
		
		float f = 0.2f;
		System.out.println(f);
		
		double d = 9503599627370496d;
		System.out.println(d);
		
		System.out.println(0.1 + 0.2);
		
		double d1 = 0.1;
		double d2 = 0.2;
		double d3 = 0.3;
		System.out.println(0.1 + 0.2 == 0.3);
		
		System.out.println(
				new Double(d3).compareTo(new Double(d1) + new Double(0.2)));
		
		BigDecimal bd1 = new BigDecimal(String.valueOf(0.1));
		BigDecimal bd2 = new BigDecimal(String.valueOf(0.2));
		
		BigDecimal bd3 = new BigDecimal(String.valueOf(0.3));
		
		bd1 = bd1.add(bd2);
		System.out.println("bd1.compareTo(bd3) = " + bd1.compareTo(bd3));
		
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.1)));  
		
		System.out.println(equals(0.1+0.2, 0.3));;
		
		BigDecimal bd11 = new BigDecimal(String.valueOf(0.1));
		BigDecimal bd21 = new BigDecimal(String.valueOf(0.2));

		BigDecimal bd31 = new BigDecimal(String.valueOf(0.3));

		bd1 = bd11.add(bd21);
		System.out.println("bd1.compareTo(bd3) = " + bd1.compareTo(bd31));
	}
	
	public static boolean equals(double a, double b){
		BigDecimal bd1 = new BigDecimal(String.valueOf(a));
		BigDecimal bd2 = new BigDecimal(String.valueOf(b));
		return bd1.compareTo(bd2) == 0;
	}
	
	
	//public abstract void parse();
}

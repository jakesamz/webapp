package basic.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;

public class Test {

	public static void main(String[] args) throws IOException {
		
		String inputFileName = "data.txt";
		//String outputFileName = "data-after.txt";
		String currentFilePath = Test.class.getResource("").getPath();
		
		BufferedReader bufReader = new BufferedReader(
				new FileReader(currentFilePath + inputFileName));

		//BufferedWriter bw = new BufferedWriter(new FileWriter(currentFilePath + outputFileName));
		
		String tableName = "PRODUCT";
		String valueString = null;
		
		while ((valueString = bufReader.readLine()) != null) {
			/*String sub1 = valueString.substring(0, valueString.indexOf(","));
			String sub2 = valueString.substring(valueString.indexOf("_") + 1, valueString.indexOf(","));
			sub1 = String.format("%-30s", sub1);
			System.out.println(sub1 + tableName + "." + sub2 + "%TYPE,");*/
			format(valueString);
		}

		bufReader.close();
	}
	
	public static void format(String rowValue) {
		String copy = rowValue.substring(2);
		System.out.println(rowValue);
		System.out.println(copy);
	}

}

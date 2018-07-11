package basic.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		
		Properties pros = new Properties();
		
		InputStream is = TestProperties.class.getResourceAsStream("this.properties");
		
		pros.load(is);
		
		System.out.println(pros.getProperty("name"));
		
		System.out.println(pros.getProperty("age"));
		
		System.out.println(pros.getProperty("address"));
		
		is.close();
		
		pros.clear();
		
		InputStream is2 = TestProperties.class.getResourceAsStream("../io/this.properties");
		
		pros.load(is2);
		
		System.out.println(pros.getProperty("name"));
		
		System.out.println(pros.getProperty("age"));
		
		System.out.println(pros.getProperty("address"));
		
	}
	

}

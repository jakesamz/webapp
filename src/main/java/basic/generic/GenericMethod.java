package basic.generic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class GenericMethod {
	
	
	public <T> void test(T a) {
		
		System.out.println(a.getClass().getName());
		
	}
	
	public static void main(String[] args) {
		
		GenericMethod gm = new GenericMethod();
		
		gm.test("a");
		
	}
	
	public String pageSearch (String country){
		if("中国韩国日本".contains(country)) {
			return "亚洲";
		}
		return "";
	}
	

}
                                                                             
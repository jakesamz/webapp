package basic.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class StringListJoinWithSeparator {
	
	public static void main(String[] args) {
		
		List<String> strlist = new ArrayList<>();
		
		strlist.add("abc");
		strlist.add("def");
		strlist.add("ghi");
		
		/*System.out.println(str.toString());
		
		System.out.println(str.toArray());;
		
		System.out.println(str.toArray());*/
		System.out.println(StringUtils.join(strlist, "-"));;
		
		
		//Objects.toString("123", "");
	}
	

}

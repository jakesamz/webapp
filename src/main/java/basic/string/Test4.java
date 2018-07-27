package basic.string;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.internal.SessionFactoryImpl;

public class Test4 {

    public static void main(String args[]) {
        
    	String[] strarr = new String[] {"a","b","c"};
    	
    	for (int i = 0; i < strarr.length; i++) {
			String string = StringUtils.wrap(strarr[i], "','");
			System.out.println(string);
		}
    	System.out.println(StringUtils.join(strarr, "','"));;
    	;
    	System.out.println(StringUtils.wrap(StringUtils.join(strarr, "','"), "'"));
    	
    }
}

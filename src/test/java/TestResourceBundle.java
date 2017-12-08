import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.orm.hibernate3.HibernateTemplate;


public class TestResourceBundle {

	
	public static void main(String[] args) throws UnsupportedEncodingException {
        
		printMessage(Locale.getDefault());
		
		printMessage(new Locale("zh", "CN"));
		
		printMessage(new Locale("en", "US"));
		new String("xxx".getBytes("ISO-8859-1"), "UTF-8");
	}
	
	public static void printMessage(Locale locale) {
		ResourceBundle resb3 = ResourceBundle.getBundle("errormsg", locale); 
        System.out.println(resb3.getString("error.register.phoneDoesNotExist")); 
	}
	
	
	
}

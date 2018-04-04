package webmvc;

import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class TestSpringWebMVC extends TestSuperClass{
	
	@Test
	public void test(){
		System.out.println("success");
	}

}

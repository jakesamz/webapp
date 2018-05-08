package webmvc;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/spring-context-test.xml","/spring-web-mvc-config-test.xml",
		"/spring-redis.xml"
		})
public class TestSuperClass extends AbstractJUnit4SpringContextTests {
	

}

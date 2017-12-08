import java.util.HashMap;

public class SpringRequestMappingTest {

	public static void main(String[] args) {
		
		SpringRequestMapping srm = new SpringRequestMapping();
		
		srm.scanRequestMappings(Controller.class);
		//模拟前端表单的参数
		HashMap<String, Object> formParams = new HashMap<String, Object>();
		formParams.put("username", "admin");
		formParams.put("password", "123456");
		
		srm.executeRequest(Controller.class, "getinfo", formParams);
		srm.executeRequest(Controller.class, "getinfo2", formParams);
	}
}
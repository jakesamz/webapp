
public class Controller {

	@RequestMapping(value="getinfo")
	public String getInfo(String username, String password) {
		System.out.println("execute getInfo");
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		return "";
	}
	
	@RequestMapping(value="getinfo2")
	public String getInfo2(String username, String randomArg) {
		System.out.println("execute getInfo2");
		System.out.println("username = " + username);
		System.out.println("randomArg = " + randomArg);
		return "";
	}
	
	public String getInfo3() {
		System.out.println("execute getInfo3");
		return "";
	}
	
}

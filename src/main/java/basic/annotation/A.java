package basic.annotation;

@MyAnno(value="new value is xxx")
public class A {

	@AnnoMethod(value="value")
	public String getValue() {
		return "";
	}
	
	
}

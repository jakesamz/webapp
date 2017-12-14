package basic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestMyAnno {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		Class<A> clazz = A.class;
		clazz.isAnnotationPresent(MyAnno.class);
		Annotation[] annotations = clazz.getAnnotations();
		System.out.println(annotations.length);
		for (Annotation annotation : annotations) {
			if(annotation instanceof MyAnno) {
				System.out.println(annotation.getClass().getName());
				MyAnno anno = (MyAnno)annotation;
				System.out.println(anno.value());
			}
		}
		
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(AnnoMethod.class)) {
				AnnoMethod am = method.getAnnotation(AnnoMethod.class);
				System.out.println(am.value());
			}
		}
		
	}

}

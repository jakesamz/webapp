package basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//works when runtime
@Target(ElementType.TYPE)//works on class or interface...
public @interface MyAnno {

	public String value() default "";
	
}

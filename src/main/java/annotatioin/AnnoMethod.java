package com.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//works when runtime
@Target(ElementType.METHOD)//works on class or interface...
public @interface AnnoMethod {

	public String value() default "";
	
}

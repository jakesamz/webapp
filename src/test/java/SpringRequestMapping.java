import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

public class SpringRequestMapping {

	private static HashMap<String, Method> uriMethodMap = new HashMap<String, Method>();
	/**
	 * 扫描含有RequestMapping注解的方法，并将uri和对应的方法存储起来
	 * @param clazz
	 */
	public void scanRequestMappings(Class<?> clazz) {
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for(Method method : methods) {
			if (method.isAnnotationPresent(RequestMapping.class)) {
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
				uriMethodMap.put(rm.value(), method);
			}
		}
	}
	
	/**
	 * 利用Spring的类LocalVariableTableParameterNameDiscoverer得到方法参数名，并将相应的参数值注入到RequestMapping的方法中
	 * @param method
	 * @param formParams
	 * @return 
	 */
	public Object[] getParamsToBePassed(Method method, HashMap<String, Object> formParams) {
		
		LocalVariableTableParameterNameDiscoverer discover = new LocalVariableTableParameterNameDiscoverer();
		
		String[] methodParams = discover.getParameterNames(method);
		
		ArrayList<Object> paramsToBePassed = new ArrayList<Object>();
		
		for (String methodParam : methodParams) {
			Set<String> formParamKeys = formParams.keySet();
			
			//和表单里匹配的参数则相应设置值，不匹配的参数将默认设置为空值
			if(formParamKeys.contains(methodParam)) {
				paramsToBePassed.add(formParams.get(methodParam));
			}else {
				paramsToBePassed.add(null);
			}
		}
		return paramsToBePassed.toArray();
	}
	
	
	/**
	 * ，将Form表单的参数注入方法中。接着利用放射机制执行请求
	 * @param clazz
	 * @param uri
	 * @param formParams
	 */
	public void executeRequest(Class<?> clazz, String uri, HashMap<String, Object> formParams) {
		
		Method method = uriMethodMap.get(uri);
		
		Object[] paramsToBePassed = getParamsToBePassed(method, formParams);
		
		try {
			method.invoke(clazz.newInstance(), paramsToBePassed);
		} catch (Exception e) {
		}
	}
	

}
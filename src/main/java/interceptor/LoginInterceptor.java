package interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		System.out.println("RequestURI = " + request.getRequestURI());;
		if(user == null){//只要访问的页面时还用户未登录，则一律重定向至登录页面。（我们已经在配置中排除了对登录的拦截）
			System.out.println("have not logged in yet...");
			response.sendRedirect(request.getContextPath() + "/login?url="+request.getRequestURI());
		}else{
			System.out.println("logged in...");
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

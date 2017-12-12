package interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��¼������
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		System.out.println("RequestURI = " + request.getRequestURI());;
		if(user == null){//ֻҪ���ʵ�ҳ��ʱ���û�δ��¼����һ���ض�������¼ҳ�档�������Ѿ����������ų��˶Ե�¼�����أ�
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

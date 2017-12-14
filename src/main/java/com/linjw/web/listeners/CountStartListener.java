package com.linjw.web.listeners;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.linjw.business.beans.Test;


public class CountStartListener extends HttpServlet implements
		ServletContextListener {
	private static final long serialVersionUID = 1824920962239905170L;

	
	public CountStartListener() {
		// TODO Auto-generated constructor stub
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent arg0) {
		/*ServletContext sc = arg0.getServletContext();
		XmlWebApplicationContext wapp = (XmlWebApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		String str1 = (String) wapp.getBean("auditAspect");
		Test testanno = wapp.getBean(Test.class);
		testanno.getTestAnno();
		//AbstractRefreshableWebApplicationContext arWebAppCtx = wapp.getBean(AbstractRefreshableWebApplicationContext.class);
		Log logger = LogFactory.getLog(CountStartListener.class);
		logger.info("-----------");
		logger.debug("-----------");
		logger.error("-----------");
		System.out.println(wapp.getConfigLocations());;
		System.out.println("str1 = " + str1);
		System.out.println(sc.getContextPath());;
		System.out.println(sc.getRealPath(""));;
		System.out.println(sc.getInitParameter("asdfsadf"));;
		System.out.println(sc.getInitParameterNames());;
		Enumeration<?> e = sc.getInitParameterNames();
		while(e.hasMoreElements()){
			String str = e.nextElement().toString();
			System.out.println(str);
			System.out.println(sc.getInitParameter(str));
		}
		System.out.println(sc.toString());;
		System.out.println("contextInitialized");*/
		ResourceBundle bundle = ResourceBundle.getBundle("errormsg");
		
		Log logger = LogFactory.getLog(CountStartListener.class);
		//logger.info(bundle.getString("error.register.phoneDoesNotExist"));
		//try {
			//logger.info(new String(bundle.getString("error.register.UserNameDoesNotExist").getBytes("ISO8859-1"),"UTF-8"));
		//} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//int i = 1/0;
		ServletContext sc = arg0.getServletContext();
		try {
			logger.info("sc.getResource('').getPath() = " + sc.getResource("").getPath());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("sc.getRealPath('') = " + sc.getRealPath(""));
		XmlWebApplicationContext wapp = (XmlWebApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		SessionFactory str1 = (SessionFactory) wapp.getBean("sessionFactory");
		
		
	}
}
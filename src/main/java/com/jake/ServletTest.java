package com.jake;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class ServletTest extends HttpServlet {

	Log logger = LogFactory.getLog(ServletTest.class);
	
	 @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		logger.info("test: init() servlet");
		logger.info("getServletName: " + getServletName());
	}
	 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		logger.info("test: destroy() servlet");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
		logger.info("test: doDelete() servlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		logger.info("test: doGet() servlet");
		//resp.getWriter().print("asdf");
		//req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
		resp.sendRedirect("WEB-INF/views/welcome.jsp");
	}

	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(arg0, arg1);
		logger.info("test: doHead() servlet");
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, arg1);
		logger.info("test: doOptions() servlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		logger.info("test: doPost() servlet");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
		logger.info("test: doPut() servlet");
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
		logger.info("test: doTrace() servlet");
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		logger.info("test: getLastModified() servlet");
		return super.getLastModified(req);
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		logger.info("test: protected service() servlet");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("test: public service() servlet");
		super.service(arg0, arg1); 
	}
	
	
	
}

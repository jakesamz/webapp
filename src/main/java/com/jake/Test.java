package com.jake;


import java.io.IOException;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.JavaScriptUtils;
import org.springframework.web.util.WebUtils;



@Controller
public class Test implements org.springframework.web.servlet.mvc.Controller{

	public static String getValue(boolean only, boolean fiveYears){
		String value = "";
		if(only && fiveYears){
			return "免征";
		}
		if(only && !fiveYears){
			return "only && !fiveYears";
		}
		if(!only && fiveYears){
			return "!only && fiveYears";
		}
		if(!only && !fiveYears){
			return "!only && !fiveYears";
		}
		return value;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Test() {
	}
	
	@RequestMapping("/newFile")
	public String newFile(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("-------------:" + getRequestUri(req));
		req.setAttribute("testValue", "a\"bc");
		//System.out.println("sessionFactory:" + sessionFactory.openSession().getNamedQuery(""));
		//TAdmin a = (TAdmin) sessionFactory.getCurrentSession().get(TAdmin.class, 1);
		//int i = 1/0;
		String nu = null;
		//nu.toCharArray();
		return "NewFile";
	}
	
	@RequestMapping("/form")
	public String form(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("-------------:" + getRequestUri(req));
		req.setAttribute("testValue", "a\"bc");
		//System.out.println("sessionFactory:" + sessionFactory.openSession().getNamedQuery(""));
		//TAdmin a = (TAdmin) sessionFactory.getCurrentSession().get(TAdmin.class, 1);
		//int i = 1/0;
		String nu = null;
		//nu.toCharArray();
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("url", req.getParameter("url"));
		return "login";
	}
	
	@RequestMapping("/dologin")
	public void dologin(String username, HttpServletRequest req, HttpServletResponse resp) throws JsonGenerationException, JsonMappingException, IOException {
		req.getSession().setAttribute("user", "thisUser");
		JSONObject json = new JSONObject();
		json.accumulate("flag", true);
		resp.getWriter().print(json.toString());
	}
	
	@RequestMapping("/signout")
	public String signout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("-------------:" + getRequestUri(req));
		req.setAttribute("testValue", "a\"bc");
		//System.out.println("sessionFactory:" + sessionFactory.openSession().getNamedQuery(""));
		//TAdmin a = (TAdmin) sessionFactory.getCurrentSession().get(TAdmin.class, 1);
		//int i = 1/0;
		req.getSession().removeAttribute("user");
		//nu.toCharArray();
		resp.getWriter().print(new String().toString());
		return null;
	}
	
	private static String getRequestUri(HttpServletRequest request) {
		String uri = (String) request.getAttribute(WebUtils.INCLUDE_REQUEST_URI_ATTRIBUTE);
		if (uri == null) {
			uri = request.getRequestURI();
		}
		return uri;
	}
	
	public String getSql(){
		String sql = "select * from dual";
		return sql;
	}
	
	public String getCountSql(){
		String sql = "select count(*) from dual";
		return sql;
	}
	
	
	private static Logger logger=Logger.getLogger(Test.class);
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		/*int a = -1;
		if(a == -1){}
		
		System.out.println("1<<3 = " + (1<<3));*/
		//Date date = new Date(1499875200000l);
		//System.out.println(date.toString());
		/*char a; a='t';
		String str = "test'test";
		String str1 = str.replaceAll("\'","\\\\'");
		System.out.println(str1);
		System.out.println("\\'");
		System.out.println(a);*/
		//System.out.println(getStrWithEnclosure("abc"));;
		/*try{
			StringUtils.join(new Object[]{}, "'");
			//logger.error("", new Exception());
		}catch(Exception w){
			System.out.println("--asdfsdf-");
		}
		String s = "CMI-1234";
		String t =s.substring(4);
		System.out.println(t);
		System.out.println(JavaScriptUtils.javaScriptEscape("ss\r"));;
		
		System.out.println("2017".equals(2017));*/
		/*String t = null;
		new Test().a(t);
		
		new Test().getNo(new GenerateNo(){

			@Override
			public String generate() {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		BigDecimal aDouble =new BigDecimal(0.1);

        System.out.println("construct with a double value: " + aDouble);

        BigDecimal aString = new BigDecimal("1.22");
         System.out.println("construct with a String value: " + aString);*/

		/*Number n = 0.1;
		
		Float f =  Float.valueOf(9.86f);
		f =f*100;
		Float result = f.floatValue();

		System.out.println(result);
		
		new SimpleDateFormat("yyyymmdd").format(null);*/
		System.out.println("1200.00");
		BigDecimal aDouble =new BigDecimal(2.5);
		System.out.println(aDouble);
		
		Socket socket = new Socket();
	}
	
	public String getNo(GenerateNo gn){
		return gn.generate();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	}
	
	
	public void a(String str){
		System.out.println(str);
	}
	
	public void a(Integer i){
		System.out.println(i);
	}
	
	public static String getStrWithEnclosure(String str, char separator){
	    if(StringUtils.isBlank(str)) {
	        return StringUtils.EMPTY;
	    }
	    return StringUtils.join(("'" + str + "'").split(","),"','");
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("welcome");
	}
	
}

interface GenerateNo{
	public String generate();
}

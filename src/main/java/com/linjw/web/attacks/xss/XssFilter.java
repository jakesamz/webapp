package com.linjw.web.attacks.xss;

import org.apache.commons.text.StringEscapeUtils;

/**
 * <p>
 * What is Xss?
 * Xss(跨站脚本攻击)是攻击者通过向web网站中植入恶意的脚本代码，并欺骗程序执行恶意脚本达到窃取用户数据的一种攻击过程。
 * <p>
 * 植入的方法一般是发生在填写form表单的时候。执行恶意代码发生在服务器重新渲染界面时。
 * 比如攻击者在form表单中的input标签输入一段script代码，浏览器提交该段代码到服务器后，服务器重新将该段返回浏览器时渲染html时会执行该段恶意代码。
 * 典型的比如搜索功能。
 * 
 * <p>
 * Protection预防方法：
 * 当数据需要返回浏览器端渲染时，需要将其进行编码过滤
 * @author linjw
 *
 */

public class XssFilter {

	public static String escapeHtml4(String input){
		return StringEscapeUtils.escapeHtml4(input);
	}
	
}

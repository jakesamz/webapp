package com.linjw.web.attacks.xss;

import org.apache.commons.text.StringEscapeUtils;

/**
 * <p>
 * Protection预防方法：
 * 从服务器端发送到浏览器端的数据需要进行编码或过滤
 * @author linjw
 *
 */

public class XssFilter {

	/**
	 * 编码或过滤Html4相关符号
	 * @param input
	 * @return
	 */
	public static String escapeHtml4(String input){
		return StringEscapeUtils.escapeHtml4(input);
	}
	
}

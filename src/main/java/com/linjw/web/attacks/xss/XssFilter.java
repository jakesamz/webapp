package com.linjw.web.attacks.xss;

import org.apache.commons.text.StringEscapeUtils;

/**
 * <p>
 * ProtectionԤ��������
 * �ӷ������˷��͵�������˵�������Ҫ���б�������
 * @author linjw
 *
 */

public class XssFilter {

	/**
	 * ��������Html4��ط���
	 * @param input
	 * @return
	 */
	public static String escapeHtml4(String input){
		return StringEscapeUtils.escapeHtml4(input);
	}
	
}

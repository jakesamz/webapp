package com.linjw.web.attacks.xss;

import org.apache.commons.text.StringEscapeUtils;

/**
 * <p>
 * What is Xss?
 * Xss(��վ�ű�����)�ǹ�����ͨ����web��վ��ֲ�����Ľű����룬����ƭ����ִ�ж���ű��ﵽ��ȡ�û����ݵ�һ�ֹ������̡�
 * <p>
 * ֲ��ķ���һ���Ƿ�������дform����ʱ��ִ�ж�����뷢���ڷ�����������Ⱦ����ʱ��
 * ���繥������form���е�input��ǩ����һ��script���룬������ύ�öδ��뵽�������󣬷��������½��öη��������ʱ��Ⱦhtmlʱ��ִ�иöζ�����롣
 * ���͵ı����������ܡ�
 * 
 * <p>
 * ProtectionԤ��������
 * ��������Ҫ�������������Ⱦʱ����Ҫ������б������
 * @author linjw
 *
 */

public class XssFilter {

	public static String escapeHtml4(String input){
		return StringEscapeUtils.escapeHtml4(input);
	}
	
}

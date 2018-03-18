package com.linjw.business.user.findpwd;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SystemParams {

	@Autowired
	PropertiesFactoryBean bean;
	
	public String getValue(String key) {
		try {
			Object value = bean.getObject().get(key);
			return value == null ? null : value.toString();
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public String getValue(String key, Object...params) {
		return MessageFormat.format(this.getValue(key), params);
	}
	
}

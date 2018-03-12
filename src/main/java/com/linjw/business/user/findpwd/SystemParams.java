package com.linjw.business.user.findpwd;

import java.io.IOException;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SystemParams {

	@Autowired
	PropertiesFactoryBean bean;
	
	public String getValue(String key) throws IOException {
		Object value = bean.getObject().get(key);
		return value == null ? null : value.toString();
	}
	
	public String getValue(String key, Object...params) throws IOException {
		return MessageFormat.format(this.getValue(key), params);
	}
	
}

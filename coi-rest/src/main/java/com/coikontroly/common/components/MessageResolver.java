package com.coikontroly.common.components;

import javax.annotation.Resource;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageResolver {

	@Resource(name="messageSource")
	private ReloadableResourceBundleMessageSource messageSource;

	@Resource(name="settingSource")
	private ReloadableResourceBundleMessageSource settingSource;

	public String getMessage(String key, Object... args) {
		return messageSource.getMessage(key, args, null);
	}

	public String getSetting(String key, Object... args) {
		return settingSource.getMessage(key, args, null);
	}
}

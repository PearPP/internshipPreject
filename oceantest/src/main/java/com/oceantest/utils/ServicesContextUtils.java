package com.oceantest.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oceantest.configuration.PersistenceJPAConfig;

public class ServicesContextUtils {
	static private AnnotationConfigApplicationContext context; 
	
	static{
		context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
	}
	
	static public Object getBean(String name) throws BeansException {
		return context.getBean(name);
	}

	static public <T> T getBean(Class<T> requiredType) throws BeansException {
		return context.getBean(requiredType);
	}
	
	static public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		return context.getBean(name, requiredType);
	}
	
	static public AnnotationConfigApplicationContext getContext(String name) throws Exception {
		return context;
	}
}

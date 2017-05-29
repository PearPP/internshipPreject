package com.oceantest.utils;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class WSConnectionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getService(final Class<T> clazz, String address) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(clazz);
		factory.setAddress(address);
		return (T) factory.create(); 
	}
}

package com.oceantest.utils;

import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class RestTempletePutUtils {
	
	public abstract String url();
	public abstract Map<String,Object> methodUrlVariables();
	public abstract MultiValueMap<String,String> methodPostParam();

	protected void run(){
		RestTemplate rest=new RestTemplate();
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String,String>> entity=new HttpEntity<MultiValueMap<String, String>>(methodPostParam(), headers);
		if(methodUrlVariables()==null){
			rest.put(url(), entity);
		}else{
			rest.put(url(), entity, methodUrlVariables());
		}
	} 
}

package com.oceantest.utils;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public abstract class RestTempleteGetUtils {

	public abstract String url();
	public abstract Map<String,Object> methodUrlVariables();

	public <T> T getData(Class<T> requiredType){
		String result = run();
		if(StringUtils.isBlank(result)||StringUtils.trimToEmpty(result).toLowerCase().equals("null")){
			return null;
		}else{
			return new Gson().fromJson(result, requiredType);
		}
	}
	
	//new TypeToken<List<OceanBean>>(){}.getType()
	public <T> T getData(Type type){
		String result = run();
		if(StringUtils.isBlank(result)||StringUtils.trimToEmpty(result).toLowerCase().equals("null")){
			return null;
		}else{
			return new Gson().fromJson(result, type);
		}
	}
	
	protected String run(){
		RestTemplate rest=new RestTemplate();
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		if(methodUrlVariables()==null){
			return rest.getForObject(url(), String.class);
		}else{
			return rest.getForObject(url(), String.class, methodUrlVariables());
		}
		
	} 
}

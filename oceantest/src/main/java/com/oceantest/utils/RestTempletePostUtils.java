package com.oceantest.utils;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public abstract class RestTempletePostUtils extends RestTempleteGetUtils{
	
	/*
	 * RestTemplate rt = new RestTemplate();

		// Create a multimap to hold the named parameters
		MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String,String>();
		parameters.add("username", marshalRequest(usernameObj));
		parameters.add("password", marshalRequest(passwordObj));
		
		// Create the http entity for the request
		HttpEntity<MultiValueMap<String,String>> entity =
		            new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
		
		// Get the response as a string
		String response = rt.postForObject(endpoint, entity, String.class);
		
		// Unmarshal the response back to the expected object
		MyReturnObj obj = (MyReturnObj) unmarshalResponse(response);
	 */
	
	public abstract MultiValueMap<String,String> methodPostParam();
	
	
	@Override
	protected String run(){
		RestTemplate rest=new RestTemplate();
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MultiValueMap<String,String>> entity=new HttpEntity<MultiValueMap<String, String>>(methodPostParam(), headers);
		if(methodUrlVariables()==null){
			return rest.postForObject(url(), entity, String.class);
		}else{
			return rest.postForObject(url(), entity, String.class, methodUrlVariables());
		}
		
	} 
}

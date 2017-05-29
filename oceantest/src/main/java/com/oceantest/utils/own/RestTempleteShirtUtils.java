package com.oceantest.utils.own;

import java.util.Map;

import com.oceantest.utils.RestTempleteGetUtils;

public class RestTempleteShirtUtils extends RestTempleteGetUtils{

	private String URL_SHIRT="http://192.168.1.72:9004/oceantest/rest/";
	
	private String URL_METHOD=null;

	@Override
	public String url() {
		return String.format("%s%s", URL_SHIRT,URL_METHOD);
	}

	@Override
	public Map<String, Object> methodUrlVariables() { return null; }
	
	
	/*
	List<Map<String, Object>> shirtTest = new RestTempleteGetUtils() {
			public String url() {
				return "http://192.168.1.72:9004/oceantest/rest/shirtrest/shirt/jpa/";
			}

			public Map<String, Object> methodUrlVariables() {
				// TODO Auto-generated method stub
				return null;
			}
		}.getData(new TypeToken<List<Map<String, Object>>>() {
		}.getType());
	 * */
	
	public RestTempleteShirtUtils shirtJpa(){
		this.URL_METHOD="shirtrest/shirt/jpa/";
		return this;
	}
	
	public RestTempleteShirtUtils shirtJpa2(){
		this.URL_METHOD="shirtrest/shirt/jpa2/";
		return this;
	}
	

}

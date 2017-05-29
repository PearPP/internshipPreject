package com.oceantest.services.rest.service.shirt.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.reflect.TypeToken;
import com.oceantest.services.rest.service.shirt.ShirtRestService;
import com.oceantest.utils.own.RestTempleteShirtUtils;


@Service("shirtRestService")
@Transactional
public class ShirtRestServiceImpl implements ShirtRestService{
	
//	@Override
	public List<Map<String, Object>> aaa(){
		
//		List<Map<String, Object>> shirtTest = new RestTempleteGetUtils() {
//			public String url() {
//				return "http://192.168.1.72:9004/oceantest/rest/shirtrest/shirt/jpa/";
//			}
//
//			public Map<String, Object> methodUrlVariables() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		}.getData(new TypeToken<List<Map<String, Object>>>() {
//		}.getType());
//		
//		return shirtTest;
		
		RestTempleteShirtUtils utils= new RestTempleteShirtUtils();
		return utils.shirtJpa().getData(new TypeToken<List<Map<String, Object>>>() {}.getType());
	} 

}

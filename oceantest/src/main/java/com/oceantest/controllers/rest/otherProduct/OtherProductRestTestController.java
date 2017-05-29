package com.oceantest.controllers.rest.otherProduct;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.reflect.TypeToken;
import com.oceantest.services.pant.service.PantService;
import com.oceantest.utils.RestTempleteGetUtils;

@RestController
@RequestMapping(value = "/testProduct")
public class OtherProductRestTestController {

	@Autowired
	private PantService pantService;
	
	@Autowired
	private PantService ShirtRestService;

	@RequestMapping(value = "/shirt/", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> showAllShirt() {
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
		return new ResponseEntity<List<Map<String, Object>>>(shirtTest, HttpStatus.OK);
	}

	@RequestMapping(value = "/shoes/", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> showAllShoes() {
		List<Map<String, Object>> shoesTest = new RestTempleteGetUtils() {
			public String url() {
				return "http://192.168.1.67:9004/oceantest/rest/mytest/product/";
			}

			public Map<String, Object> methodUrlVariables() {
				// TODO Auto-generated method stub
				return null;
			}
		}.getData(new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		return new ResponseEntity<List<Map<String, Object>>>(shoesTest, HttpStatus.OK);
	}

}

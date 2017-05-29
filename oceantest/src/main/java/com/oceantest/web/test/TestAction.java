package com.oceantest.web.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.reflect.TypeToken;
import com.oceantest.services.jpa.model.PantEntity;
//import org.springframework.web.servlet.ModelAndView;
import com.oceantest.utils.RestTempleteGetUtils;

@Controller
@RequestMapping("/test")
public class TestAction {

	@Autowired
	private com.oceantest.services.jpa.service.PantJpaService pantService;

	@RequestMapping("/index")
	public String test() {
		return "test";
	}
	@RequestMapping("/home")
	public String home(ModelMap model){
		return "home";
	}
	
	@RequestMapping("/pant")
	public ModelAndView pantListPage() throws Exception {
		ModelAndView pantList = new ModelAndView("pantList");
		List<PantEntity> pants = pantService.findAll();
		pantList.addObject("pants", pants);
		return pantList;
	}

	@RequestMapping("/shoes")
	public ModelAndView shoesListPage() throws Exception {
		ModelAndView shoesList = new ModelAndView("shoesList");
		List<Map<String, Object>> shoesTest = new RestTempleteGetUtils() {
			@Override
			public String url() {
				return "http://localhost:9004/oceantest/rest/testProduct/shoes/";
			}
			@Override
			public Map<String, Object> methodUrlVariables() {
				// TODO Auto-generated method stub
				return null;
			}					
		}.getData(new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		shoesList.addObject("shoesTest", shoesTest);

		return shoesList;
	}
	
	@RequestMapping("/shirt")
	public ModelAndView shirtListPage() throws Exception {
		ModelAndView shirtList = new ModelAndView("shirtList");
		List<Map<String, Object>> shirtTest = new RestTempleteGetUtils() {
			@Override
			public String url() {
				return "http://localhost:9004/oceantest/rest/testProduct/shirt/";
			}
			@Override
			public Map<String, Object> methodUrlVariables() {
				// TODO Auto-generated method stub
				return null;
			}					
		}.getData(new TypeToken<List<Map<String, Object>>>() {
		}.getType());
		shirtList.addObject("shirtTest", shirtTest);

		return shirtList;
	}
	
	
}

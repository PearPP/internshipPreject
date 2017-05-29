package com.oceantest.controllers.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;

import com.oceantest.controllers.ws.OceanTestWsService;
import com.oceantest.services.pant.model.Pant;
import com.oceantest.services.pant.service.PantService;
import com.oceantest.services.service.UserService;

@SuppressWarnings("restriction")
@WebServlet(name = "OceanTestWsService", urlPatterns = "/ws/oceantestwsservice")
@WebService(endpointInterface = "com.oceantest.controllers.ws.OceanTestWsService")
public class OceanTestWsServiceImpl implements OceanTestWsService {

	@Autowired
	UserService userService; // Service which will do all data
								// retrieval/manipulation work

	@Autowired
	PantService pantService;
								
//	@Override
	public List<Pant> testmsg(long msg) {
		List<Pant> pantList = new ArrayList<Pant>();

		Pant aa = new Pant();
		aa.setBrand("aaaaa");
		aa.setId(5);
		aa.setPrice(4000);
		aa.setTest(4);
//		aa.getBrand();
//		aa.getId();
//		aa.getPrice();
//		aa.getTest();
		
		

		pantList.add(aa);

		return pantList;

	}

}
package com.oceantest.controllers.ws.pant.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;

import com.oceantest.controllers.ws.pant.PantWsService;
import com.oceantest.services.jpa.model.PantEntity;
import com.oceantest.services.jpa.service.PantJpaService;
import com.oceantest.utils.ServicesContextUtils;

@SuppressWarnings("restriction")
@WebServlet(name = "PantWsService", urlPatterns = "/ws/pantwsservice")
@WebService(endpointInterface = "com.oceantest.controllers.ws.pant.PantWsService")

public class PantWsServiceImpl implements PantWsService {
	PantJpaService pantJpaService = ServicesContextUtils.getBean(PantJpaService.class);

	// ------- get all pant -------
	public List<PantEntity> showAllJpaPant() {
		List<PantEntity> pants = new ArrayList<PantEntity>();
		try {
			pants = pantJpaService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pants;

	}

	// ------- get single pant by id -------
	public PantEntity findById(long id) {
		PantEntity pant = null;
		try {
			pant = pantJpaService.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pant;
	}

	// ------- get single pant by brand -------
	public List<PantEntity> findByBrand(String brand) {
		List<PantEntity> pants = new ArrayList<PantEntity>();
		pants = pantJpaService.findByBrand(brand);
		return pants;
	}

}

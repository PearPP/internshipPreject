package com.oceantest.controllers.ws.shoes.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;

import com.oceantest.controllers.ws.Exception_Exception;
import com.oceantest.controllers.ws.ProductEntity;
import com.oceantest.controllers.ws.ProductWsService;
import com.oceantest.controllers.ws.shoes.ShoesWsService;
import com.oceantest.utils.WSConnectionUtils;

@SuppressWarnings("restriction")
@WebServlet(name = "ShoesWsService", urlPatterns = "/ws/shoeswsservice")
@WebService(endpointInterface = "com.oceantest.controllers.ws.shoes.ShoesWsService")

public class ShoesWsServiceImpl implements ShoesWsService {
	ProductWsService shoesService = WSConnectionUtils.getService(ProductWsService.class,
			"http://127.0.0.1:9010/oceantestws/WSDL/shoe_productwsservice.xml");

	// ------- show all shoes -------
	public List<ProductEntity> showAllWsShoes() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		try {
			products = shoesService.findAll();
			// System.out.println("==WWWWWWW=> " + new
			// Gson().toJson(shoesService.findAll()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<ProductEntity> findById(int id) {
		List<ProductEntity> product = null;
		try {
			product = shoesService.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	public List<ProductEntity> findByBrand(String brand, String name) {
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		try {
			products = shoesService.findByBrand(brand, name);
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	// -------

}

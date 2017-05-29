package com.oceantest.controllers.ws.shoes;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.oceantest.controllers.ws.ProductEntity;

@SuppressWarnings("restriction")
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL) 
public interface ShoesWsService {

	
	@WebMethod
	public List<ProductEntity> showAllWsShoes();
	

	@WebMethod
	List<ProductEntity> findById(int id);
	
	@WebMethod
	List<ProductEntity> findByBrand(String brand, String name);
}

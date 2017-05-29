package com.oceantest.controllers.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.oceantest.services.pant.model.Pant;

@SuppressWarnings("restriction")
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface OceanTestWsService {

	
	@WebMethod 
	List<Pant> testmsg(long msg);
}

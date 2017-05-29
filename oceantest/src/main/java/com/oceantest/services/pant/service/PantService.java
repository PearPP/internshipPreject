package com.oceantest.services.pant.service;

import java.util.List;

import com.oceantest.services.pant.model.Pant;

public interface PantService {
	
	void createPant(Pant pant);
	
	List<Pant> findAllPant(); 
	Pant findById(long id);	
	Pant findByBrandName(String brand);	
	
	void updatePant(Pant pant);
	
	void deletePantById(long id);
	void deleteAllPant();
	
	public boolean isPantExist(Pant pant);

}

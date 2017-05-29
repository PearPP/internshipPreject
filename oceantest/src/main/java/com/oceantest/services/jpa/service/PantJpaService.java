package com.oceantest.services.jpa.service;

import java.util.List;

import com.oceantest.services.jpa.model.PantEntity;

public interface PantJpaService {

	public List<PantEntity> findAll() throws Exception;

	void create(PantEntity pant);

	void updatePant(PantEntity pant);

	void deletePantById(long id);

	public PantEntity findById(long id) throws Exception;

	public List<PantEntity> findByBrand(String brand);

}

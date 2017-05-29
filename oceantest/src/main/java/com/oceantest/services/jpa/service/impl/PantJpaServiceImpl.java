package com.oceantest.services.jpa.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oceantest.services.jpa.model.PantEntity;
import com.oceantest.services.jpa.service.PantJpaService;

@Service("pantJpaService")
//@Repository
@Transactional
//@Transactional(readOnly = false)
public class PantJpaServiceImpl implements PantJpaService {


	@PersistenceContext
	private EntityManager entityManager;

	public List<PantEntity> findAll() throws Exception {
		return entityManager.createNamedQuery("PantEntity.findAll", PantEntity.class).getResultList();
	}

	public PantEntity findById(long id) throws Exception {
		return entityManager.find(PantEntity.class, id);
	}
	
	public List<PantEntity> findByBrand(String brand) {
		return entityManager.createNamedQuery("PantEntity.findBrand", PantEntity.class).setParameter("brand", brand).getResultList();
//		return null;
	}

	public void create(PantEntity pant) {
		// pant.setId(counter.incrementAndGet());
		entityManager.persist(pant);
//		 System.out.println("pant.setId = "+ pant.getId());
	}

	public void updatePant(PantEntity pant) {
		entityManager.merge(pant);
	}

	public void deletePantById(long id) {
		entityManager.remove(entityManager.find(PantEntity.class, id));
	}

	
}

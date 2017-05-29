package com.oceantest.services.jpa.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oceantest.services.jpa.model.TransactionEntity;
import com.oceantest.services.jpa.service.TransactionService;

@Service("TransactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<TransactionEntity> findTransactionAll() {
		return entityManager.createNamedQuery("TransactionEntity.findAll", TransactionEntity.class).getResultList();
	}

	public void create(TransactionEntity trans) {
		entityManager.persist(trans);
	}

}

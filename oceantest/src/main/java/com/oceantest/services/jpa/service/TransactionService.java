package com.oceantest.services.jpa.service;

import java.util.List;

import com.oceantest.services.jpa.model.TransactionEntity;

public interface TransactionService {

	public List<TransactionEntity> findTransactionAll();

	public void create(TransactionEntity trans);
}

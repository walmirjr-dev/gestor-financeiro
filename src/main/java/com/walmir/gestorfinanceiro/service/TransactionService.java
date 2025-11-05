package com.walmir.gestorfinanceiro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;
import com.walmir.gestorfinanceiro.domain.model.Transaction;
import com.walmir.gestorfinanceiro.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repository;

	public List<Transaction> findAllFiltered(
			String title,
			Long categoryId,
			TransactionType type,
			LocalDate startDate,
			LocalDate endDate,
			Double minValue,
			Double maxValue
			) {
		return repository.filter(title, categoryId, type, startDate, endDate, minValue, maxValue);
	}

	public Transaction findbyId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No transaction found in Id: " + id));
	}

	public Transaction insert(Transaction object) {
		return repository.save(object);
	}

	public Transaction update(Transaction newEntity, Long id) {
		Transaction entity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No transaction found in Id: " + id));
		updateData(entity, newEntity);

		return repository.save(entity);
	}

	public void deleteById(Long id) {
		if (!repository.existsById(id)) {
	        throw new RuntimeException("No transaction found in Id: " + id);
	    }

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	private void updateData(Transaction entity, Transaction newEntity) {
		entity.setTitle(newEntity.getTitle());
		entity.setType(newEntity.getType());
		entity.setDate(newEntity.getDate());
		entity.setAmount(newEntity.getAmount());
		entity.setCategory(newEntity.getCategory());
	}

	public double getBalance(Long userId) {

		List<Transaction> transactions = repository.findByUserId(userId);

		double balance = 0;

		for (Transaction t : transactions) {
			if(t.getType() == TransactionType.INCOME) {
				balance += t.getAmount();
			} else {
				balance -= t.getAmount();
			}
		}

		return balance;
	}

}

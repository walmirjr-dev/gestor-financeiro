package com.walmir.gestorfinanceiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmir.gestorfinanceiro.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByUserId(Long userId);

}

package com.walmir.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmir.gestorfinanceiro.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

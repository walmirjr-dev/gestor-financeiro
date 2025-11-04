package com.walmir.gestorfinanceiro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;
import com.walmir.gestorfinanceiro.domain.model.Transaction;
import com.walmir.gestorfinanceiro.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@Mock
	TransactionRepository repository;

	@InjectMocks
	TransactionService service;

	@Test
	void getBalanceShouldReturnSumOfTransactions() {
		Long userId = 1L;

		Transaction t1 = new Transaction(1L, "Income", TransactionType.INCOME, Instant.now(), 200.00, null);
		Transaction t2 = new Transaction(2L, "Expense", TransactionType.EXPENSE, Instant.now(), 100.00, null);

		when(repository.findByUserId(userId))
	        .thenReturn(Arrays.asList(t1, t2));

	    double balance = service.getBalance(userId);

	    assertEquals(100.00, balance, 0.001);
	}

}

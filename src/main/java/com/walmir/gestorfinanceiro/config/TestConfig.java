package com.walmir.gestorfinanceiro.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;
import com.walmir.gestorfinanceiro.domain.model.Category;
import com.walmir.gestorfinanceiro.domain.model.Transaction;
import com.walmir.gestorfinanceiro.domain.model.User;
import com.walmir.gestorfinanceiro.repository.CategoryRepository;
import com.walmir.gestorfinanceiro.repository.TransactionRepository;
import com.walmir.gestorfinanceiro.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Jonas", "jonasmail.com", "123455");
		User u2 = new User(null, "Josias", "josiasmail.com", "123456");

		Category c1 = new Category(null, "Education");
		Category c2 = new Category(null, "Salary");

		Transaction t1 = new Transaction(null, "Salario mes 10", TransactionType.INCOME, LocalDate.now(), 3200.00, c2);
		Transaction t2 = new Transaction(null, "curso", TransactionType.EXPENSE, LocalDate.now(), 200.00, c1);

		t1.setUser(u2);
		t2.setUser(u2);

		c1.setUser(u2);
		c2.setUser(u2);

		userRepository.saveAll(Arrays.asList(u1, u2));
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		transactionRepository.saveAll(Arrays.asList(t1, t2));
	}

}

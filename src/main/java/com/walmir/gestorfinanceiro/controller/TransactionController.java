package com.walmir.gestorfinanceiro.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;
import com.walmir.gestorfinanceiro.domain.model.Transaction;
import com.walmir.gestorfinanceiro.service.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@GetMapping
	public ResponseEntity<List<Transaction>> findAllFiltered(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) Long categoryId,
		    @RequestParam(required = false) TransactionType type ,
		    @RequestParam(required = false) LocalDate startDate,
		    @RequestParam(required = false) LocalDate endDate,
		    @RequestParam(required = false) Double minValue,
		    @RequestParam(required = false) Double maxValue)
	{

		System.out.println("Keyword recebida: '" + title + "'");
		List<Transaction> list = service.findAllFiltered(title, categoryId, type, startDate, endDate, minValue, maxValue);

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Transaction> findById(@PathVariable Long id) {
		Transaction entity = service.findbyId(id);

		return ResponseEntity.ok().body(entity);
	}

	@PostMapping
	public ResponseEntity<Transaction> insert (@RequestBody Transaction entity) {
		Transaction newEntity = service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(newEntity);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Transaction> update (@PathVariable Long id, @RequestBody Transaction newEntity) {
		Transaction entity = service.update(newEntity, id);
		return ResponseEntity.ok().body(entity);
	}

	@GetMapping(value = "/balance/{userId}")
	public ResponseEntity<Double> getBalance (@PathVariable Long userId) {
		Double balance = service.getBalance(userId);

		return ResponseEntity.ok().body(balance);
	}

}

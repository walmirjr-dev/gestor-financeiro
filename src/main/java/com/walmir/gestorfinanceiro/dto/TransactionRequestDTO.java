package com.walmir.gestorfinanceiro.dto;

import java.time.LocalDate;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;

public record TransactionRequestDTO(
	String title,
	TransactionType type,
	Long categoryId,
	LocalDate date,
	Double amount
) {}

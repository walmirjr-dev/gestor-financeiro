package com.walmir.gestorfinanceiro.dto;

import java.time.LocalDate;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;

public record TransactionResponseDTO(
	Long id,
	String title,
	TransactionType type,
	Long categoryId,
	LocalDate date,
	Double amount
) {}

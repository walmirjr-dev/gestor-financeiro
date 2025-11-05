package com.walmir.gestorfinanceiro.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.walmir.gestorfinanceiro.domain.enums.TransactionType;
import com.walmir.gestorfinanceiro.domain.model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByUserId(Long userId);

	@Query("""
		SELECT t FROM Transaction t
		WHERE (:title IS NULL OR LOWER(TRIM(t.title)) LIKE LOWER(CONCAT('%', :title, '%')))
		AND (:categoryId IS NULL OR t.category.id = :categoryId)
		AND (:type IS NULL OR t.type = :type)
		AND (:startDate IS NULL OR t.date >= :startDate)
		AND (:endDate IS NULL OR t.date <= :endDate)
		AND (:minValue IS NULL OR t.amount >= :minValue)
		AND (:maxValue IS NULL OR t.amount <= :maxValue)
	""")
	List<Transaction> filter(
		@Param("title") String title,
		@Param("categoryId") Long categoryId,
		@Param("type") TransactionType type,
		@Param("startDate") LocalDate startDate,
		@Param("endDate") LocalDate endDate,
		@Param("minValue") Double minValue,
		@Param("maxValue") Double maxValue
		);

}

package com.walmir.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmir.gestorfinanceiro.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

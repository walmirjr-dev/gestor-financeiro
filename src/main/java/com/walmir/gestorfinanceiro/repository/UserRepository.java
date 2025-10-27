package com.walmir.gestorfinanceiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmir.gestorfinanceiro.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

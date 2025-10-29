package com.walmir.gestorfinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.walmir.gestorfinanceiro.domain.model.User;
import com.walmir.gestorfinanceiro.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findbyId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No user found in Id: " + id));
	}

	public User insert(User object) {
		return repository.save(object);
	}

	public User update(User newEntity, Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No user found in Id: " + id));
		updateData(entity, newEntity);

		return repository.save(entity);
	}

	public void deleteById(Long id) {
		if (!repository.existsById(id)) {
	        throw new RuntimeException("No user found in Id: " + id);
	    }

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	private void updateData(User entity, User newEntity) {
		entity.setEmail(newEntity.getEmail());
		entity.setName(newEntity.getName());
		entity.setPassword(newEntity.getPassword());
	}

}

package com.walmir.gestorfinanceiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.walmir.gestorfinanceiro.domain.model.Category;
import com.walmir.gestorfinanceiro.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findbyId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No category found in Id: " + id));
	}

	public Category insert(Category object) {
		return repository.save(object);
	}

	public Category update(Category newEntity, Long id) {
		Category entity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No category found in Id: " + id));
		updateData(entity, newEntity);

		return repository.save(entity);
	}

	public void deleteById(Long id) {
		if (!repository.existsById(id)) {
	        throw new RuntimeException("No category found in Id: " + id);
	    }

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	private void updateData(Category entity, Category newEntity) {
		entity.setName(newEntity.getName());
	}

}

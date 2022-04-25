package com.raghu.receipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.raghu.receipe.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);

}

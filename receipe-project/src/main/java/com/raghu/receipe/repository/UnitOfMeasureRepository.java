package com.raghu.receipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.raghu.receipe.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{
	Optional<UnitOfMeasure> findByDescription(String description);
}

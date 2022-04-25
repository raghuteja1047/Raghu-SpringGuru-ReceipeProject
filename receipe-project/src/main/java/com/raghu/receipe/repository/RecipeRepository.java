package com.raghu.receipe.repository;

import org.springframework.data.repository.CrudRepository;

import com.raghu.receipe.model.Recipe;

public interface RecipeRepository  extends CrudRepository<Recipe, Long>{

}

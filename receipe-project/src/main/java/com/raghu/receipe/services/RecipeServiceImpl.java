package com.raghu.receipe.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.raghu.receipe.model.Recipe;
import com.raghu.receipe.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	public Set<Recipe> getRecipes() {
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}
}

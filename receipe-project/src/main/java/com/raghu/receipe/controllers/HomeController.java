package com.raghu.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raghu.receipe.repository.CategoryRepository;
import com.raghu.receipe.repository.RecipeRepository;
import com.raghu.receipe.repository.UnitOfMeasureRepository;

@Controller
public class HomeController {

	RecipeRepository recipeRepository;
	CategoryRepository categoryRepository;
	UnitOfMeasureRepository measureRepository;

	public HomeController(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureRepository measureRepository) {
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.measureRepository = measureRepository;
	}

	@RequestMapping("/")
	private String getHomePage() {
		return "index";
	}

}

package com.raghu.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raghu.receipe.services.RecipeService;

@Controller
public class RecipeController {
	
	private final RecipeService recipeService ;
		
	public RecipeController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}


	@RequestMapping(value = {"recipes/index" ,"/recipes"} )
	public String getRecipes(Model model) {
		System.out.println();
		model.addAttribute("recipes", recipeService.getRecipes());
		return "recipes/index";
	}
}

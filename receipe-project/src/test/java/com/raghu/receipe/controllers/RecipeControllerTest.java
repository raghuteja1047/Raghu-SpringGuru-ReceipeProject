package com.raghu.receipe.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.raghu.receipe.model.Recipe;
import com.raghu.receipe.services.RecipeService;
class RecipeControllerTest {

	RecipeController controller;
	@Mock
	RecipeService service;
	@Mock
	Model model;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new RecipeController(service);
	}	

	@Test
	void testMockMvc() throws Exception {
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/recipes")).andExpect(status().isOk()).andExpect(view().name("recipes/index"));
		assertEquals(1, 1);
	}
	
	@Test
	void testGetRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		
		when(service.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		String indexPage = controller.getRecipes(model);
		assertEquals(indexPage, "recipes/index");	
		verify(service, times(1)).getRecipes();
		verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
		Set<Recipe> resultRecipes = argumentCaptor.getValue();
		System.out.println("...After invocation #"+resultRecipes.size());

		assertEquals(resultRecipes.size(), 1);
	}

}

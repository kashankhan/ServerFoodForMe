package de.tum.in.foodforme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeDAO;
import de.tum.in.foodforme.model.Recipe;

@Controller
@RequestMapping("/rest/recipe")
public class RestRecipe {

	private static final String URL = "http://api.bigoven.com/recipe/47725?api_key=dvx3yd92dN1feo7ywI9bT5M50708VrCq";
	private final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Recipe get(@PathVariable("id") int rId) {
		Recipe recipe = recipeDAO.getRecipe(rId);
		if(recipe!=null){
			return recipe;
		}
		else {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			RestTemplate restTemplate = new RestTemplate();
			String t = "http://api.bigoven.com/recipe/" + rId + "?api_key=dvx3yd92dN1feo7ywI9bT5M50708VrCq";
			HttpEntity<String> response = restTemplate.exchange(t, HttpMethod.GET, entity, String.class);
			Gson gson = new Gson();
			Recipe r = gson.fromJson(response.getBody(), Recipe.class);
			recipeDAO.save(r);
			return r;
		}
	}
}

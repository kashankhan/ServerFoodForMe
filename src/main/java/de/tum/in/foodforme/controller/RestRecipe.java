package de.tum.in.foodforme.controller;

import java.util.List;

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

	private static final String bigOvenApiKey = "dvx3yd92dN1feo7ywI9bT5M50708VrCq";
	private static final String bigOvenBaseUri = "http://api.bigoven.com";
	private final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	
	@RequestMapping(value = "/recipedetail/{recipeId}", method = RequestMethod.GET)
	public @ResponseBody Recipe get(@PathVariable("recipeId") int recipeId) {
		Recipe recipe = recipeDAO.getRecipe(recipeId);
		if(recipe == null){
			recipe = new Recipe();
			recipe.createRecipe();
			recipeDAO.save(recipe);
		 // recipe = fetchRecipe(recipeId);
		}
		return recipe;
	}
	
	@RequestMapping(value = "/searchrecipes/{keyword}", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> get(@PathVariable("keyword") String keyword) {
		List<Recipe> recipes = (List<Recipe>)recipeDAO.getRecipes(keyword);
		if(recipes.isEmpty()){
			//recipes = searchRecipes(keyword);
		}
		return recipes;
	}
	
	
	private Recipe fetchRecipe(int recipeId) {
		String uri =  bigOvenBaseUri + "/recipe/" + recipeId + "?api_key=" + bigOvenApiKey;
		String requestBody = sendRequst(uri);
		Gson gson = new Gson();
		Recipe recipe = gson.fromJson(requestBody, Recipe.class);
		recipeDAO.save(recipe);
		return recipe;
	}
	
	private List<Recipe> searchRecipes(String keyword) {
		String uri =  bigOvenBaseUri + "/recipe/" + keyword + "?api_key=" + bigOvenApiKey;
		String requestBody = sendRequst(uri);
		Gson gson = new Gson();
		List<Recipe> recipes = (List<Recipe>)gson.fromJson(requestBody, Recipe.class);
		for (Recipe recipe : recipes) {
			recipeDAO.save(recipe);
		}
		return recipes;
	}
	
	private String sendRequst(String uri) {		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		return response.getBody();

	}
	
//	private Recipe sendRequestTest(String recipeId) {
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		RestTemplate restTemplate = new RestTemplate();
//		String t = "http://api.bigoven.com/recipe/" + recipeId + "?api_key=dvx3yd92dN1feo7ywI9bT5M50708VrCq";
//		HttpEntity<String> response = restTemplate.exchange(t, HttpMethod.GET, entity, String.class);
//		Gson gson = new Gson();
//		Recipe r = gson.fromJson(response.getBody(), Recipe.class);
//		recipeDAO.save(r);
//		return r;
//		
//	}
}

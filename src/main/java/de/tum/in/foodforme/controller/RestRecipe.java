package de.tum.in.foodforme.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.bal.RecipeBAL;
import de.tum.in.foodforme.bal.RecipeBALManger;
import de.tum.in.foodforme.constants.GlobalConstants.RecipeBalType;
import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeDAO;
import de.tum.in.foodforme.model.Ingredient;
import de.tum.in.foodforme.model.Recipe;

@Controller
@RequestMapping("/rest/recipe")
public class RestRecipe {

	private final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	private final RecipeBAL recipeBAL = RecipeBALManger.createRecipeBAL(RecipeBalType.BIG_OVEN);

	@RequestMapping(value="/recipedetail")
	@ResponseBody
	public Recipe recipedetail(@RequestParam("recipeId") Integer recipeId){
		Recipe recipe = recipeDAO.getRecipe(recipeId);
		if(recipe == null || recipe.getInstructions() == null || recipe.getInstructions().isEmpty()){
			recipe = recipeBAL.fetchRecipe(recipeId);
		}
		return recipe;
	}


	@RequestMapping(value="/searchrecipes")
	@ResponseBody
	public List<Recipe> searchRecipes(@RequestParam("keyword") String keyword, 
			@RequestParam(value="page", required=true) Integer page,
			@RequestParam(value="resultPerPage", required=true) Integer resultPerPage){
		List<Recipe> recipes = (List<Recipe>)recipeDAO.getRecipes(keyword, page, resultPerPage);
		if(recipes.isEmpty()){
			recipes = recipeBAL.searchRecipes(keyword, page, resultPerPage);
		}
		return recipes;

	}
	
	
	@RequestMapping(value = "/sysnrecipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Recipe> syncRecipes(){
		List<Recipe> sycnRecipes = new ArrayList<Recipe>();
		List<Recipe> recipes = (List<Recipe>)recipeDAO.getUnSyncRecipes();
		for(Iterator<Recipe> r = recipes.iterator(); r.hasNext(); ) {
			Recipe recipe = r.next();
			if(recipe == null || recipe.getInstructions() == null || recipe.getInstructions().isEmpty()){
				Recipe syncRecipe = recipeBAL.fetchRecipe(recipe.getRecipeId());
				sycnRecipes.add(syncRecipe);
			}
		}
		return sycnRecipes;
				
	}
	
}

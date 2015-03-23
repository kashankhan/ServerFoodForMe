package de.tum.in.foodforme.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.tum.in.foodforme.model.Ingredient;
import de.tum.in.foodforme.model.Recipe;
import de.tum.in.foodforme.model.UserIngredientPreference;
import de.tum.in.foodforme.model.UserRecipeTimePreference;

public class RecipeRecommendationDAO {

	final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();

	final UserRecipeTimePreferenceDAO recipeTimePreferenceDAO = DAOManager.createUserRecipeTimePreferenceDAO();
	final UserIngredientPreferenceDAO ingredientPreferenceDAO = DAOManager.createUserIngredentPreferenceDAO();
	final UserRecipeTimePreferenceDAO timePreferenceDAO  = DAOManager.createUserRecipeTimePreferenceDAO();
	
	public List<Recipe> getUserRecipeRecommendation(String userId) {
		return getUserRecommendation(userId);
	}

	private List<Recipe> getUserRecommendation(String userId) {
		List<Recipe> recipes = null;
		List<UserIngredientPreference> likeIngredientPreferences = getUserIngredients(userId, true);
		List<UserIngredientPreference> dislikeIngredientPreferences = getUserIngredients(userId, false);
		Integer threshold = 10;
		//Check if the user favorite recipe list is empty recommend popular recipes. 
		if(dislikeIngredientPreferences.isEmpty() && likeIngredientPreferences.isEmpty()) {
			recipes = getPopularRecipes(threshold);
		}
		else {	
			recipes = getRecommendations(userId, likeIngredientPreferences, dislikeIngredientPreferences, threshold);
//			if(recipes.isEmpty() || recipes.size() < threshold) {
//				Integer resultSize = threshold - recipes.size();
//				recipes.addAll(getPopularRecipes(resultSize));
//			}
		}
		
		return recipes;
	}
	
	private List<Recipe> getPopularRecipes(Integer resultSize){
		return recipeDAO.getPopularUniqueRecipes(resultSize);
	}
	
	private List<UserIngredientPreference>getUserIngredients(String userId, boolean favorite) {
		return ingredientPreferenceDAO.findAll(userId, favorite);
		
	}
	
	List<String>filterDistincIngredientsName(List<UserIngredientPreference> preferences){
		List<String>ingredients = new ArrayList<String>();
		String ingredient = "";
		for(Iterator<UserIngredientPreference> u = preferences.iterator(); u.hasNext(); ) {
			UserIngredientPreference uip = u.next();
			ingredient = uip.getIngredient().toLowerCase();
			if(!ingredients.contains(ingredient)) {
				ingredients.add(ingredient);
			}
		}
		return ingredients;
	}
	
	List<Ingredient>getIngredients(List<String>ingredientsName) {
		List<Ingredient>ingredients = new ArrayList<Ingredient>();
		for(Iterator<String> i = ingredientsName.iterator(); i.hasNext(); ) {
			String keyword = i.next();
			ingredients.addAll(recipeDAO.getIngredients(keyword));
		}
		return ingredients;
	}
	
	Integer getUserPreferRecipeTime(String userId) {
		Integer perferTiming = 0;
		List<UserRecipeTimePreference> list = timePreferenceDAO.findAll(userId);
		if(!list.isEmpty()) {
			UserRecipeTimePreference preference = list.get(0);
			perferTiming = preference.getPerferTiming();
		}
		
		return perferTiming;
	}
	
	List<Recipe>getPerferRecipes(List<String>likeIngredients){
		List<Recipe> recipes = new ArrayList<Recipe>();
		List<Ingredient> ingredients = getIngredients(likeIngredients);
		for(Iterator<Ingredient> i = ingredients.iterator(); i.hasNext(); ) {
			Ingredient ingredient = i.next();
			Recipe recipe = recipeDAO.getRecipe(ingredient.getRecipeId());
			if(!recipes.contains(recipe)) {
				recipes.add(recipe);
			}
		}
		return recipes;
	}
	
	List<Recipe>getRecommendations(String userId, List<UserIngredientPreference>likeIngredientPreferences, List<UserIngredientPreference>dislikeIngredientPreferences, Integer maxRecommendation){
		List<String>likeIngredientsName = filterDistincIngredientsName(likeIngredientPreferences);
		List<String>dislikeIngredientsName = filterDistincIngredientsName(dislikeIngredientPreferences);
		Integer preferCookingTime = getUserPreferRecipeTime(userId);
		List<Recipe>recommendedRecipes = new ArrayList<Recipe>();
		List<Recipe>recipes = getPerferRecipes(likeIngredientsName);
		Integer counter = 0;
		for(Iterator<Recipe> r = recipes.iterator(); r.hasNext(); ) {
			Recipe recipe = r.next();
			if(matchUserTaste(recipe, dislikeIngredientsName, preferCookingTime)) {
				recommendedRecipes.add(recipe);
				counter++;
				if(counter == maxRecommendation)
					break;
			}
		}
		return recommendedRecipes;
	}
	
	boolean matchUserTaste(Recipe recipe, List<String>dislikeIngredientsName, Integer preferCookingTime) {
		boolean tasteMatches = true;
		preferCookingTime = 90;
		if(preferCookingTime > 0) {
			tasteMatches = (recipe.getTotalMinutes() <= preferCookingTime);		
		}
		for(Iterator<Ingredient> i = recipe.getIngredients().iterator(); i.hasNext(); ) {
			Ingredient ingredient = i.next();
			if(tasteMatches) {
				for(Iterator<String> d = dislikeIngredientsName.iterator(); d.hasNext(); ) {
					String name = d.next();
					if((name.toLowerCase().contains(ingredient.getName().toLowerCase())) 
							|| (ingredient.getName().toLowerCase().contains(name.toLowerCase()))){
						tasteMatches = false;
						break;
					}
				}
			}
			else {
				break;
			}
		}
		return tasteMatches;
	}
}

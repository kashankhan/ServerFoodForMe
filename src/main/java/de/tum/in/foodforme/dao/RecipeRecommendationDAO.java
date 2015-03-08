package de.tum.in.foodforme.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.tum.in.foodforme.model.Recipe;
import de.tum.in.foodforme.model.UserFavoriteRecipe;
import de.tum.in.foodforme.recommendation.ReicpesRecommendationGenerator;

public class RecipeRecommendationDAO {

	final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	final UserFavoriteRecipeDAO favoriteRecipeDAO = DAOManager.createUserFavoriteRecipeDAO();
	final UserProfileDAO userProfileDAO = DAOManager.createUserProfileDAO();
	final ReicpesRecommendationGenerator reicpesRecommendationGenerator = new ReicpesRecommendationGenerator();
	
	public List<Recipe> getUserRecipeRecommendation(String userId) {
		return getUserRecommendation(userId);
	}
	
	private List<Recipe> getUserRecommendation(String userId) {
		List<Recipe> recipes = null;
		List<UserFavoriteRecipe> favoriteList = getUserFavoriteRecipes(userId);
		Integer threshold = 10;
		//Check if the user favorite recipe list is empty recommend popular recipes. 
		if(favoriteList.isEmpty()) {
			recipes = getPopularRecipes();
		}
		else {	
			List<UserFavoriteRecipe> userFavoriteRecipes = getUserFavoriteRecipes(userId);
			List<UserFavoriteRecipe> otherUserFavoriteRecipes = getAllUserFavoriteRecipesExpcept(userId);
			List<Integer>recipesId = reicpesRecommendationGenerator.generateRecommendations(userId, userFavoriteRecipes, otherUserFavoriteRecipes);
			recipes = getRecipes(recipesId, threshold);
			if(recipes.isEmpty() || recipes.size() < threshold) {
				recipes.addAll(getPopularRecipes());
			}
		}
		
		return recipes;
	}
	private List<Recipe> getPopularRecipes(){
		return recipeDAO.getPopularUniqueRecipes();
	}
	
	private List<UserFavoriteRecipe> getUserFavoriteRecipes(String userId) {
		return favoriteRecipeDAO.findAll(userId);
	}
	
	private List<UserFavoriteRecipe> getAllUserFavoriteRecipesExpcept(String userId) {
		return favoriteRecipeDAO.findAllExceptUser(userId);
	}
	
	private List<Recipe>getRecipes(List<Integer>recipesId, Integer threshold) {
		int count = 0;
		List<Recipe> recipes = new ArrayList<Recipe>();
		for(Iterator<Integer> r = recipesId.iterator(); r.hasNext(); ) {
			Integer recipeId = r.next();
			Recipe recipe = recipeDAO.getRecipe(recipeId);
			if(recipe != null) {
				recipes.add(recipe);
				count++;
			}
			if (count == threshold) 
				break;
		}
		return recipes;
	}
}

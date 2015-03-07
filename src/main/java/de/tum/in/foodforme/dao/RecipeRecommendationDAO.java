package de.tum.in.foodforme.dao;

import java.util.List;

import de.tum.in.foodforme.model.Recipe;

public class RecipeRecommendationDAO {

	final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	final UserFavoriteRecipeDAO favoriteRecipeDAO = DAOManager.createUserFavoriteRecipeDAO();
	final UserProfileDAO userProfileDAO = DAOManager.createUserProfileDAO();
	
	public List<Recipe> userRecipeRecommendation(String userId) {
		
		return null;
	}
	
	private List<Recipe> popularRecipes(){
		return recipeDAO.getPopularUniqueRecipes();
	}
}

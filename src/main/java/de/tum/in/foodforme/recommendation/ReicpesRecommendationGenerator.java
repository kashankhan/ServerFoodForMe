package de.tum.in.foodforme.recommendation;

import java.util.List;
import de.tum.in.foodforme.model.UserFavoriteRecipe;

public class ReicpesRecommendationGenerator {

	final RecipeRecommendation recipeRecommendation = new RecipeRecommendation();

	public List<Integer> generateRecommendations(String userId, List<UserFavoriteRecipe>userFavoriteRecipes,  List<UserFavoriteRecipe>otherUserFavoriteRecipes) {
		return recipeRecommendation.getRecommendations(userId, userFavoriteRecipes, otherUserFavoriteRecipes);

	}
}

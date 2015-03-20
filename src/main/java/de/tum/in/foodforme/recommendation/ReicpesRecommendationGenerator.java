package de.tum.in.foodforme.recommendation;

import java.util.List;
import de.tum.in.foodforme.model.UserRecipePreference;

public class ReicpesRecommendationGenerator {

	final RecipeRecommendation recipeRecommendation = new RecipeRecommendation();

	public List<Integer> generateRecommendations(String userId, List<UserRecipePreference>userFavoriteRecipes,  List<UserRecipePreference>otherUserFavoriteRecipes) {
		return recipeRecommendation.getRecommendations(userId, userFavoriteRecipes, otherUserFavoriteRecipes);

	}
}

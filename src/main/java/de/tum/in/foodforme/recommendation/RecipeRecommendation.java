package de.tum.in.foodforme.recommendation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import de.tum.in.foodforme.model.UserFavoriteRecipe;

public class RecipeRecommendation extends BaseRecommendation {


	List<Integer> getRecommendations(String userId, List<UserFavoriteRecipe>userFavoriteRecipes, List<UserFavoriteRecipe>otherUserFavoriteRecipes) {
		List<Integer> recipes = new ArrayList<Integer>();
		List<UserFavoriteRecipe>uniqueUserFavoriteRecipe = getUniqueUserFavoriteRecipe(userFavoriteRecipes);
		List<UserFavoriteRecipe>similarTasteUsers = getSimilarTasteUsers(uniqueUserFavoriteRecipe, otherUserFavoriteRecipes);
		if(similarTasteUsers != null && !similarTasteUsers.isEmpty()) {
			List<UserFavoriteRecipe> recomnendedUserFavoriteRecipes = getRecomnendedUserFavoriteRecipes(userFavoriteRecipes, similarTasteUsers);
			if(recomnendedUserFavoriteRecipes != null && !recomnendedUserFavoriteRecipes.isEmpty()) {
				recipes = getRecommendedRecipe(recomnendedUserFavoriteRecipes);
			}
		}
		return recipes;	 
	}		

	private List<UserFavoriteRecipe>getSimilarTasteUsers(List<UserFavoriteRecipe>userFavoriteRecipes, List<UserFavoriteRecipe>otherUserFavoriteRecipes) {
		List<UserFavoriteRecipe> recipes = new ArrayList<UserFavoriteRecipe>();
		for(Iterator<UserFavoriteRecipe> o = otherUserFavoriteRecipes.iterator(); o.hasNext(); ) {
			UserFavoriteRecipe oRecipe = o.next();
			for(Iterator<UserFavoriteRecipe> u = otherUserFavoriteRecipes.iterator(); u.hasNext(); ) {
				UserFavoriteRecipe userFavoriteRecipe = u.next();
				if(userFavoriteRecipe.getIngredient().equalsIgnoreCase(oRecipe.getIngredient()))
					recipes.add(oRecipe);
			}
		}
		return recipes;
	}

	private List<UserFavoriteRecipe>getRecomnendedUserFavoriteRecipes(List<UserFavoriteRecipe>userFavoriteRecipes, List<UserFavoriteRecipe>similarTasteUsers) {
		List<UserFavoriteRecipe> recipes = new ArrayList<UserFavoriteRecipe>();
		for(Iterator<UserFavoriteRecipe> u = similarTasteUsers.iterator(); u.hasNext(); ) {
			UserFavoriteRecipe userFavoriteRecipe = u.next();
			recipes.add(userFavoriteRecipe);
		}
		return recipes;
	}

	List<Integer> getRecommendedRecipe(List<UserFavoriteRecipe>recommendedfavorites) {
		List<Integer> recipes = new ArrayList<Integer>();
		for(Iterator<UserFavoriteRecipe> u = recommendedfavorites.iterator(); u.hasNext(); ) {
			UserFavoriteRecipe userFavoriteRecipe = u.next();
			if(!recipes.contains(userFavoriteRecipe.getRecipeId())) {
				recipes.add(userFavoriteRecipe.getRecipeId());
			}
		}
		return recipes;
	}
	
	private List<UserFavoriteRecipe>getUniqueUserFavoriteRecipe(List<UserFavoriteRecipe>userFavoriteRecipes) {
		List<String>ingredents = new ArrayList<String>();
		List<UserFavoriteRecipe>list = new ArrayList<UserFavoriteRecipe>();
		for(Iterator<UserFavoriteRecipe> u = userFavoriteRecipes.iterator(); u.hasNext(); ) {
			UserFavoriteRecipe userFavoriteRecipe = u.next();
			if(!ingredents.contains(userFavoriteRecipe.getIngredient())) {
				list.add(userFavoriteRecipe);
			}
		}
		return list;
	}
}

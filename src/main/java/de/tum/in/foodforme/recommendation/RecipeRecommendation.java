package de.tum.in.foodforme.recommendation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import de.tum.in.foodforme.model.UserFavoriteRecipe;

public class RecipeRecommendation extends BaseRecommendation {


	List<Integer> getRecommendations(String userId, List<UserFavoriteRecipe>userFavoriteRecipes, List<UserFavoriteRecipe>otherUserFavoriteRecipes) {
		List<Integer> recipes = new ArrayList<Integer>();
		List<UserFavoriteRecipe>uniqueUserFavoriteRecipe = getUniqueUserFavoriteRecipe(userFavoriteRecipes);
		List<String>similarTasteUsers = getSimilarTasteUsers(uniqueUserFavoriteRecipe, otherUserFavoriteRecipes);
		if(similarTasteUsers != null && !similarTasteUsers.isEmpty()) {
			List<UserFavoriteRecipe> recomnendedUserFavoriteRecipes = getRecomnendedUserFavoriteRecipes(otherUserFavoriteRecipes, similarTasteUsers);
			if(recomnendedUserFavoriteRecipes != null && !recomnendedUserFavoriteRecipes.isEmpty()) {
				recipes = getRecommendedRecipe(recomnendedUserFavoriteRecipes);
			}
		}
		return recipes;	 
	}		

	private List<String>getSimilarTasteUsers(List<UserFavoriteRecipe>userFavoriteRecipes, List<UserFavoriteRecipe>otherUserFavoriteRecipes) {
		List<String> users = new ArrayList<String>();
		for(Iterator<UserFavoriteRecipe> o = otherUserFavoriteRecipes.iterator(); o.hasNext(); ) {
			UserFavoriteRecipe oRecipe = o.next();
			for(Iterator<UserFavoriteRecipe> u = userFavoriteRecipes.iterator(); u.hasNext(); ) {
				UserFavoriteRecipe userFavoriteRecipe = u.next();
				if(userFavoriteRecipe.getIngredient().equalsIgnoreCase(oRecipe.getIngredient()) && 
						!users.contains(oRecipe.getUserId()))
					users.add(oRecipe.getUserId());
			}
		}
		return users;
	}

	private List<UserFavoriteRecipe>getRecomnendedUserFavoriteRecipes(List<UserFavoriteRecipe>otherUserFavoriteRecipes, List<String>similarTasteUsers) {
		List<UserFavoriteRecipe> recipes = new ArrayList<UserFavoriteRecipe>();
		for(Iterator<UserFavoriteRecipe> ufr = otherUserFavoriteRecipes.iterator(); ufr.hasNext(); ) {
			UserFavoriteRecipe userFavoriteRecipe = ufr.next();
			for(Iterator<String> u = similarTasteUsers.iterator(); u.hasNext(); ) {
				String userId = u.next();
				if(userId.equalsIgnoreCase(userFavoriteRecipe.getUserId()) && 
						!recipes.contains(userFavoriteRecipe))
					recipes.add(userFavoriteRecipe);
			}
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

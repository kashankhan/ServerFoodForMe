package de.tum.in.foodforme.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class RecommendedRecipe {
	
	private @Getter @Setter Recipe recipe;
	private @Getter @Setter List<String> favoriteIngredientsInRepcie;
	private @Getter @Setter Integer preferCookingTime;
	
	public RecommendedRecipe(Recipe recipe, List<String> likeIngredients, Integer preferCookingTime) {
		this.recipe = recipe;
		this.preferCookingTime = preferCookingTime;
		this.favoriteIngredientsInRepcie = getFavoriteIngredientsInRepcie(likeIngredients);
	}
	
	
	private List<String> getFavoriteIngredientsInRepcie(List<String> likeIngredients) {
		List<String>ingredients = new ArrayList<String>();
		for(Iterator<Ingredient> i = recipe.getIngredients().iterator(); i.hasNext(); ) {
			Ingredient ingredient = i.next();
			for(Iterator<String> n = likeIngredients.iterator(); n.hasNext(); ) {
				String name = n.next();
				if((name.toLowerCase().contains(ingredient.getName().toLowerCase())) 
						|| (ingredient.getName().toLowerCase().contains(name.toLowerCase()))){
					ingredients.add(name);
				}
			}
		}
		return ingredients;
	}
}

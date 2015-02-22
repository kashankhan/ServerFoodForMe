package de.tum.in.foodforme.bal;

import java.util.List;

import de.tum.in.foodforme.model.Recipe;

public abstract class  RecipeBAL extends GeneraicBAL {

	abstract public Recipe fetchRecipe(int recipeId);
	abstract public List<Recipe> searchRecipes(String keyword, Integer page, Integer resultPerPage);
}

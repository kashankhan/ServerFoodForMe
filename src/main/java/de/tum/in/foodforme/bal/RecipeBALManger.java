package de.tum.in.foodforme.bal;

import de.tum.in.foodforme.constants.GlobalConstants.RecipeBalType;


public class RecipeBALManger {

	BigOvenRecipeBAL bigOverRecieBAL = new BigOvenRecipeBAL();
	
	public static RecipeBAL createRecipeBAL(RecipeBalType balType) {
		RecipeBAL recipeBAL;
		switch (balType) {
		case BIG_OVEN:
		default:
			recipeBAL = new BigOvenRecipeBAL();
			break;
		}
		return recipeBAL;
	}
}

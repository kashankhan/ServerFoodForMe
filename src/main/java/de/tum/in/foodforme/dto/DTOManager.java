package de.tum.in.foodforme.dto;

import de.tum.in.foodforme.constants.GlobalConstants.RecipeBalType;

public class DTOManager {

	public static RecipeDTO createRecipeDTO(RecipeBalType balType) {
		RecipeDTO recipeDTO;
		switch (balType) {
		case BIG_OVEN:
		default:
			recipeDTO = new BigOvenRecipeDTO();
			break;
		}
		return recipeDTO;
	}
}

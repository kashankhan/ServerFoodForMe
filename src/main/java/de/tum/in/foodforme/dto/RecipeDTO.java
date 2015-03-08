package de.tum.in.foodforme.dto;

import java.util.List;
import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeDAO;
import de.tum.in.foodforme.model.Recipe;

public abstract class  RecipeDTO extends BaseDTO {

	protected final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	
	abstract public List<Recipe> parseRecipes(String requestBody);
	abstract public Recipe parseRecipeDetail(String requestBody);
	
}

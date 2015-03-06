package de.tum.in.foodforme.bal;

import java.util.List;

import de.tum.in.foodforme.constants.GlobalConstants.RecipeBalType;
import de.tum.in.foodforme.dto.DTOManager;
import de.tum.in.foodforme.dto.RecipeDTO;
import de.tum.in.foodforme.model.Recipe;

public class BigOvenRecipeBAL  extends RecipeBAL {

	public enum ApiKey {
		ONE {
			public String toString() {
				return "dvx3yd92dN1feo7ywI9bT5M50708VrCq";
			}
		},

		TWO {
			public String toString() {
				return "dvx1Q4Ts9FUt8zZorr2KXO1u0s3wCU0i";
			}
		}
		,

		THREE {
			public String toString() {
				return "dvxYzGm1S642ur3foOj587frkxR5xOI0";
			}
		}
	}


	private static final String bigOvenApiKey = ApiKey.ONE.toString();
	private static final String bigOvenBaseUri = "http://api.bigoven.com";
	private static final RecipeDTO recipeDTO = DTOManager.createRecipeDTO(RecipeBalType.BIG_OVEN);

	@Override
	public Recipe fetchRecipe(int recipeId) {
		String uri =  bigOvenBaseUri + "/recipe/" + recipeId + "?api_key=" + bigOvenApiKey;
		String requestBody = this.sendGetRequest(uri);
		Recipe recipe = recipeDTO.parseRecipeDetail(requestBody);
		return recipe;
	}

	@Override
	public List<Recipe> searchRecipes(String keyword, Integer page, Integer resultPerPage) {
		String uri =  bigOvenBaseUri + "/recipes?title_kw=" + keyword + "&pg=" +page + "&rpp=" +resultPerPage +  "&api_key=" + bigOvenApiKey;
		String requestBody = this.sendGetRequest(uri);
		List<Recipe> recipes = recipeDTO.parseRecipes(requestBody);
		return recipes;
	}
}

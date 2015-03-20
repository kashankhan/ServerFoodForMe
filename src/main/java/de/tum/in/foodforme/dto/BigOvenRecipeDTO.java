package de.tum.in.foodforme.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.tum.in.foodforme.model.Ingredient;
import de.tum.in.foodforme.model.IngredientInfo;
import de.tum.in.foodforme.model.NutritionInfo;
import de.tum.in.foodforme.model.Recipe;

public class BigOvenRecipeDTO extends RecipeDTO {

	@Override
	public List<Recipe> parseRecipes(String requestBody) {

		try {
			List<Recipe> recipes = new ArrayList<Recipe>();
			JsonObject response = this.getJsonObject(requestBody);
			JsonArray results =  response.getAsJsonArray("Results");
			for(int i = 0; i < results.size(); i++){ 
				JsonObject recipeInfo = results.get(i).getAsJsonObject(); 
				Recipe recipe = parseRecipe(recipeInfo);
				recipeDAO.save(recipe);
				recipes.add(recipe);
			} 

			return recipes;	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	public Recipe parseRecipeDetail(String requestBody) {

		try {
			JsonObject recipeInfo = this.getJsonObject(requestBody);
			Recipe recipe = parseRecipe(recipeInfo);
			if (recipe != null) {
				recipe.setActiveMinutes(getJsonObjectAsInt(recipeInfo, "ActiveMinutes"));
				recipe.setDescription(getJsonObjectAsString(recipeInfo, "Description"));
				recipe.setPrimaryIngredient(getJsonObjectAsString(recipeInfo, "PrimaryIngredient")); 
				recipe.setTotalMinutes(getJsonObjectAsInt(recipeInfo, "TotalMinutes"));  
				recipe.setYieldNumber(getJsonObjectAsInt(recipeInfo, "YieldNumber"));
				recipe.setYieldUnit(getJsonObjectAsString(recipeInfo, "YieldUnit"));
				recipe.setInstructions(getJsonObjectAsString(recipeInfo, "Instructions"));

				//Nutrition
				JsonObject nutritionResponseInfo = recipeInfo.getAsJsonObject("NutritionInfo");
				NutritionInfo nutritionInfo = parseNutritionInfo(nutritionResponseInfo);
				recipe.setNutritionInfo(nutritionInfo);

				//Ingredient
				List<Ingredient> ingredients = new ArrayList<Ingredient>();
				JsonArray results =  recipeInfo.getAsJsonArray("Ingredients");
				for(int i = 0; i < results.size(); i++){ 
					JsonObject ingredientInfo = results.get(i).getAsJsonObject(); 
					Ingredient ingredient = parseIngredient(ingredientInfo, recipe.getRecipeId());
					ingredients.add(ingredient);
				} 
				recipe.setIngredients(ingredients);

				recipeDAO.save(recipe);
			}
			return recipe;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private Recipe parseRecipe(JsonObject recipeInfo) {
		Recipe recipe = null;
		int recipeId = recipeInfo.get("RecipeID").getAsInt();
		if (recipeId > 0) {
			recipe = recipeDAO.getRecipe(recipeId);
			if(recipe == null) {
				recipe = new Recipe();
			}
			recipe.setRecipeId(recipeId);
			recipe.setTitle(getJsonObjectAsString(recipeInfo, "Title"));
			recipe.setStarRating(getJsonObjectAsInt(recipeInfo, "StarRating"));
			recipe.setCategory(getJsonObjectAsString(recipeInfo, "Category"));
			recipe.setSubcategory(getJsonObjectAsString(recipeInfo, "Subcategory"));
			recipe.setCuisine(getJsonObjectAsString(recipeInfo, "Cuisine"));
			recipe.setIsBookmark(getJsonObjectAsBoolean(recipeInfo, "IsBookmark"));
			recipe.setReviewCount(getJsonObjectAsInt(recipeInfo, "ReviewCount"));
			recipe.setImageUrl(getJsonObjectAsString(recipeInfo, "ImageURL"));
			recipe.setLargeImageUrl(getJsonObjectAsString(recipeInfo, "HeroPhotoUrl"));
		}
		return recipe;
	}

	private NutritionInfo parseNutritionInfo(JsonObject responseInfo) {
		NutritionInfo nutrition = new NutritionInfo();
		nutrition.setCaloriesFromFat(getJsonObjectAsInt(responseInfo, "CaloriesFromFat"));
		nutrition.setCholesterol(getJsonObjectAsInt(responseInfo, "Cholesterol"));
		nutrition.setCholesterolPct(getJsonObjectAsInt(responseInfo, "CholesterolPct"));
		nutrition.setDietaryFiber(getJsonObjectAsInt(responseInfo, "DietaryFiber"));
		nutrition.setDietaryFiberPct(getJsonObjectAsInt(responseInfo, "DietaryFiberPct"));
		nutrition.setMonoFat(getJsonObjectAsInt(responseInfo, "MonoFat"));
		nutrition.setPolyFat(getJsonObjectAsInt(responseInfo, "PolyFat"));
		nutrition.setPotassium(getJsonObjectAsInt(responseInfo, "Potassium"));
		nutrition.setPotassiumPct(getJsonObjectAsInt(responseInfo, "PotassiumPct"));
		nutrition.setProtein(getJsonObjectAsInt(responseInfo, "Protein"));		
		nutrition.setProteinPct(getJsonObjectAsInt(responseInfo, "ProteinPct"));	
		nutrition.setSatFat(getJsonObjectAsInt(responseInfo, "SatFat"));	
		nutrition.setSingularYieldUnit(getJsonObjectAsString(responseInfo, "SingularYieldUnit"));	
		nutrition.setSodium(getJsonObjectAsInt(responseInfo, "Sodium"));	
		nutrition.setSodiumPct(getJsonObjectAsInt(responseInfo, "SodiumPct"));	
		nutrition.setSugar(getJsonObjectAsInt(responseInfo, "Sugar"));	
		nutrition.setTotalCalories(getJsonObjectAsInt(responseInfo, "TotalCalories"));	
		nutrition.setTotalCarbs(getJsonObjectAsInt(responseInfo, "TotalCarbs"));	
		nutrition.setTotalCarbsPct(getJsonObjectAsInt(responseInfo, "TotalCarbsPct"));	
		nutrition.setTotalFat(getJsonObjectAsInt(responseInfo, "TotalFat"));	
		nutrition.setTotalFatPct(getJsonObjectAsInt(responseInfo, "TotalFatPct"));	

		return nutrition;
	}

	private Ingredient parseIngredient(JsonObject responseInfo, Integer recipeId) {
		Ingredient ingredient = new Ingredient();
		ingredient.setDisplayIndex(getJsonObjectAsInt(responseInfo, "DisplayIndex"));
		ingredient.setIngredientID(getJsonObjectAsInt(responseInfo, "IngredientID"));
		ingredient.setIsHeading(getJsonObjectAsBoolean(responseInfo, "IsHeading"));
		ingredient.setIsLinked(getJsonObjectAsBoolean(responseInfo, "IsLinked"));
		ingredient.setMetricDisplayQuantity(getJsonObjectAsString(responseInfo, "MetricDisplayQuantity"));
		ingredient.setMetricQuantity(getJsonObjectAsInt(responseInfo, "MetricQuantity"));
		ingredient.setMetricUnit(getJsonObjectAsString(responseInfo, "MetricUnit"));
		ingredient.setName(getJsonObjectAsString(responseInfo, "Name"));
		ingredient.setPreparationNotes(getJsonObjectAsString(responseInfo, "PreparationNotes"));
		ingredient.setQuantity(getJsonObjectAsInt(responseInfo, "Quantity"));
		ingredient.setUnit(getJsonObjectAsString(responseInfo, "Unit"));
		ingredient.setDisplayQuantity(getJsonObjectAsString(responseInfo, "DisplayQuantity"));
		ingredient.setRecipeId(recipeId);

		//IngredientInfo
		if (hasJsonObject(responseInfo, "IngredientInfo")) {
			JsonObject responseIngredientInfo = responseInfo.getAsJsonObject("IngredientInfo");
			IngredientInfo ingredientInfo = new IngredientInfo();
			ingredientInfo.setDepartment(getJsonObjectAsString(responseIngredientInfo, "Department"));
			ingredientInfo.setName(getJsonObjectAsString(responseIngredientInfo, "Name")); 
			ingredient.setIngredientInfo(ingredientInfo);
		}
		return ingredient;
	}

}

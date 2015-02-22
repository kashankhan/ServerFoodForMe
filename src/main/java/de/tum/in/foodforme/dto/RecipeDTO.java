package de.tum.in.foodforme.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeDAO;
import de.tum.in.foodforme.model.Ingredient;
import de.tum.in.foodforme.model.IngredientInfo;
import de.tum.in.foodforme.model.NutritionInfo;
import de.tum.in.foodforme.model.Recipe;

public class RecipeDTO extends GenericDTO {

	private final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	
	public List<Recipe> parseRecipes(String requestBody) {
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
	}
	
	private Recipe parseRecipe(JsonObject recipeInfo) {
        int recipeId = recipeInfo.get("RecipeID").getAsInt();
        Recipe recipe = recipeDAO.getRecipe(recipeId);
        if(recipe == null) {
       	 recipe = new Recipe();
        }
        recipe.setRecipeId(recipeId);
        recipe.setTitle(recipeInfo.get("Title").getAsString());
        recipe.setStarRating(recipeInfo.get("StarRating").getAsInt());
        recipe.setCategory(recipeInfo.get("Category").getAsString());
        recipe.setSubcategory(recipeInfo.get("Subcategory").getAsString());
        String cuisine = (recipeInfo.get("Cuisine").isJsonNull()) ? "" : recipeInfo.get("Cuisine").getAsString();
        recipe.setCuisine(cuisine);
        Boolean isBookmark = (recipeInfo.get("IsBookmark").isJsonNull()) ? false : recipeInfo.get("IsBookmark").getAsBoolean();
        recipe.setIsBookmark(isBookmark);
        recipe.setReviewCount(recipeInfo.get("ReviewCount").getAsInt());
        recipe.setImageUrl(recipeInfo.get("ImageURL").getAsString());
        recipe.setLargeImageUrl(recipeInfo.get("HeroPhotoUrl").getAsString());
        Integer totalTries = (this.hasObject(recipeInfo, "TotalTries")) ? recipeInfo.get("TotalTries").getAsInt() : 0;
        recipe.setTotalTries(totalTries);
        
        return recipe;
	}
	
	public Recipe parseRecipeDetail(String requestBody) {
		 JsonObject recipeInfo = this.getJsonObject(requestBody);
         Recipe recipe = parseRecipe(recipeInfo);
         recipe.setActiveMinutes((recipeInfo.get("ActiveMinutes").isJsonNull()) ? 0 : recipeInfo.get("ActiveMinutes").getAsInt());
         recipe.setDescription(recipeInfo.get("Description").getAsString());
         recipe.setPrimaryIngredient(recipeInfo.get("PrimaryIngredient").getAsString()); 
         recipe.setTotalMinutes((recipeInfo.get("TotalMinutes").isJsonNull()) ? 0 : recipeInfo.get("TotalMinutes").getAsInt());  
         recipe.setYieldNumber(recipeInfo.get("YieldNumber").getAsInt());
         recipe.setYieldUnit(recipeInfo.get("YieldUnit").getAsString());
         recipe.setInstructions(recipeInfo.get("Instructions").getAsString());

         //Nutrition
         JsonObject nutritionResponseInfo = recipeInfo.getAsJsonObject("NutritionInfo");
         NutritionInfo nutritionInfo = parseNutritionInfo(nutritionResponseInfo);
         recipe.setNutritionInfo(nutritionInfo);
         
         //Ingredient
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
     	JsonArray results =  recipeInfo.getAsJsonArray("Ingredients");
     	for(int i = 0; i < results.size(); i++){ 
             JsonObject ingredientInfo = results.get(i).getAsJsonObject(); 
             Ingredient ingredient = parseIngredient(ingredientInfo);
             ingredients.add(ingredient);
         } 
     	recipe.setIngredients(ingredients);
     	
     	recipeDAO.save(recipe);
		
     	return recipe;
	}
	
	private NutritionInfo parseNutritionInfo(JsonObject responseInfo) {
		NutritionInfo nutrition = new NutritionInfo();
		nutrition.setCaloriesFromFat(responseInfo.get("CaloriesFromFat").getAsInt());
		nutrition.setCholesterol(responseInfo.get("Cholesterol").getAsInt());
		nutrition.setCholesterolPct(responseInfo.get("CholesterolPct").getAsInt());
		nutrition.setDietaryFiber(responseInfo.get("DietaryFiber").getAsInt());
		nutrition.setDietaryFiberPct(responseInfo.get("DietaryFiberPct").getAsInt());
		nutrition.setMonoFat(responseInfo.get("MonoFat").getAsInt());
		nutrition.setPolyFat(responseInfo.get("PolyFat").getAsInt());
		nutrition.setPotassium(responseInfo.get("Potassium").getAsInt());
		nutrition.setPotassiumPct(responseInfo.get("PotassiumPct").getAsInt());
		nutrition.setProtein(responseInfo.get("Protein").getAsInt());		
		nutrition.setProteinPct(responseInfo.get("ProteinPct").getAsInt());	
		nutrition.setSatFat(responseInfo.get("SatFat").getAsInt());	
		nutrition.setSingularYieldUnit(responseInfo.get("SingularYieldUnit").getAsString());	
		nutrition.setSodium(responseInfo.get("Sodium").getAsInt());	
		nutrition.setSodiumPct(responseInfo.get("SodiumPct").getAsInt());	
		nutrition.setSugar(responseInfo.get("Sugar").getAsInt());	
		nutrition.setTotalCalories(responseInfo.get("TotalCalories").getAsInt());	
		nutrition.setTotalCarbs(responseInfo.get("TotalCarbs").getAsInt());	
		nutrition.setTotalCarbsPct(responseInfo.get("TotalCarbsPct").getAsInt());	
		nutrition.setTotalFat(responseInfo.get("TotalFat").getAsInt());	
		nutrition.setTotalFatPct(responseInfo.get("TotalFatPct").getAsInt());	
		
		return nutrition;
	}
	
	private Ingredient parseIngredient(JsonObject responseInfo) {
		Ingredient ingredient = new Ingredient();
		ingredient.setDisplayIndex(responseInfo.get("DisplayIndex").getAsInt());
		ingredient.setIngredientID(responseInfo.get("IngredientID").getAsInt());
		ingredient.setIsHeading((responseInfo.get("IsHeading").isJsonNull()) ? false : responseInfo.get("IsHeading").getAsBoolean());
		ingredient.setIsLinked(responseInfo.get("IsLinked").getAsBoolean());
		ingredient.setMetricDisplayQuantity(responseInfo.get("MetricDisplayQuantity").getAsString());
		ingredient.setMetricQuantity(responseInfo.get("MetricQuantity").getAsInt());
		ingredient.setMetricUnit(responseInfo.get("MetricUnit").getAsString());
		ingredient.setMetricUnit(responseInfo.get("MetricUnit").getAsString());
		ingredient.setName(responseInfo.get("Name").getAsString());
		ingredient.setPreparationNotes((responseInfo.get("PreparationNotes").isJsonNull()) ? "" : responseInfo.get("PreparationNotes").getAsString());
		ingredient.setQuantity(responseInfo.get("Quantity").getAsInt());
		ingredient.setUnit((responseInfo.get("Unit").isJsonNull()) ? "" : responseInfo.get("Unit").getAsString());
		ingredient.setDisplayQuantity((responseInfo.get("DisplayQuantity").isJsonNull()) ? "" : responseInfo.get("DisplayQuantity").getAsString());
		
        //IngredientInfo
		JsonObject responseIngredientInfo = responseInfo.getAsJsonObject("IngredientInfo");
		IngredientInfo ingredientInfo = new IngredientInfo();
		ingredientInfo.setDepartment((responseIngredientInfo.get("Department").isJsonNull()) ? "" : responseIngredientInfo.get("Department").getAsString());
		ingredientInfo.setName((responseIngredientInfo.get("Name").isJsonNull()) ? "" : responseIngredientInfo.get("Name").getAsString()); 
		ingredient.setIngredientInfo(ingredientInfo);
		
		return ingredient;
	}
	
}

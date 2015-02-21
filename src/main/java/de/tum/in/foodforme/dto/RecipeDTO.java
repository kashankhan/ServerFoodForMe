package de.tum.in.foodforme.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeDAO;
import de.tum.in.foodforme.model.Ingredient;
import de.tum.in.foodforme.model.Nutrition;
import de.tum.in.foodforme.model.Recipe;

public class RecipeDTO {

	private final RecipeDAO recipeDAO = DAOManager.createRecipeDAO();
	
	public List<Recipe> parseRecipes(String requestBody) {
		List<Recipe> recipes = new ArrayList<Recipe>();
		JsonParser parser = new JsonParser();
		JsonObject response = (JsonObject)parser.parse(requestBody);
		JsonArray results =  response.getAsJsonArray("Results");

		for(int i = 0; i < results.size(); i++){ 
             JsonObject recipeInfo = results.get(i).getAsJsonObject(); 
             int recipeId = recipeInfo.get("RecipeID").getAsInt();
             Recipe recipe = recipeDAO.getRecipe(recipeId);
             if(recipe == null) {
            	 recipe = new Recipe();
             }
             recipe.setRecipeId(recipeId);
             recipe.setTitle(recipeInfo.get("Title").getAsString());
             recipe.setStarRating(recipeInfo.get("StarRating").getAsInt());
             Integer totalTries = (recipeInfo.get("TotalTries").isJsonNull()) ? 0 : recipeInfo.get("TotalTries").getAsInt();
             recipe.setTotalTries(totalTries);
             recipe.setCategory(recipeInfo.get("Category").getAsString());
             recipe.setSubcategory(recipeInfo.get("Subcategory").getAsString());
             String cuisine = (recipeInfo.get("Cuisine").isJsonNull()) ? "" : recipeInfo.get("Cuisine").getAsString();
             recipe.setCuisine(cuisine);
             Boolean isBookmark = (recipeInfo.get("IsBookmark").isJsonNull()) ? false : recipeInfo.get("IsBookmark").getAsBoolean();
             recipe.setIsBookmark(isBookmark);
             recipe.setReviewCount(recipeInfo.get("ReviewCount").getAsInt());
             recipe.setImageUrl(recipeInfo.get("ImageURL").getAsString());
             recipe.setLargeImageUrl(recipeInfo.get("HeroPhotoUrl").getAsString());
             
             recipeDAO.save(recipe);
             recipes.add(recipe);
         } 
		
		return recipes;	
	}
	
	public Recipe parseRecipe(String reqeustBody) {
		Recipe recipe = new Recipe();
		
//      let recipeId = NSString(format:"%d", recipeInfo[""] as Int)
//      let recipe = dataContext.recipes.createOrGetFirstEntity(whereAttribute: "recipeId", isEqualTo: recipeId)
//      recipe.recipeId = recipeId
//      recipe.title = recipeInfo[""] as String
//      recipe.starRating = recipeInfo[""] as Int
//      recipe.totalTries = (recipeInfo[""] is Int) ? recipeInfo["TotalTries"] as Int : 0
//      recipe.category = recipeInfo[""] as String
//      recipe.subcategory = recipeInfo[""] as String
//      recipe.cuisine = (recipeInfo[""] is String) ? recipeInfo["Cuisine"] as String : ""
//      recipe.bookmark = (recipeInfo[""] is Bool) ? recipeInfo["IsBookmark"] as Bool : false
//      recipe.reviewCount = recipeInfo[""] as Int
//      recipe.imageUri = recipeInfo[""] as String
//      recipe.largeImageUri = recipeInfo[""] as String
      
//      // Attribut "hobbys" als Array lesen 
//      JsonArray hobbys = person.get("hobbys").getAsJsonArray(); 
//  
//      for(int k = 0; k < hobbys.size(); k++){ 
//          JsonObject hobby = hobbys.get(k).getAsJsonObject(); 
//          
//          // Name des Hobbys ausgeben 
//          System.out.println(hobby.get("name").getAsString()); 
//      } 
		return recipe;
	}
	
	private Nutrition parseNutrition(String responseInfo) {
		Nutrition nutrition = new Nutrition();
		
		
//        nutritionInfo.caloriesFromFat = response?["CaloriesFromFat"] as Int
//        nutritionInfo.cholesterol = response?["Cholesterol"] as Int
//        nutritionInfo.cholesterolPct = response?["CholesterolPct"] as Int
//        nutritionInfo.dietaryFiber = response?["DietaryFiber"] as Int
//        nutritionInfo.dietaryFiberPct = response?["DietaryFiberPct"] as Int
//        nutritionInfo.monoFat = response?["MonoFat"] as Int
//        nutritionInfo.polyFat = response?["PolyFat"] as Int
//        nutritionInfo.potassium = response?["Potassium"] as Int
//        nutritionInfo.potassiumPct = response?["PotassiumPct"] as Int
//        nutritionInfo.protein = response?["Protein"] as Int
//        nutritionInfo.proteinPct = response?["ProteinPct"] as Int
//        nutritionInfo.satFat = response?["SatFat"] as Int
//        nutritionInfo.satFatPct = response?["SatFatPct"] as Int
//        nutritionInfo.singularYieldUnit = response?["SingularYieldUnit"] as String
//        nutritionInfo.sodium = response?["Sodium"] as Int
//        nutritionInfo.sodiumPct = response?["SodiumPct"] as Int
//        nutritionInfo.sugar = response?["Sugar"] as Int
//        nutritionInfo.totalCalories = response?["TotalCalories"] as Int
//        nutritionInfo.totalCarbs = response?["TotalCarbs"] as Int
//        nutritionInfo.totalCarbsPct = response?["TotalCarbsPct"] as Int
//        nutritionInfo.totalFat = response?["TotalFat"] as Int
//        nutritionInfo.totalFatPct = response?["TotalFatPct"] as Int
//        nutritionInfo.transFat = response?["TransFat"] as Int
		
		return nutrition;
	}
	
	private Ingredient parseIngredient(String responseInfo) {
		Ingredient ingredient = new Ingredient();
		
//        let ingredientID = NSString(format:"%d", response["IngredientID"] as Int)
//       ingredient.displayIndex = response["DisplayIndex"] as Int
//       ingredient.ingredientID = ingredientID
//       ingredient.recipeId = recipe.recipeId
//       ingredient.isHeading = response["IsHeading"] as Int
//       ingredient.isLinked = response["IsLinked"] as Int
//       ingredient.metricDisplayQuantity = response["MetricDisplayQuantity"] as String
//       ingredient.metricQuantity = response["MetricQuantity"] as Int
//       ingredient.metricUnit = response["MetricUnit"] as String
//       ingredient.name = response["Name"] as String
//       ingredient.preparationNotes = (response["PreparationNotes"] is String) ? response["PreparationNotes"] as String : ""
//       ingredient.quantity = response["Quantity"] as Int
//       ingredient.recipeId = recipe.recipeId
//       ingredient.unit = (response["Unit"] is String) ? response["Unit"] as String : ""
//       ingredient.displayQuantity = (response["DisplayQuantity"] is String) ? response["DisplayQuantity"] as String : ""
//       if let ingredientInfo: NSDictionary =  response["IngredientInfo"] as? NSDictionary {
//           ingredient.department = ingredientInfo["Department"] as String
//       }
		return ingredient;
	}
	
}

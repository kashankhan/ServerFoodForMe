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
	
	

	private String getRecipe() {

		String recipeInfo = "{\n" + 
				"  \"Cuisine\" : \"\",\n" + 
				"  \"BookmarkSiteLogo\" : \"\",\n" + 
				"  \"StarRating\" : 5,\n" + 
				"  \"ReviewCount\" : 1,\n" + 
				"  \"IsRecipeScan\" : null,\n" + 
				"  \"IsPrivate\" : false,\n" + 
				"  \"IngredientsTextBlock\" : null,\n" + 
				"  \"AdTags\" : null,\n" + 
				"  \"TotalMinutes\" : 30,\n" + 
				"  \"PrimaryIngredient\" : \"Oysters\",\n" + 
				"  \"VerifiedDateTime\" : \"/Date(1405631030543)/\",\n" + 
				"  \"VerifiedByClass\" : \"helper\",\n" + 
				"  \"NotesCount\" : 0,\n" + 
				"  \"BookmarkImageURL\" : null,\n" + 
				"  \"Category\" : \"Appetizers\",\n" + 
				"  \"NutritionInfo\" : {\n" + 
				"    \"ProteinPct\" : 0,\n" + 
				"    \"PotassiumPct\" : 0,\n" + 
				"    \"PolyFat\" : 0,\n" + 
				"    \"TotalFatPct\" : 0,\n" + 
				"    \"Protein\" : 0,\n" + 
				"    \"TotalCalories\" : 0,\n" + 
				"    \"Cholesterol\" : 0,\n" + 
				"    \"SatFatPct\" : 0,\n" + 
				"    \"TotalFat\" : 0,\n" + 
				"    \"SatFat\" : 0,\n" + 
				"    \"CholesterolPct\" : 0,\n" + 
				"    \"SodiumPct\" : 0,\n" + 
				"    \"DietaryFiberPct\" : 0,\n" + 
				"    \"TransFat\" : 0,\n" + 
				"    \"Sugar\" : 0,\n" + 
				"    \"SingularYieldUnit\" : \"Paid API plan required for nutrition.\",\n" + 
				"    \"TotalCarbsPct\" : 0,\n" + 
				"    \"TotalCarbs\" : 0,\n" + 
				"    \"Potassium\" : 0,\n" + 
				"    \"Sodium\" : 0,\n" + 
				"    \"CaloriesFromFat\" : 0,\n" + 
				"    \"MonoFat\" : 0,\n" + 
				"    \"DietaryFiber\" : 0\n" + 
				"  },\n" + 
				"  \"AdminBoost\" : null,\n" + 
				"  \"YieldNumber\" : 6,\n" + 
				"  \"WebURL\" : \"http://www.bigoven.com/recipe/oysters/745025\",\n" + 
				"  \"Instructions\" : \"Dip well-drained oysters into egg mixture.\\r\\nPlace on platter which is covered with cracker crumbs.\\r\\nSprinkle more cracker crumbs over oyster tops press into oysters. \\r\\nTurn oysters over pressing move crumbs into oysters.\\r\\nContinue process.\\r\\nSprinkle remaining crumbs over oysters and refrigerate.\\r\\nFry up in butter.\\r\\nDo not let burn.  \",\n" + 
				"  \"IsBookmark\" : false,\n" + 
				"  \"ImageSquares\" : [\n" + 
				"    256,\n" + 
				"    200,\n" + 
				"    128,\n" + 
				"    120,\n" + 
				"    64,\n" + 
				"    48,\n" + 
				"    36\n" + 
				"  ],\n" + 
				"  \"MedalCount\" : 0,\n" + 
				"  \"YieldUnit\" : \"Servings\",\n" + 
				"  \"IsSponsored\" : false,\n" + 
				"  \"CreationDate\" : \"/Date(1388488493883)/\",\n" + 
				"  \"MaxImageSquare\" : 256,\n" + 
				"  \"Title\" : \"Oysters\",\n" + 
				"  \"Subcategory\" : \"Seafood\",\n" + 
				"  \"LastModified\" : \"/Date(1413481071840)/\",\n" + 
				"  \"RecipeID\" : 745025,\n" + 
				"  \"Description\" : \"My father-in-law made this and I loved it. \",\n" + 
				"  \"ImageURL\" : \"http://redirect.bigoven.com/pics/rs/640/oysters.jpg\",\n" + 
				"  \"ActiveMinutes\" : 30,\n" + 
				"  \"BookmarkURL\" : null,\n" + 
				"  \"MenuCount\" : 0,\n" + 
				"  \"AllCategoriesText\" : \"\",\n" + 
				"  \"VariantOfRecipeID\" : null,\n" + 
				"  \"Collection\" : \"\",\n" + 
				"  \"Ingredients\" : [\n" + 
				"    {\n" + 
				"      \"DisplayQuantity\" : \"2\",\n" + 
				"      \"Name\" : \"milk\",\n" + 
				"      \"DisplayIndex\" : 0,\n" + 
				"      \"IsHeading\" : false,\n" + 
				"      \"Unit\" : \"tablespoons\",\n" + 
				"      \"MetricUnit\" : \"ml\",\n" + 
				"      \"IsLinked\" : true,\n" + 
				"      \"IngredientID\" : 7575821,\n" + 
				"      \"HTMLName\" : null,\n" + 
				"      \"MetricDisplayQuantity\" : \"30\",\n" + 
				"      \"MetricQuantity\" : 30,\n" + 
				"      \"Quantity\" : 2,\n" + 
				"      \"PreparationNotes\" : \"\",\n" + 
				"      \"IngredientInfo\" : {\n" + 
				"        \"Name\" : \"milk\",\n" + 
				"        \"Department\" : \"Dairy\"\n" + 
				"      }\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"DisplayQuantity\" : \"2\",\n" + 
				"      \"Name\" : \"oysters\",\n" + 
				"      \"DisplayIndex\" : 1,\n" + 
				"      \"IsHeading\" : false,\n" + 
				"      \"Unit\" : \"cans\",\n" + 
				"      \"MetricUnit\" : \"cans\",\n" + 
				"      \"IsLinked\" : true,\n" + 
				"      \"IngredientID\" : 7575822,\n" + 
				"      \"HTMLName\" : \"<a href=\\\"http://www.bigoven.com/glossary/oysters\\\" class=\\\"glosslink\\\">oysters</a>\",\n" + 
				"      \"MetricDisplayQuantity\" : \"2\",\n" + 
				"      \"MetricQuantity\" : 2,\n" + 
				"      \"Quantity\" : 2,\n" + 
				"      \"PreparationNotes\" : \"well drained\",\n" + 
				"      \"IngredientInfo\" : {\n" + 
				"        \"Name\" : \"oysters\",\n" + 
				"        \"Department\" : \"Seafood\"\n" + 
				"      }\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"DisplayQuantity\" : null,\n" + 
				"      \"Name\" : \"grated lemon rind\",\n" + 
				"      \"DisplayIndex\" : 2,\n" + 
				"      \"IsHeading\" : false,\n" + 
				"      \"Unit\" : null,\n" + 
				"      \"MetricUnit\" : \"\",\n" + 
				"      \"IsLinked\" : true,\n" + 
				"      \"IngredientID\" : 7575823,\n" + 
				"      \"HTMLName\" : \"grated <a href=\\\"http://www.bigoven.com/glossary/lemon\\\" class=\\\"glosslink\\\">lemon</a> rind\",\n" + 
				"      \"MetricDisplayQuantity\" : \"\",\n" + 
				"      \"MetricQuantity\" : 0,\n" + 
				"      \"Quantity\" : 1,\n" + 
				"      \"PreparationNotes\" : \" optional \",\n" + 
				"      \"IngredientInfo\" : {\n" + 
				"        \"Name\" : \"grated lemon rind\",\n" + 
				"        \"Department\" : \"Produce\"\n" + 
				"      }\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"DisplayQuantity\" : null,\n" + 
				"      \"Name\" : \"butter\",\n" + 
				"      \"DisplayIndex\" : 3,\n" + 
				"      \"IsHeading\" : false,\n" + 
				"      \"Unit\" : null,\n" + 
				"      \"MetricUnit\" : \"\",\n" + 
				"      \"IsLinked\" : true,\n" + 
				"      \"IngredientID\" : 7575824,\n" + 
				"      \"HTMLName\" : \"<a href=\\\"http://www.bigoven.com/glossary/butter\\\" class=\\\"glosslink\\\">butter</a>\",\n" + 
				"      \"MetricDisplayQuantity\" : \"\",\n" + 
				"      \"MetricQuantity\" : 0,\n" + 
				"      \"Quantity\" : 1,\n" + 
				"      \"PreparationNotes\" : \"for sauteing \",\n" + 
				"      \"IngredientInfo\" : {\n" + 
				"        \"Name\" : \"butter\",\n" + 
				"        \"Department\" : \"Dairy\"\n" + 
				"      }\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"DisplayQuantity\" : null,\n" + 
				"      \"Name\" : \"cracker crumbs\",\n" + 
				"      \"DisplayIndex\" : 4,\n" + 
				"      \"IsHeading\" : false,\n" + 
				"      \"Unit\" : null,\n" + 
				"      \"MetricUnit\" : \"\",\n" + 
				"      \"IsLinked\" : true,\n" + 
				"      \"IngredientID\" : 7575825,\n" + 
				"      \"HTMLName\" : \"cracker crumbs\",\n" + 
				"      \"MetricDisplayQuantity\" : \"\",\n" + 
				"      \"MetricQuantity\" : 0,\n" + 
				"      \"Quantity\" : 1,\n" + 
				"      \"PreparationNotes\" : \"unsalted\",\n" + 
				"      \"IngredientInfo\" : {\n" + 
				"        \"Name\" : \"cracker crumbs\",\n" + 
				"        \"Department\" : \"Snacks\"\n" + 
				"      }\n" + 
				"    }\n" + 
				"  ],\n" + 
				"  \"Poster\" : {\n" + 
				"    \"UserID\" : 1847485,\n" + 
				"    \"PremiumExpiryDate\" : null,\n" + 
				"    \"ImageURL48\" : \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"    \"IsPremium\" : false,\n" + 
				"    \"IsUsingRecurly\" : false,\n" + 
				"    \"UserName\" : \"Caj1947\",\n" + 
				"    \"IsKitchenHelper\" : false,\n" + 
				"    \"MemberSince\" : \"/Date(1358038680000)/\"\n" + 
				"  },\n" + 
				"  \"HeroPhotoUrl\" : \"http://images.bigoven.com/image/upload/oysters.jpg\",\n" + 
				"  \"FavoriteCount\" : 15\n" + 
				"}";

		return recipeInfo;
	}
	 
	private String searchRecipeResult() {

		String result = "{\n" + 
				"    \"Results\": [\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oysters/745025\",\n" + 
				"            \"YieldNumber\": 6,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oysters\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Seafood\",\n" + 
				"            \"ReviewCount\": 1,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oysters.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": \"/Date(1388488493883)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 1847485,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"                \"IsPremium\": false,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"Caj1947\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 745025,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oysters.jpg\",\n" + 
				"            \"TotalTries\": 8,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oysters.jpg\",\n" + 
				"            \"Cuisine\": \"\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-snack-crackers/541913\",\n" + 
				"            \"YieldNumber\": 8,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster snack crackers\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Appetizers - Other\",\n" + 
				"            \"ReviewCount\": 2,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-snack-crackers.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 4,\n" + 
				"            \"CreationDate\": \"/Date(1370350037000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 1949901,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/peggysullivan.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"peggysullivan\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 541913,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-snack-crackers.jpg\",\n" + 
				"            \"TotalTries\": 134,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-snack-crackers.jpg\",\n" + 
				"            \"Cuisine\": null\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oysters-rockefeller/175389\",\n" + 
				"            \"YieldNumber\": 2,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oysters Rockefeller\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Seafood\",\n" + 
				"            \"ReviewCount\": 3,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oysters-rockefeller-2.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 700,\n" + 
				"            \"StarRating\": 4.66666666666667,\n" + 
				"            \"CreationDate\": \"/Date(1256021014243)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 29843,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/19010711162029843.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"sgrishka\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 175389,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oysters-rockefeller-2.jpg\",\n" + 
				"            \"TotalTries\": 108,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oysters-rockefeller-2.jpg\",\n" + 
				"            \"Cuisine\": \"American\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-kilpatrick/166812\",\n" + 
				"            \"YieldNumber\": 6,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Kilpatrick\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Seafood\",\n" + 
				"            \"ReviewCount\": 4,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-kilpatrick-2.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": \"/Date(1221729029000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 38679,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/10110605555138679.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"little_fieldmouse\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 166812,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-kilpatrick-2.jpg\",\n" + 
				"            \"TotalTries\": 18,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-kilpatrick-2.jpg\",\n" + 
				"            \"Cuisine\": \"Australian\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-salad/349484\",\n" + 
				"            \"YieldNumber\": 8,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Salad\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Meat and Seafood\",\n" + 
				"            \"ReviewCount\": 1,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-salad.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 1280,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": \"/Date(1349645219000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 969428,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/schmeershirley.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"SchmeerShirley\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 349484,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-salad.jpg\",\n" + 
				"            \"TotalTries\": 6,\n" + 
				"            \"Category\": \"Salad\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-salad.jpg\",\n" + 
				"            \"Cuisine\": null\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-stew/399878\",\n" + 
				"            \"YieldNumber\": 16,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Stew\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Seafood non-chowder\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-stew-5.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1356204096943)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 681518,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/111209114624681518.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"BobbyMac\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 399878,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-stew-5.jpg\",\n" + 
				"            \"TotalTries\": 9,\n" + 
				"            \"Category\": \"Soups, Stews and Chili\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-stew-5.jpg\",\n" + 
				"            \"Cuisine\": \"\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-casserole/1094907\",\n" + 
				"            \"YieldNumber\": 8,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Casserole\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Casseroles\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-casserole-2.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 512,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1422658125717)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 2741108,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"jlclar1\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 1094907,\n" + 
				"            \"HeroPhotoUrl\": \"http://redirect.bigoven.com/pics/oyster-casserole-2.jpg\",\n" + 
				"            \"TotalTries\": null,\n" + 
				"            \"Category\": \"Side Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-casserole-2.jpg\",\n" + 
				"            \"Cuisine\": \"Seafood\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-chicken/420926\",\n" + 
				"            \"YieldNumber\": 1,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Chicken\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Poultry - Chicken\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-chicken.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1357852826473)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 1089306,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/lyssa.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"Lyssa\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 420926,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-chicken.jpg\",\n" + 
				"            \"TotalTries\": 1,\n" + 
				"            \"Category\": \"Main Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-chicken.jpg\",\n" + 
				"            \"Cuisine\": \"\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-dressing/234776\",\n" + 
				"            \"YieldNumber\": 1,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Dressing\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Side Dish - Other\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-dressing-8.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 700,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1326214365107)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 1278005,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"Telln\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 234776,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-dressing-8.jpg\",\n" + 
				"            \"TotalTries\": 2,\n" + 
				"            \"Category\": \"Side Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-dressing-8.jpg\",\n" + 
				"            \"Cuisine\": null\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-crackers/202167\",\n" + 
				"            \"YieldNumber\": 24,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Crackers\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Other - Misc\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://images.bigoven.com/image/upload/oyster-crackers.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1309927619000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 1186682,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"                \"IsPremium\": false,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"Lacookbook\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 202167,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-crackers.jpg\",\n" + 
				"            \"TotalTries\": 3,\n" + 
				"            \"Category\": \"Other\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/rs/256/oyster-crackers.jpg\",\n" + 
				"            \"Cuisine\": \"American\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/panfried-oysters/943137\",\n" + 
				"            \"YieldNumber\": 4,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Panfried Oysters\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Fish and Shellfish\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/panfried-oysters.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1410127911000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 969428,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/schmeershirley.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"SchmeerShirley\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 943137,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/panfried-oysters.jpg\",\n" + 
				"            \"TotalTries\": null,\n" + 
				"            \"Category\": \"Main Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/panfried-oysters.jpg\",\n" + 
				"            \"Cuisine\": \"American\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-cracker-snack/169279\",\n" + 
				"            \"YieldNumber\": 20,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Cracker Snack\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Appetizers - Other\",\n" + 
				"            \"ReviewCount\": 1,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-cracker-snack.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 320,\n" + 
				"            \"StarRating\": 4,\n" + 
				"            \"CreationDate\": \"/Date(1230841622000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 306704,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/timga.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"TimGa\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 169279,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-cracker-snack.jpg\",\n" + 
				"            \"TotalTries\": 8,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-cracker-snack.jpg\",\n" + 
				"            \"Cuisine\": null\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oyster-cornbread-dressing/168119\",\n" + 
				"            \"YieldNumber\": 8,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oyster Cornbread Dressing\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Side Dish - Other\",\n" + 
				"            \"ReviewCount\": 1,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oyster-cornbread-dressing.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 1280,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": \"/Date(1227712046000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 92554,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/arbpen.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"arbpen\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 168119,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oyster-cornbread-dressing.jpg\",\n" + 
				"            \"TotalTries\": 22,\n" + 
				"            \"Category\": \"Side Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oyster-cornbread-dressing.jpg\",\n" + 
				"            \"Cuisine\": \"Cajun\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/seasoned-oyster-crackers/164273\",\n" + 
				"            \"YieldNumber\": 6,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Seasoned Oyster Crackers\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Grains\",\n" + 
				"            \"ReviewCount\": 6,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/seasoned-oyster-crackers-2.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 4.83333333333333,\n" + 
				"            \"CreationDate\": \"/Date(1198033112000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 69433,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/18120708224069433.jpg\",\n" + 
				"                \"IsPremium\": false,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"kimberlyelder\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 164273,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/seasoned-oyster-crackers-2.jpg\",\n" + 
				"            \"TotalTries\": 112,\n" + 
				"            \"Category\": \"Side Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/seasoned-oyster-crackers-2.jpg\",\n" + 
				"            \"Cuisine\": \"American\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/steamed-musselsoystersclams/37690\",\n" + 
				"            \"YieldNumber\": 1,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Steamed Mussels/Oysters/Clams\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Pickles\",\n" + 
				"            \"ReviewCount\": 1,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/steamed-musselsoystersclams-3.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 1280,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": \"/Date(1072936800000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 0,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": null,\n" + 
				"                \"IsPremium\": false,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": null,\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 37690,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/steamed-musselsoystersclams-3.jpg            \",\n" + 
				"            \"TotalTries\": 133,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/steamed-musselsoystersclams-3.jpg\",\n" + 
				"            \"Cuisine\": \"American\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/chilli-pork-with-oyster-sauce/166691\",\n" + 
				"            \"YieldNumber\": 4,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Chilli Pork with Oyster Sauce\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Stir-Fries\",\n" + 
				"            \"ReviewCount\": 1,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/chilli-pork-with-oyster-sauce.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 4,\n" + 
				"            \"CreationDate\": \"/Date(1219946851140)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 53443,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/01080703063153443.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"greybeard01\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 166691,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/chilli-pork-with-oyster-sauce.jpg\",\n" + 
				"            \"TotalTries\": 9,\n" + 
				"            \"Category\": \"Main Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/chilli-pork-with-oyster-sauce.jpg\",\n" + 
				"            \"Cuisine\": \"Chinese\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/zmans-oysters-bienville/191877\",\n" + 
				"            \"YieldNumber\": 2,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"ZMan's Oysters Bienville\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Seafood\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/zmans-oysters-bienville.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 640,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": null,\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 162056,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"The_ZMan\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 191877,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/zmans-oysters-bienville.jpg\",\n" + 
				"            \"TotalTries\": 8,\n" + 
				"            \"Category\": \"Appetizers\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/zmans-oysters-bienville.jpg\",\n" + 
				"            \"Cuisine\": \"Cajun\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/oven-fried-oysters/160028\",\n" + 
				"            \"YieldNumber\": 8,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Oven Fried Oysters\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Fish and Shellfish\",\n" + 
				"            \"ReviewCount\": 6,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/oven-fried-oysters-2.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 4.2,\n" + 
				"            \"CreationDate\": \"/Date(1132285969000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 19314,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/promfh.jpg\",\n" + 
				"                \"IsPremium\": true,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"promfh\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 160028,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/oven-fried-oysters-2.jpg\",\n" + 
				"            \"TotalTries\": 77,\n" + 
				"            \"Category\": \"Main Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/oven-fried-oysters-2.jpg\",\n" + 
				"            \"Cuisine\": \"Cajun\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/the-begaults-new-orleans-oyster-dressing/167049\",\n" + 
				"            \"YieldNumber\": 8,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"The Begault's New Orleans Oyster Dressing\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Seafood\",\n" + 
				"            \"ReviewCount\": 2,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/the-begaults-new-orleans-oyster-dre.jpg\",\n" + 
				"            \"IsBookmark\": null,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 5,\n" + 
				"            \"CreationDate\": \"/Date(1223654501453)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 152404,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar-default.png\",\n" + 
				"                \"IsPremium\": false,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"katycajun\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 167049,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/the-begaults-new-orleans-oyster-dre.jpg\",\n" + 
				"            \"TotalTries\": 27,\n" + 
				"            \"Category\": \"Side Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/the-begaults-new-orleans-oyster-dre.jpg\",\n" + 
				"            \"Cuisine\": \"Cajun\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"WebURL\": \"http://www.bigoven.com/recipe/steamed-buns-with-tempura-king-oyster-mushrooms-and-agave-miso-mayonnaise/591666\",\n" + 
				"            \"YieldNumber\": 12,\n" + 
				"            \"QualityScore\": 0,\n" + 
				"            \"Title\": \"Steamed Buns with Tempura King Oyster Mushrooms and Agave-Miso Mayonnaise (\",\n" + 
				"            \"IsPrivate\": false,\n" + 
				"            \"Subcategory\": \"Sandwiches and Wraps\",\n" + 
				"            \"ReviewCount\": 0,\n" + 
				"            \"ImageURL120\": \"http://redirect.bigoven.com/pics/rs/120/steamed-buns-with-tempura-king-oyst-2.jpg\",\n" + 
				"            \"IsBookmark\": true,\n" + 
				"            \"MaxImageSquare\": 256,\n" + 
				"            \"StarRating\": 0,\n" + 
				"            \"CreationDate\": \"/Date(1375226493000)/\",\n" + 
				"            \"Poster\": {\n" + 
				"                \"UserID\": 2057280,\n" + 
				"                \"PremiumExpiryDate\": null,\n" + 
				"                \"ImageURL48\": \"http://images.bigoven.com/image/upload/t_recipe-48,d_avatar-default.png/avatar/seriouseatsrecipes.jpg\",\n" + 
				"                \"IsPremium\": false,\n" + 
				"                \"IsUsingRecurly\": false,\n" + 
				"                \"UserName\": \"SeriousEatsRecipes\",\n" + 
				"                \"IsKitchenHelper\": false,\n" + 
				"                \"MemberSince\": null\n" + 
				"            },\n" + 
				"            \"StarRatingIMG\": null,\n" + 
				"            \"RecipeID\": 591666,\n" + 
				"            \"HeroPhotoUrl\": \"http://images.bigoven.com/image/upload/steamed-buns-with-tempura-king-oyst-2.jpg\",\n" + 
				"            \"TotalTries\": 4,\n" + 
				"            \"Category\": \"Main Dish\",\n" + 
				"            \"HideFromPublicSearch\": false,\n" + 
				"            \"ImageURL\": \"http://redirect.bigoven.com/pics/steamed-buns-with-tempura-king-oyst-2.jpg\",\n" + 
				"            \"Cuisine\": null\n" + 
				"        }\n" + 
				"    ],\n" + 
				"    \"SpellSuggest\": null,\n" + 
				"    \"ResultCount\": 716\n" + 
				"}";



		return result;
	}

}

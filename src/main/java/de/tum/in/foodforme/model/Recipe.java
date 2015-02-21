package de.tum.in.foodforme.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Recipe extends AbstractEntity {

	private @Getter @Setter Integer recipeId;
	private @Getter @Setter String title;
	private @Getter @Setter Integer starRating;
	private @Getter @Setter Integer totalTries;
	private @Getter @Setter String category;
	private @Getter @Setter String subcategory;
	private @Getter @Setter String cuisine;
	private @Getter @Setter Boolean isBookmark;
	private @Getter @Setter Integer reviewCount;
	private @Getter @Setter String imageUrl;
	private @Getter @Setter String largeImageUrl;
	private @Getter @Setter Integer activeMinutes;
	private @Getter @Setter String description;
	private @Getter @Setter String primaryIngredient;
	private @Getter @Setter Integer totalMinutes;
	private @Getter @Setter Integer yieldNumber;
	private @Getter @Setter String  yieldUnit;
	private @Getter @Setter String instructions;
	
//	private @Getter @Setter Integer RecipeID;
//	private @Getter @Setter String Title;
//	private @Getter @Setter Integer StarRating;
//	private @Getter @Setter Integer TotalTries;
//	private @Getter @Setter String Category;
//	private @Getter @Setter String Subcategory;
//	private @Getter @Setter String Cuisine;
//	private @Getter @Setter Boolean IsBookmark;
//	private @Getter @Setter Integer ReviewCount;
//	private @Getter @Setter String ImageURL;
//	private @Getter @Setter String HeroPhotoUrl;
//	private @Getter @Setter Integer ActiveMinutes;
//	private @Getter @Setter String Description;
//	private @Getter @Setter String PrimaryIngredient;
//	private @Getter @Setter Integer TotalMinutes;
//	private @Getter @Setter Integer YieldNumber;
//	private @Getter @Setter String  YieldUnit;
//	private @Getter @Setter String Instructions;
	
	@OneToOne
	private @Getter @Setter Nutrition NutritionInfo;
	
	@OneToMany
	private @Getter @Setter List<Ingredient> Ingredients;
	
}

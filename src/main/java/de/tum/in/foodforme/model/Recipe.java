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

	private @Getter @Setter Integer RecipeID;
	private @Getter @Setter String Title;
	private @Getter @Setter Integer StarRating;
	private @Getter @Setter Integer TotalTries;
	private @Getter @Setter String Category;
	private @Getter @Setter String Subcategory;
	private @Getter @Setter String Cuisine;
	private @Getter @Setter Boolean IsBookmark;
	private @Getter @Setter Integer ReviewCount;
	private @Getter @Setter String ImageURL;
	private @Getter @Setter String HeroPhotoUrl;
	private @Getter @Setter Integer ActiveMinutes;
	private @Getter @Setter String Description;
	private @Getter @Setter String PrimaryIngredient;
	private @Getter @Setter Integer TotalMinutes;
	private @Getter @Setter Integer YieldNumber;
	private @Getter @Setter String  YieldUnit;
	private @Getter @Setter String Instructions;
	
	@OneToOne
	private @Getter @Setter Nutrition NutritionInfo;
	
	@OneToMany
	private @Getter @Setter List<Ingredient> Ingredients;
	
	public void createRecipe() {
		this.RecipeID = 1;
		this.Title = "Pappo pan wala";
	}

}

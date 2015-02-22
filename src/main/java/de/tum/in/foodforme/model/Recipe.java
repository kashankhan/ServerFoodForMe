package de.tum.in.foodforme.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(columnDefinition="text")
	private @Getter @Setter String instructions;
	
	@OneToOne(cascade = CascadeType.ALL)
	private @Getter @Setter NutritionInfo nutritionInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private @Getter @Setter List<Ingredient> ingredients;
	
}

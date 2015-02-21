package de.tum.in.foodforme.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Ingredient extends AbstractEntity{
	
	private @Getter @Setter Integer ingredientID;
	private @Getter @Setter Integer displayIndex;
	private @Getter @Setter Integer isHeading;
	private @Getter @Setter Boolean isLinked;
	private @Getter @Setter String metricDisplayQuantity;
	private @Getter @Setter Integer metricQuantity;
	private @Getter @Setter String metricUnit;
	private @Getter @Setter String name;
	private @Getter @Setter String preparationNotes;
	private @Getter @Setter String quantity;
	private @Getter @Setter String unit;
	private @Getter @Setter String displayQuantity;
	private @Getter @Setter String recipeId;
	@OneToOne
	private @Getter @Setter IngredientInfo ingredientInfo;
	
}

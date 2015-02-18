package de.tum.in.foodforme.model;

import javax.persistence.Entity;

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

	private @Getter @Setter int RecipeID;
	
	private @Getter @Setter String Title;
	
//	@OneToMany
//	private List<Ingredient> ingredients;
//	
//	@OneToOne
//	private Nutrition nutrition;
}

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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe extends AbstractEntity {

	private @Getter @Setter String recipeId;
	
	private @Getter @Setter String name;
	
	@OneToMany
	private List<Ingredient> ingredients;
	
	@OneToOne
	private Nutrition nutrition;
}

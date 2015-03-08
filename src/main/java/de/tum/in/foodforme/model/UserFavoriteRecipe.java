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
public class UserFavoriteRecipe extends AbstractEntity{

	private @Getter @Setter String userId;
	private @Getter @Setter Integer recipeId;
	private @Getter @Setter String ingredient;

}

package de.tum.in.foodforme.model;

import javax.persistence.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class UserIngredientPreference extends AbstractEntity {

	private @Getter @Setter String userId;
	private @Getter @Setter String ingredient;
	private @Getter @Setter boolean favorite;
}

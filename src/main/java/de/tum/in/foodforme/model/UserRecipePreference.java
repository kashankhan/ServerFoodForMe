package de.tum.in.foodforme.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class UserRecipePreference extends AbstractEntity{

	private @Getter @Setter String userId;
	private @Getter @Setter Integer recipeId;
	private @Getter @Setter Integer starRating;
	@Temporal(TemporalType.DATE)
	private @Getter @Setter Date lastCooked;

}

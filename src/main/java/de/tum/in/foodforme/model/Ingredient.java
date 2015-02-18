package de.tum.in.foodforme.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ingredient extends AbstractEntity{

	private @Getter @Setter Integer quality;
	private @Getter @Setter String name;
}

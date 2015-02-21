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
	
	private @Getter @Setter Integer IngredientID;
	private @Getter @Setter Integer DisplayIndex;
	private @Getter @Setter Integer IsHeading;
	private @Getter @Setter Boolean IsLinked;
	private @Getter @Setter String MetricDisplayQuantity;
	private @Getter @Setter Integer MetricQuantity;
	private @Getter @Setter String MetricUnit;
	private @Getter @Setter String Name;
	private @Getter @Setter String PreparationNotes;
	private @Getter @Setter String Quantity;
	private @Getter @Setter String Unit;
	private @Getter @Setter String DisplayQuantity;
	
	@OneToOne
	private @Getter @Setter IngredientDepartment IngredientInfo;
	
}

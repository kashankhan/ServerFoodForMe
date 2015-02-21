package de.tum.in.foodforme.model;

import javax.persistence.Entity;

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
public class Nutrition extends AbstractEntity{

	private @Getter @Setter Integer CaloriesFromFat;
	private @Getter @Setter Integer Cholesterol;
	private @Getter @Setter Integer CholesterolPct;
	private @Getter @Setter Integer DietaryFiber;
	private @Getter @Setter Integer DietaryFiberPct;
	private @Getter @Setter Integer MonoFat;
	private @Getter @Setter Integer PolyFat;
	private @Getter @Setter Integer Potassium;
	private @Getter @Setter Integer PotassiumPct;
	private @Getter @Setter Integer Protein;
	private @Getter @Setter Integer ProteinPct;
	private @Getter @Setter Integer SatFat;
	private @Getter @Setter Integer SatFatPct;
	private @Getter @Setter String SingularYieldUnit;
	private @Getter @Setter Integer Sodium;
	private @Getter @Setter Integer SodiumPct;
	private @Getter @Setter Integer Sugar;
	private @Getter @Setter Integer TotalCalories;
	private @Getter @Setter Integer TotalCarbs;
	private @Getter @Setter Integer TotalCarbsPct;
	private @Getter @Setter Integer TotalFat;
	private @Getter @Setter Integer TotalFatPct;
	private @Getter @Setter Integer TransFat;

}

package de.tum.in.foodforme.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class NutritionInfo extends AbstractEntity{
	
	private @Getter @Setter Integer caloriesFromFat;
	private @Getter @Setter Integer cholesterol;
	private @Getter @Setter Integer cholesterolPct;
	private @Getter @Setter Integer dietaryFiber;
	private @Getter @Setter Integer dietaryFiberPct;
	private @Getter @Setter Integer monoFat;
	private @Getter @Setter Integer polyFat;
	private @Getter @Setter Integer potassium;
	private @Getter @Setter Integer potassiumPct;
	private @Getter @Setter Integer protein;
	private @Getter @Setter Integer proteinPct;
	private @Getter @Setter Integer satFat;
	private @Getter @Setter Integer satFatPct;
	private @Getter @Setter String singularYieldUnit;
	private @Getter @Setter Integer sodium;
	private @Getter @Setter Integer sodiumPct;
	private @Getter @Setter Integer sugar;
	private @Getter @Setter Integer totalCalories;
	private @Getter @Setter Integer totalCarbs;
	private @Getter @Setter Integer totalCarbsPct;
	private @Getter @Setter Integer totalFat;
	private @Getter @Setter Integer totalFatPct;
	private @Getter @Setter Integer transFat;

}

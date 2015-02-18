package de.tum.in.foodforme.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends AbstractEntity{

	private @Getter @Setter String userId;
	
	private @Getter @Setter String username;
}

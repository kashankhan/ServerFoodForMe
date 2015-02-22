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
public class UserProfile extends AbstractEntity{

	private @Getter @Setter String userId;
	private @Getter @Setter String name;
	private @Getter @Setter String firstName;
	private @Getter @Setter String lastName;
	private @Getter @Setter String birthday;
	private @Getter @Setter String email;
	private @Getter @Setter String gender;
	private @Getter @Setter String profileLink;

}

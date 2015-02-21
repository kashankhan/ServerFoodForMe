package de.tum.in.foodforme.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOManager {
	private static String PERSISTENCE_UNIT_NAME = "foodforme";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	public static RecipeDAO createRecipeDAO(){
		return new RecipeDAO(factory.createEntityManager());
	}
}
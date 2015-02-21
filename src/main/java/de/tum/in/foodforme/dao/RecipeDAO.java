package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.tum.in.foodforme.model.Recipe;

public class RecipeDAO extends GenericDAO<Recipe>{

	public RecipeDAO(EntityManager em) {
		super(em);
	}

	public Recipe getRecipe(int recipeId){
		TypedQuery<Recipe> q = em.createQuery("select r from Recipe r where r.recipeId=:recipeId", Recipe.class);
		q.setParameter("recipeId", recipeId);
		try {
			return q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Recipe> getRecipes(String keyword){
		keyword = "%" + keyword.toLowerCase() + "%";
		TypedQuery<Recipe> q = em.createQuery("select r from Recipe r where LOWER(r.title) LIKE :keyword"
				+ " OR LOWER(r.category) LIKE :keyword"
				+ " OR LOWER(r.subcategory) LIKE :keyword",
				Recipe.class);
		q.setParameter("keyword", keyword);
		try {
			return q.getResultList();
		}
		catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Recipe> findAll(){
		TypedQuery<Recipe> q = em.createQuery("select r from Recipe r", Recipe.class);
		return q.getResultList();
	}
}

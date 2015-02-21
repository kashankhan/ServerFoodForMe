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
		TypedQuery<Recipe> q = em.createQuery("select r from Recipe r where r.RecipeID=:recipeId", Recipe.class);
		q.setParameter("recipeId", recipeId);
		try {
			return q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
//	TypedQuery<Media> query = em.createQuery("SELECT NEW package_name.Media(m.title, b.isbn, b.authors)
//			+ " FROM Book b, Media m" 
//			+ " WHERE b.isbn = :isbn"                         
//			+ " OR lower(m.title) LIKE :title"                         
//			+ " OR b.authors LIKE :authors", Media.class); 
//	
	public List<Recipe> getRecipes(String keyword){
		keyword = "%" + keyword.toLowerCase() + "%";
		TypedQuery<Recipe> q = em.createQuery("select r from Recipe r where LOWER(r.Title) LIKE :keyword"
				+ " OR LOWER(r.Category) LIKE :keyword"
				+ " OR LOWER(r.Subcategory) LIKE :keyword",
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
		TypedQuery<Recipe> q = em.createQuery("select u from User u", Recipe.class);
		return q.getResultList();
	}
}

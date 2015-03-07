package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.tum.in.foodforme.model.UserFavoriteRecipe;

public class UserFavoriteRecipeDAO  extends GenericDAO<UserFavoriteRecipe>{

	public UserFavoriteRecipeDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserFavoriteRecipe> findAll() {
		try {
			TypedQuery<UserFavoriteRecipe> q = em.createQuery("select u from UserFavoriteRecipe u", UserFavoriteRecipe.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public UserFavoriteRecipe markAsFavorite(String userId, int recipeId, boolean favorite) {
		UserFavoriteRecipe userFavoriteRecipe = null;
		try {
			TypedQuery<UserFavoriteRecipe> q = em.createQuery("select u from UserFavoriteRecipe u where u.recipeId=:recipeId AND u.userId=:userId", UserFavoriteRecipe.class);  
			q.setParameter("userId", userId);
			q.setParameter("recipeId", recipeId);
			List<UserFavoriteRecipe> reuslts = q.getResultList();
			userFavoriteRecipe = reuslts.isEmpty() ? null : reuslts.get(0);
			if(userFavoriteRecipe == null && favorite) {
				userFavoriteRecipe = new UserFavoriteRecipe();
				userFavoriteRecipe.setRecipeId(recipeId);
				userFavoriteRecipe.setUserId(userId);
				save(userFavoriteRecipe);
			}
			else if (userFavoriteRecipe != null && favorite == false) {
				delete(userFavoriteRecipe);
			}
			return userFavoriteRecipe;
		}
		catch(NoResultException e) {
			return null;
		}
	}
}

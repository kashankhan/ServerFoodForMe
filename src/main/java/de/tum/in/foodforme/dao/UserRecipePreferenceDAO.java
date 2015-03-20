package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.tum.in.foodforme.model.UserRecipePreference;

public class UserRecipePreferenceDAO  extends GenericDAO<UserRecipePreference>{

	public UserRecipePreferenceDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserRecipePreference> findAll() {
		try {
			TypedQuery<UserRecipePreference> q = em.createQuery("select u from UserRecipePreference u", UserRecipePreference.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public List<UserRecipePreference> findAll(String userId) {
		try {
			TypedQuery<UserRecipePreference> q = em.createQuery("select u from UserRecipePreference u where u.userId=:userId", UserRecipePreference.class);
			q.setParameter("userId", userId);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public List<UserRecipePreference> findAllRating(Integer starRating) {
		try {
			TypedQuery<UserRecipePreference> q = em.createQuery("select u from UserRecipePreference u where u.starRating=:starRating", UserRecipePreference.class);
			q.setParameter("starRating", starRating);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public Integer rateRecipe(String userId, Integer recipeId, Integer starRating) {
		
		UserRecipePreference userRecipePreference = null;
		try {
			TypedQuery<UserRecipePreference> q = em.createQuery("select u from UserRecipePreference u where u.recipeId=:recipeId AND u.userId=:userId", UserRecipePreference.class);  
			q.setParameter("userId", userId);
			q.setParameter("recipeId", recipeId);
			List<UserRecipePreference> reuslts = q.getResultList();
			userRecipePreference = reuslts.isEmpty() ? null : reuslts.get(0);
			if(userRecipePreference == null) {
				userRecipePreference = new UserRecipePreference();
			}
			userRecipePreference.setRecipeId(recipeId);
			userRecipePreference.setUserId(userId);
			userRecipePreference.setStarRating(starRating);

			save(userRecipePreference);
			
			
			return getRecipeStarRating(recipeId);
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	private Integer getRecipeStarRating(Integer recipeId) {
		
		Integer totalOneStars = findAllRating(1).size();
		Integer totalTwoStars = findAllRating(2).size();
		Integer totalThreeStars = findAllRating(3).size();
		Integer totalFourStars = findAllRating(4).size();
		Integer totalFiveStars = findAllRating(5).size();
		//Rating algo
		Integer rating = (1*totalOneStars+2*totalTwoStars+3*totalThreeStars+4*totalFourStars+5*totalFiveStars)
				/(totalOneStars+totalTwoStars+totalThreeStars+totalFourStars+totalFiveStars);
				
		return rating;
		
	}
}

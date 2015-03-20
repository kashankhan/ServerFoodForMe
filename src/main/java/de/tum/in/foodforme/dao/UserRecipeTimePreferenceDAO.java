package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.tum.in.foodforme.model.UserRecipeTimePreference;

public class UserRecipeTimePreferenceDAO extends
		GenericDAO<UserRecipeTimePreference> {

	public UserRecipeTimePreferenceDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserRecipeTimePreference> findAll() {
		try {
			TypedQuery<UserRecipeTimePreference> q = em.createQuery(
					"select u from UserRecipeTimePreference u",
					UserRecipeTimePreference.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public List<UserRecipeTimePreference> findAll(String userId) {
		try {
			TypedQuery<UserRecipeTimePreference> q = em
					.createQuery(
							"select u from UserRecipeTimePreference u where u.userId=:userId",
							UserRecipeTimePreference.class);
			q.setParameter("userId", userId);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public UserRecipeTimePreference setuserRecipeTimePreference(String userId, Integer perferTiming) {
		
		UserRecipeTimePreference userRecipeTimePreference = null;
		if(userId != null && !userId.isEmpty() && perferTiming != null && perferTiming > 0) {
			List<UserRecipeTimePreference> preferences = findAll(userId);
			if(preferences.isEmpty()) {
				userRecipeTimePreference = new UserRecipeTimePreference();
			}
			else {
				userRecipeTimePreference = preferences.get(0);
			}
			
			userRecipeTimePreference.setUserId(userId);
			userRecipeTimePreference.setPerferTiming(perferTiming);
			save(userRecipeTimePreference);	
		}
		
		return userRecipeTimePreference;
		
	}
}

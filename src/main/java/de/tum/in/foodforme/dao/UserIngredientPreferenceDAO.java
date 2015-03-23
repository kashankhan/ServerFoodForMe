package de.tum.in.foodforme.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.tum.in.foodforme.model.Recipe;
import de.tum.in.foodforme.model.UserIngredientPreference;

public class UserIngredientPreferenceDAO extends GenericDAO<UserIngredientPreference> {

	public UserIngredientPreferenceDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserIngredientPreference> findAll() {
		try {
			TypedQuery<UserIngredientPreference> q = em.createQuery("select u from UserIngredentPreference u", UserIngredientPreference.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public List<UserIngredientPreference> findAll(String userId) {
		try {
			TypedQuery<UserIngredientPreference> q = em.createQuery("select u from UserIngredientPreference u where u.userId=:userId", UserIngredientPreference.class);
			q.setParameter("userId", userId);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public List<UserIngredientPreference> findAll(String userId, boolean favorite) {
		try {
			TypedQuery<UserIngredientPreference> q = em.createQuery("select u from UserIngredientPreference u where u.userId=:userId"
					+ " AND u.favorite=:favorite", UserIngredientPreference.class);
			q.setParameter("userId", userId);
			q.setParameter("favorite", favorite);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	private UserIngredientPreference findUserIngredientPreference(String userId, String ingredient) {
		try {
			TypedQuery<UserIngredientPreference> q = em.createQuery("select u from UserIngredientPreference u where u.userId=:userId"
					+ " AND LOWER(u.ingredient) LIKE :ingredient", UserIngredientPreference.class);
			q.setParameter("userId", userId);
			q.setParameter("ingredient", ingredient);
			return q.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	private  List<UserIngredientPreference> setUserIngredientPreference(String userId, List<String> ingredients, boolean favorite) {
		
		List<UserIngredientPreference> list = new ArrayList<UserIngredientPreference>();
		for(Iterator<String> i = ingredients.iterator(); i.hasNext(); ) {
			String ingredient = i.next();
			UserIngredientPreference  preference = findUserIngredientPreference(userId, ingredient.toLowerCase());
			if(preference == null) {
				preference = new UserIngredientPreference();
			}
			preference.setUserId(userId);
			preference.setFavorite(favorite);
			preference.setIngredient(ingredient);
			if (userId != null && !userId.isEmpty() && ingredient != null && !ingredient.isEmpty()) {
				list.add(preference);
				save(preference);	
			}
		}
		
		return list;
	}

	public List<UserIngredientPreference> setUserIngredientPreference(String userId, List<String> likeIngredients, List<String> dislikeIngredients) {
		List<UserIngredientPreference> list = new ArrayList<UserIngredientPreference>();
		list.addAll(setUserIngredientPreference(userId, likeIngredients, true));
		list.addAll(setUserIngredientPreference(userId, dislikeIngredients, false));
		return list;
	}
	
}


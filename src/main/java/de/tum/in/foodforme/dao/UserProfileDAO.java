package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


import de.tum.in.foodforme.model.UserProfile;

public class UserProfileDAO extends GenericDAO<UserProfile> {

	public UserProfileDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public UserProfile getUserProfile(String userId){
		TypedQuery<UserProfile> q = em.createQuery("select u from UserProfile u where u.userId=:userId", UserProfile.class);
		q.setParameter("userId", userId);
		try {
			return q.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	@Override
	public List<UserProfile> findAll() {
		try {
			TypedQuery<UserProfile> q = em.createQuery("select u from UserProfile u", UserProfile.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import lombok.Getter;
import lombok.Setter;
import de.tum.in.foodforme.model.UserProfile;

public class UserProfileDAO extends GenericDAO<UserProfile>{

	public UserProfileDAO(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	public UserProfile getUserProfile(String email){
		TypedQuery<UserProfile> q = em.createQuery("select u from UserProfile u where u.email=:email", UserProfile.class);
		q.setParameter("email", email);
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
	
	public UserProfile saveUserProfile(UserProfile requestUserProfile) {
		UserProfile profile = getUserProfile(requestUserProfile.getEmail());
		if (profile == null) {
			profile = new UserProfile();	
		}
		profile.setEmail(requestUserProfile.getEmail());
		profile.setUserId(requestUserProfile.getUserId());
		profile.setName(requestUserProfile.getName());
		profile.setFirstName(requestUserProfile.getFirstName());
		profile.setLastName(requestUserProfile.getLastName());
		profile.setBirthday(requestUserProfile.getBirthday());
		profile.setEmail(requestUserProfile.getEmail());
		profile.setGender(requestUserProfile.getGender());
		profile.setProfileLink(requestUserProfile.getProfileLink());
		
		save(profile);
		return profile;
	}

}

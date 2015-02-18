package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;

import de.tum.in.foodforme.model.AbstractEntity;

public abstract class GenericDAO<T extends AbstractEntity> {
	protected EntityManager em;

	public GenericDAO(EntityManager em) {
		this.em = em;
	}

	public void save(T t){
		em.getTransaction().begin();
		if(t.getId() != null)
			em.persist(t);
		else 
			t = em.merge(t);
		em.getTransaction().commit();
	}

	public abstract List<T> findAll();
}

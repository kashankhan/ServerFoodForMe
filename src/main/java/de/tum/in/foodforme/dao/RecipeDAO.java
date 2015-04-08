package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.impl.AvalonLogger;

import de.tum.in.foodforme.model.Ingredient;
import de.tum.in.foodforme.model.Recipe;
import de.tum.in.foodforme.model.UserRecipePreference;

public class RecipeDAO extends GenericDAO<Recipe> {

	private final UserRecipePreferenceDAO userRecipePreferenceDAO = DAOManager
			.createUserRecipePreferenceDAO();
	private final UserIngredientPreferenceDAO  userIngredentPreferenceDAO = DAOManager.
			createUserIngredentPreferenceDAO();
	private final UserRecipeTimePreferenceDAO userRecipeTimePreferenceDAO = DAOManager.
			createUserRecipeTimePreferenceDAO();

	public RecipeDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<Recipe> findAll() {
		try {
			TypedQuery<Recipe> q = em.createQuery("select r from Recipe r",
					Recipe.class);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Recipe getRecipe(int recipeId) {
		try {
			TypedQuery<Recipe> q = em.createQuery(
					"select r from Recipe r where r.recipeId=:recipeId",
					Recipe.class);
			q.setParameter("recipeId", recipeId);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Recipe> getRecipes(String keyword) {
		try {
			keyword = "%" + keyword.toLowerCase() + "%";
			TypedQuery<Recipe> q = em.createQuery(
					"select r from Recipe r where LOWER(r.title) LIKE :keyword"
							+ " OR LOWER(r.category) LIKE :keyword"
							+ " OR LOWER(r.subcategory) LIKE :keyword",
					Recipe.class);
			q.setParameter("keyword", keyword);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Recipe> getRecipes(String keyword, Integer page,
			Integer resultPerPage) {
		try {
			keyword = "%" + keyword.toLowerCase() + "%";
			TypedQuery<Recipe> q = em.createQuery(
					"select r from Recipe r where LOWER(r.title) LIKE :keyword"
							+ " OR LOWER(r.category) LIKE :keyword"
							+ " OR LOWER(r.subcategory) LIKE :keyword",
					Recipe.class);
			q.setParameter("keyword", keyword);
			q.setFirstResult(page).setMaxResults(resultPerPage);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Ingredient> getIngredients(String keyword) {
		try {
			keyword = "%" + keyword.toLowerCase() + "%";
			TypedQuery<Ingredient> q = em
					.createQuery(
							"SELECT i from Ingredient i where LOWER(i.name) LIKE :keyword",
							Ingredient.class);
			q.setParameter("keyword", keyword);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Recipe> getPopularRecipes(Integer resultSize, String course) {
		try {
			// query
			boolean requireParameters = true;
			String query = "select r from Recipe r where r.starRating > 3"; 
			if(!course.isEmpty()) {
				query = query + " AND LOWER(r.course) LIKE :course";
				requireParameters = false;
			}
			TypedQuery<Recipe> q = em.createQuery(query,
					Recipe.class);
			q.setMaxResults(resultSize);
			if(requireParameters) {
				q.setParameter("course", course);
			}
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Recipe> getUnSyncRecipes() {
		try {
			TypedQuery<Recipe> q = em.createQuery(
					"select r from Recipe r where r.instructions IS NULL",
					Recipe.class);
			q.setMaxResults(25);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void rateRecipe(Integer recipeId, String userId, Integer starRating, 
			List<String> likeIngredients, List<String> dislikeIngredients) {
		try {
			Integer usersStarRating = userRecipePreferenceDAO.rateRecipe(userId, recipeId, starRating);
			Recipe recipe = getRecipe(recipeId);
			if (recipe != null && usersStarRating > 0) {
				usersStarRating = (recipe.getStarRating() + usersStarRating) /2;
				recipe.setStarRating(usersStarRating);
				save(recipe);
			}
			
			userIngredentPreferenceDAO.setUserIngredientPreference(userId, likeIngredients, dislikeIngredients);
			
		} catch (NoResultException e) {

		}
	}
	
	public List<String> getAllCourses() {
		try {
			TypedQuery<String> q = em.createQuery(
					"select DISTINCT r.category from Recipe r  where r.category != \"\"",
					String.class);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}

package de.tum.in.foodforme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.impl.AvalonLogger;

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

	public List<Recipe> favoriteIngredentRecipes(String keyword) {
		try {
			keyword = "%" + keyword.toLowerCase() + "%";
			TypedQuery<Recipe> q = em
					.createQuery(
							"select r from Recipe r where"
									+ "r.ingredients.name = ANY (SELECT i from Ingredient where LOWER(i.name) LIKE :keyword)",
							Recipe.class);
			q.setParameter("keyword", keyword);
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Recipe> getPopularUniqueRecipes(Integer resultSize) {
		try {
			// TODO, First fetch primary ingredient and based on that create
			// query
			TypedQuery<Recipe> q = em.createQuery("select r from Recipe r where r.starRating > 3",
					Recipe.class);
			q.setMaxResults(resultSize);
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
			List<String> likeIngredients, List<String> dislikeIngredients, Integer perferTiming) {
		try {
			Integer usersStarRating = userRecipePreferenceDAO.rateRecipe(userId, recipeId, starRating);
			Recipe recipe = getRecipe(recipeId);
			if (recipe != null && usersStarRating > 0) {
				usersStarRating = (recipe.getStarRating() + usersStarRating) /2;
				recipe.setStarRating(usersStarRating);
				//save(recipe);
			}
			
			userIngredentPreferenceDAO.setUserIngredientPreference(userId, likeIngredients, dislikeIngredients);
			userRecipeTimePreferenceDAO.setuserRecipeTimePreference(userId, perferTiming);
			
		} catch (NoResultException e) {

		}
	}
}

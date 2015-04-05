package de.tum.in.foodforme.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeRecommendationDAO;
import de.tum.in.foodforme.model.RecommendedRecipe;


@Controller
@RequestMapping("/rest/recommendation")
public class RecipeRecommendation {

	private final RecipeRecommendationDAO recommendationDAO = DAOManager.createRecipeRecommendationDAO();
	
	@RequestMapping(value="/myrecommendations")
	@ResponseBody
	public List<RecommendedRecipe> getMyRecommendations(@RequestParam(value="userId", required=true) String userId){
		List<RecommendedRecipe> recipes = recommendationDAO.getUserRecipeRecommendation(userId);
		return recipes;
	}
}

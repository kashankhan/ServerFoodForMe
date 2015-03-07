package de.tum.in.foodforme.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.RecipeRecommendationDAO;
import de.tum.in.foodforme.model.Recipe;


@Controller
@RequestMapping("/rest/recommendation")
public class RecipeRecommendation {

	private final RecipeRecommendationDAO recommendationDAO = DAOManager.createRecipeRecommendationDAO();
	
	@RequestMapping(value="/myrecommendations")
	@ResponseBody
	public List<Recipe> getMyRecommendations(@RequestParam(value="userid", required=true) String userId){
		List<Recipe> recipes = recommendationDAO.userRecipeRecommendation(userId);
		return recipes;
	}
}

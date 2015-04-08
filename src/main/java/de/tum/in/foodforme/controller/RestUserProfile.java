package de.tum.in.foodforme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.UserProfileDAO;
import de.tum.in.foodforme.model.UserProfile;

@Controller
@RequestMapping("/rest/userprofile")
public class RestUserProfile {
	private final UserProfileDAO  userProfileDAO = DAOManager.createUserProfileDAO();
	
	@RequestMapping(value = "/saveuserprofile", method = RequestMethod.POST)
	public @ResponseBody UserProfile register(@RequestBody UserProfile resquestProfile,  
			HttpServletRequest request, HttpServletResponse response) { 
		UserProfile userProfile = null;
		if(resquestProfile.getEmail() != null && !resquestProfile.getEmail().isEmpty()
				&& resquestProfile.getUserId() != null && !resquestProfile.getUserId().isEmpty()) {
			// Check User Profile if exist
			userProfile = userProfileDAO.saveUserProfile(resquestProfile);
		}
		return userProfile;
	}
	
}

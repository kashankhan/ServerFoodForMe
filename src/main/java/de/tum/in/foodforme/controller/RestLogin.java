package de.tum.in.foodforme.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.dao.DAOManager;
import de.tum.in.foodforme.dao.UserProfileDAO;
import de.tum.in.foodforme.model.UserProfile;

@Controller
@RequestMapping("/rest/login")
public class RestLogin {
	
	private final UserProfileDAO  userProfileDAO = DAOManager.createUserProfileDAO();
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody UserProfile register(@RequestBody UserProfile resquestProfile,  
			HttpServletRequest request, HttpServletResponse response) { 
		UserProfile userProfile = null;
		if(resquestProfile.getEmail() != null && !resquestProfile.getEmail().isEmpty() ) {
			// Check User Profile if exist
			userProfile = userProfileDAO.getUserProfile(resquestProfile.getEmail());
			if(userProfile == null) {
				userProfileDAO.save(resquestProfile);
				userProfile = resquestProfile;
			}
		}
		return userProfile;
	}
	
	@RequestMapping(value = "/loginuser", method = RequestMethod.GET)
	@ResponseBody
	public UserProfile login(@RequestParam("email") String email){
		UserProfile userProfile = null;
		if(email != null && !email.isEmpty() ) {
			// Check User Profile if exist
			userProfile = userProfileDAO.getUserProfile(email);
		}
		return userProfile;
	}

	 
//	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//	public @ResponseBody String get(@PathVariable("id") String uId) {
//		return uId;
//    }	

	
//	
//	@RequestMapping(value = "/get2/{id}", method = RequestMethod.GET)
//	public @ResponseBody UserProfile test(@PathVariable("id") String acId,
//			@RequestParam(value="query", required=false) String query) {
//		//return new UserProfile(query, query);
//		return new UserProfile();
//    }
}

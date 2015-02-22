package de.tum.in.foodforme.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.model.UserProfile;

@Controller
@RequestMapping("/rest/login")
public class RestLogin {
	
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	@ResponseBody
	public UserProfile register(@RequestBody UserProfile userProifle) {
		return userProifle;
	}
//	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//	public @ResponseBody UserProfile get(@PathVariable("id") String uId) {
//		return new UserProfile();
//    }	
//
	
//	
//	@RequestMapping(value = "/get2/{id}", method = RequestMethod.GET)
//	public @ResponseBody UserProfile test(@PathVariable("id") String acId,
//			@RequestParam(value="query", required=false) String query) {
//		//return new UserProfile(query, query);
//		return new UserProfile();
//    }
}

package de.tum.in.foodforme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import de.tum.in.foodforme.model.Recipe;
import de.tum.in.foodforme.model.UserProfile;

@Controller
@RequestMapping("/rest/login")
public class RestLogin {

	
//	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//	public @ResponseBody UserProfile get(@PathVariable("id") String uId) {
//		return new UserProfile();
//    }	
//
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	@ResponseBody
//	public void register(@RequestBody UserProfile dto) {
//	}
//	
//	@RequestMapping(value = "/get2/{id}", method = RequestMethod.GET)
//	public @ResponseBody UserProfile test(@PathVariable("id") String acId,
//			@RequestParam(value="query", required=false) String query) {
//		//return new UserProfile(query, query);
//		return new UserProfile();
//    }
}

package de.tum.in.foodforme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.tum.in.foodforme.model.User;

@Controller
@RequestMapping("/rest/login")
public class RestLogin {

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody User get(@PathVariable("id") String uId) {
		return new User(uId, uId);
    }	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public void register(@RequestBody User dto) {
	}
	
	@RequestMapping(value = "/get2/{id}", method = RequestMethod.GET)
	public @ResponseBody User test(@PathVariable("id") String acId,
			@RequestParam(value="query", required=false) String query) {
		return new User(query, query);
    }
}

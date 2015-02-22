package de.tum.in.foodforme.dto;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenericDTO {

	JsonObject getJsonObject(String response) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject)parser.parse(response);
		return jsonObject;
	}
	
	boolean hasObject(JsonObject object, String attribute) {
		boolean exists = false;
		if(object.has(attribute) && object.get(attribute).isJsonNull()) {
		    //it has it, do appropriate processing
			exists = true;
		}
		return exists;
	}
}

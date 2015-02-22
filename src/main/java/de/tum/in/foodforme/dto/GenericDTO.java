package de.tum.in.foodforme.dto;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenericDTO {

	JsonObject getJsonObject(String response) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject)parser.parse(response);
		return jsonObject;
	}
}

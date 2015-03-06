package de.tum.in.foodforme.dto;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenericDTO {

	JsonObject getJsonObject(String response) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject)parser.parse(response);
		return jsonObject;
	}

	boolean hasJsonObject(JsonObject object, String propertyName) {
		boolean exists = false;
		if(object.has(propertyName) && !object.get(propertyName).isJsonNull()) {
			exists = true;
		}
		return exists;
	}
	
	int getJsonObjectAsInt(JsonObject jsonObject, String propertyName) {
		int value = hasJsonObject(jsonObject, propertyName) ? jsonObject.get(propertyName).getAsInt() : 0;
		return value;
	}
	
	boolean getJsonObjectAsBoolean(JsonObject jsonObject, String propertyName) {
		boolean value = hasJsonObject(jsonObject, propertyName) ? jsonObject.get(propertyName).getAsBoolean(): false;
		return value;
	}
	
	String getJsonObjectAsString(JsonObject jsonObject, String attribute) {
		String value = hasJsonObject(jsonObject, attribute) ? jsonObject.get(attribute).getAsString(): "";
		return value;
	}
	
	
}

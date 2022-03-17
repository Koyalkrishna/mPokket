package com.mpokket.util;

import io.restassured.response.Response;

public class JsonUtil {
	
	public static Object getJsonResponseValue(Response response,String jsonPath) {
		Object value= (Object)response.getBody().jsonPath().get(jsonPath);
		return value;
	}

}

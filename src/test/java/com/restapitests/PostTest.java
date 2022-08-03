package com.restapitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostTest {
	
	@Test
	public void postTest() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject obj = new JSONObject();
		obj.put("name", "Shanawaz");
		obj.put("job", "SDET");
		
		given().header("Content-Type",ContentType.JSON)
		.body(obj.toJSONString())
		.when().post("/users")
		.then()
		.statusCode(201)
		.log().all()
		.body("name", equalTo("Shanawaz"))
		.body("job", equalTo("SDET"));


	}

}

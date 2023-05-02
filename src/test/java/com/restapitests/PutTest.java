package com.restapitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutTest {
	
	@Test
	public void putTest() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject obj = new JSONObject();
		obj.put("name", "Mansuri");
		obj.put("job", "SDET Lead");
		
		given().header("Content-Type",ContentType.JSON)
		.body(obj.toJSONString())
		.when().put("/users/2")
		.then()
		.statusCode(200)
		.log().all()
		.body("name", equalTo("Mansuri"))
		.body("job", equalTo("SDET Lead"));


	}

}

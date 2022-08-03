package com.restapitests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteTest {
	
	@Test
	public void deleteTest() {
		

		baseURI = "https://reqres.in/api";
		given()
		.contentType(ContentType.JSON)
		.when().delete("/users/2")
		.then()
		.statusCode(204)
		.log().all();


	}

}

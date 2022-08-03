package com.restapitests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;


import org.hamcrest.Matcher;

public class GetTest {

	@Test
	public void getTest() {
		
		baseURI = "https://reqres.in/api";
		given()
		.contentType(ContentType.JSON)
		.when().get("/users?page=2")
		.then()
		.statusCode(200)
		.log().all()
		.body("data[0].id", equalTo(7))
		.body("data[0].email", equalTo("michael.lawson@reqres.in"))
		.body("data[0].first_name", equalTo("Michael"))
		.body("data[0].last_name", equalTo("Lawson"));


	}

}

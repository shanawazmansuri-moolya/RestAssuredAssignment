package latestGet;

import static io.restassured.RestAssured.*;

import java.net.http.HttpResponse.BodyHandler;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class SimpleGet {

	RequestSpecification reqsp;
	ResponseSpecification ressp;

	@Ignore
	@Test
	public void get1() {

		given().when().get("https://api.zippopotam.us/us/90210").then().assertThat().body("places[0].'place name'",
				equalTo("Beverly Hills"));
	}

	@Ignore
	@Test
	public void get2() {

		reqsp = new RequestSpecBuilder().setBaseUri("https://api.zippopotam.us").setContentType(ContentType.JSON)
				.build();
		ressp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

		given().spec(reqsp).when().get("https://api.zippopotam.us/us/90210").then().spec(ressp);
	}

	@Ignore

	@Test
	public void get3() {

		String value = given().when().get("https://api.zippopotam.us/us/90210").then().extract().jsonPath()
				.get("places[0].'place name'");

		System.out.println("Value is " + value);
	}

	@Ignore
	@Test
	public void get4() {

		String body = given().when().get("https://api.zippopotam.us/us/90210").then().extract().body().asPrettyString();

		System.out.println("Body is " + body);
	}

	@Ignore
	@Test
	public void get5() {

		ValidatableResponse body = given().when().get("https://api.zippopotam.us/us/90210").then().log().all();

		System.out.println("Body is " + body);
	}

	@Test
	public void get6() {

		ValidatableResponse body = given().when().get("https://api.zippopotam.us/us/90210").then().log().all();

		System.out.println("Body is " + body);
	}

}

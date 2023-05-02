package latestGet;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import groovy.transform.stc.POJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Deserilization {
	
	
	
	@Ignore
	@Test
	public void get1()
	{
		baseURI = "http://localhost:8000/posts";
		
		Response res = given().contentType(ContentType.JSON).when().get().andReturn();
		
		System.out.println(res.asPrettyString());
		
		
		System.out.println("----------------------------------------------");
		
		String body = res.getBody().asPrettyString();
		
		System.out.println(body);
		
		
		
	}
	
	@Test
	public void get2()
	{
		baseURI = "http://localhost:8000/posts";
		
		Pojo2 pj = given().when().get().as(Pojo2.class);
		
		System.out.println(pj.getId());
		
		
	}

}

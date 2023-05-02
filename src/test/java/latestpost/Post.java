package latestpost;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;

public class Post {

	@Ignore
	@Test
	public void post1() throws JsonProcessingException {
		JsonMapper mp = new JsonMapper();
		ObjectNode nd = mp.createObjectNode();

		nd.put("Id", "1");
		nd.put("title", "NoorFatima");
		nd.put("author", "Java");

		String json = mp.writerWithDefaultPrettyPrinter().writeValueAsString(nd);

		System.out.println(json);

		given().body(json).when().post("http://localhost:8000/posts").then().statusCode(201);
	}

	@Ignore
	@Test
	public void post2() throws JsonProcessingException {
		Pojo pj = new Pojo();
		pj.setId(3);
		pj.setTitle("Nawaz");
		pj.setAuthor("Shanawaz");

		ObjectMapper oj = new ObjectMapper();
		String json2 = oj.writerWithDefaultPrettyPrinter().writeValueAsString(pj);

		System.out.println(json2);

		given().body(json2).when().post("http://localhost:8000/posts").then().statusCode(201);

	}
	
	@Ignore
	@Test
	public void post3() throws JsonProcessingException
	{
	
	RestAssured.baseURI = "http://localhost:8000/posts";
	
	
		Pojo2 pj2 = new Pojo2();
		pj2.setId(4);
		pj2.setTitle("Nilo");
		pj2.setAuthor("Nawazi");
		
		ObjectMapper omj = new ObjectMapper();
		String json3 = omj.writerWithDefaultPrettyPrinter().writeValueAsString(pj2);
		
		System.out.println(json3);
		
		given().body(json3).when().post().then().statusCode(201);
	}
	
	@Test
	public void post4() throws JsonProcessingException
	{
	
	RestAssured.baseURI = "http://localhost:8000/posts";
	
	
	
	
		
		given().body("[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 7,\r\n"
				+ "    \"title\": \"json-\",\r\n"
				+ "    \"author\": \"typi\"\r\n"
				+ "  },").when().post().then().statusCode(201);
	}
}
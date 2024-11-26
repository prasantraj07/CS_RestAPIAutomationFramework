package API_Practice;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class APIPlay
	{
		
		void test() 
		{
			
			String requestPayload = "{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
					+ "}";
			
			
			RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(requestPayload)
			.when()
				.post()
			.then()
				.statusCode(200)
				.body("token", Matchers.notNullValue())
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonFile.json"))
				.log()
				.all();		
		
		}
		
		public static void main(String[] args) 
		{
			APIPlay obj = new APIPlay();
			obj.test();
			
			
		}
		
		
	}




















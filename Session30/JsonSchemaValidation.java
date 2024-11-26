package Session30;

//Json Schema Validation with RestAssured:

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

public class JsonSchemaValidation 
{
	
	void testMethod() 
	{
		
		String requestPayload = "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "    \r\n"
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
			//.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Asus\\Downloads\\JsonFile.json")))
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonFile.json"))			
			.log()
			.all();
		
			
	}
	
	public static void main(String[] args) 
	{
		JsonSchemaValidation obj = new JsonSchemaValidation();
		obj.testMethod();
		
	}
	

}











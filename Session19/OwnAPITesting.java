package Session19;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OwnAPITesting 
{
	void readUserData() 
	{
		//create request specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify url:
		requestSpec.baseUri("http://localhost:3000");
		requestSpec.basePath("/users");
		
		//perform get request:
		Response response = requestSpec.get();
		
		//print response body:
		response.prettyPrint();
		
		//validate status code:
		Assert.assertEquals(response.statusCode(), 200, "Check for status code");
	
	}
	
	public static void main(String[] args) 
	{
		OwnAPITesting obj = new OwnAPITesting();
		obj.readUserData();
		
	}

}

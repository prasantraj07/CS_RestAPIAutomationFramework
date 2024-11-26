package Session03;

//Get Request -> //print response code, response body, response header, time.


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GetMethod 
{

	@Test
	public void test01()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("Response Code:"+ response.getStatusCode());
		System.out.println("Response  body:"+ response.getBody().asString());
		System.out.println("Response Time:"+ response.getTime());
		
		//we have to pass the 'Key' as argument in the getHeader() method:
		System.out.println("Response Header:"+ response.getHeader("Content-Type"));
		
		//Validate Status code:
		//expected status code = 200
		
		int expectedStatusCode = 200; 	//Expected value
		int actualStatusCode = response.getStatusCode(); 	//Actual value
		
		Assert.assertEquals(expectedStatusCode, actualStatusCode); //'200' is Expected value

		
	}
	
	//BDD Test case:
	
	/*
	 
	@Test
	public void test02() 
	{
		//given, when, then
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured
		.given()
			.queryParam("page", "2")	//Query Parameter and value
		.when()
			.get()
		.then()
			.statusCode(200)
			.log()
			.all();
		
	}
	
	*/
	
	
	
	
}

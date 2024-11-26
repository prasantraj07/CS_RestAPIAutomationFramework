package Session08;

import org.testng.Assert;

//No credential -> 401 Unauthorized Status, Authentication False
//Credential provided -> 200 Ok Status, Authentication True

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization 
{
	
	//1. basic-auth:
	@Test
	public void BasicAuth() 
	{
		RequestSpecification requestSpec = RestAssured.given();
		
		//Specify URL:
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		//Perform get request(Non Preemptive):
		Response response = requestSpec.auth().basic("postman", "password1").get();
		
		//Pre-emptive:
		//requestSpec.auth().preemptive().basic("postman", "password").get();
		
		//print status line:
		System.out.println("Response Status:" + response.statusLine());
		System.out.println("Response Body:" + response.body().asString());
		
		
	}
	
	//2. Digest-auth:
	@Test
	public void DigestAuth() 
	{
		
		//https://httpbin.org/digest-auth/undefined/prasant/prasant
		RequestSpecification requestSpec = RestAssured.given();
		
		//Specify URL:
		requestSpec.baseUri("https://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/prasant/prasant");
		
		//Perform get request:
		//Response response = requestSpec.get();
		Response response = requestSpec.auth().digest("prasant", "prasant1").get();
		
		Assert.assertEquals(response.statusCode()/*actual*/, 200, "Check for status code");
		
		//print status line:
		System.out.println("DigestAuth Response Status:" + response.statusLine());
		System.out.println("DigestAuth Response Body:" + response.body().asString());
		
		
	}
}

package Session05;

//https://reqres.in/api/users/2

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader 
{
	
	@Test
	public void GetSingleUser() 
	{
		//Get Request Specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri:
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request:
		Response response = requestSpec.get();
		
		//validate Single response header:
		String connection = response.getHeader("Connection");
		System.out.println(connection);
		
		/*
		//Read all the response header & print their values:
		Headers headersList = response.getHeaders();
		
		//iterate over header list:
		for(Header header:headersList) 
		{
			System.out.println("Key:"+ header.getName() + "Value:"+ header.getValue());
		}
		*/
		
		//validate Header 'Content-Type':
		String contentType = response.getHeader("Content-Type"); 	//expected value
		Assert.assertEquals(contentType, "application/json; charset=utf-81", "Header contentType mismatch");
		
		
		
		
		
		
		
		
	}
	
}

package Session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

//https://reqres.in/api/users?page=2


public class ValidateJsonResponseBody 
{
	
	@Test
	public void UserListResponseBody() 
	{
		//Get RequestSpecification Reference:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base URI:
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=2");
		
		//Create or perform get request:
		Response response = requestSpec.get();
		
		//Read response body:
		ResponseBody responseBody = response.getBody();
		
		/*
		String responseString = responseBody.asString();
		
		//print response body:
		System.out.println("Response body:"+ responseString);
		
		//check for presence of George in response body:
		Assert.assertEquals(responseString.contains("George"), true, "Check for presence of George");
		*/
		
		//get json path view of response body:
		JsonPath jsonPathView = responseBody.jsonPath();
		
		// x.data[0].first_name
		// Got array element value from JsonPathFinder tool:
		String firstName = jsonPathView.get("data[0].first_name");
		
		Assert.assertEquals(firstName, "George", "Check for presence of first name as George");
		
		//Printing 2nd array element email value:
		System.out.println("email address:"+ jsonPathView.get("data[1].email"));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

 package Session07;
 
//Use JSON Path Finder tool to understand response Body in below code:
 
import org.testng.Assert;

//https://reqres.in/api/users

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo 
{
	@Test
	public void filterData() 
	{
		//Get Request Specification for the given request:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify url:
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		requestSpec.queryParam("page", 2).queryParam("id", 10); //query parameter and value
		
		//Perform get request:
		Response response = requestSpec.get();
		
		//read response body:
		String responseBodyString = response.getBody().asString();
		
		//print response body:
		System.out.println("Response Body:"+responseBodyString);
		
		//get json path view of response body:
		JsonPath jsonPathView = response.jsonPath();
		
		//get first name:
		//x.data.first_name
		String firstName = jsonPathView.get("x.data.first_name");
		
		Assert.assertEquals(firstName, "Byron", "Verify firstname:");
		
		
		
	}

}

package Session04;

//Response(status code) Validation of https://reqres.in/api/users/2
//We have Multiple ways of validating a response in Rest Assured.

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class ResponseValidation 
{
	
	@Test(enabled = false)
	public void GetSingleUser() 
	{
		//specify base URL:
		baseURI = "https://reqres.in/api/users/2";
		
		//Get Request Specification of the Request:
		RequestSpecification requesSpec = given();
		
		//call get method:
		Response response = requesSpec.get();
		
		//gets response code:
		int statusCode = response.getStatusCode();
		
		//validate actualstatuscode with expected:
		
		Assert.assertEquals(statusCode/*actual status code*/,200/*expected status code*/,"Correct status code recieved");
		
		//status line has :
		//protocol, status code & String
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "incorrect status line returned");
		
	
	}
	
	@Test
	public void GetSingleUserUsingValidatableResponse() 
	{
		//specify base URL:
		baseURI = "https://reqres.in/api/users/2";
		
		//Get Request Specification of the Request:
		RequestSpecification requesSpec = given();
		
		//call get method:
		Response response = requesSpec.get();
		
		ValidatableResponse validateRes = response.then();
		
		//status Code:
		//validateRes.statusCode(200);
		
		//System.out.println("second validation");
		//status Line:
		validateRes.statusLine("HTTP/1.1 200 OK");
		
	}
	
	//BDD style test case:
	
	/*
	public void GetSingleUser_BDDStyle() 
	{
		given();
		
		when()
		.get("https://reqres.in/api/users/2");
		
		then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
	
	}
	*/

}

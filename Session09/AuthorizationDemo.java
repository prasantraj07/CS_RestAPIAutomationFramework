package Session09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo 
{
	
	@Test
	public void BearerToken() 
	{
		//https://gorest.co.in/public/v2/users
		//Create Request Specification:
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "CodeLive03");
		payload.put("gender", "Male");
		payload.put("email", "prasu123@gmail.com");
		payload.put("status", "Active");
		
		String AuthToken = "Bearer f7d7c3866a013f454609ad5bcbc790f98f4cee38143cb8315b92ee96db3e07f1";
		
		requestSpec.headers("Authorization", AuthToken).contentType(ContentType.JSON)
		.body(payload.toJSONString());
		
		//Perform Post Request:
		Response response = requestSpec.post();
		
		Assert.assertEquals(response.statusCode()/*actual*/, 201, "Check for status code");
		
		//print status line:
		System.out.println("DigestAuth Response Status:" + response.statusLine());
		System.out.println("DigestAuth Response Body:" + response.body().asString());
		

	}

}

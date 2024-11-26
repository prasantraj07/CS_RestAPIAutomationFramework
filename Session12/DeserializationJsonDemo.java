package Session12;

//class object to byte stream conversion (Serialization)
//byte stream to class object conversion (Deserialization)

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializationJsonDemo 
{
	@Test
	public void createUser() 
	{
		//https://reqres.in/api/users
		//create Request Specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL:
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		
		//create Request body:
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Prasu");
		jsonData.put("job", "QA");
		
		
		//perform Post request:
		Response response = requestSpec //this 'response' is in byte stream
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.post();
		
		System.out.println(response);
		
		ResponseBody responseBody = response.getBody();
		
		System.out.println(responseBody);
		
		//Deserialize responseBody i.e. json response body to class object:
		
		JsonPostRequestResponse responseClass = responseBody.as(JsonPostRequestResponse.class);
		
		Assert.assertEquals(responseClass.name, "Prasu","check for name");
		Assert.assertEquals(responseClass.job, "QA","check for job");
		
		
	}

}

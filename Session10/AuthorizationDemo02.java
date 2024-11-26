package Session10;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo02 
{
	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	
	@Test
	public void GetWeatherDataByCity() 
	{
		//Create request specification:
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q", "Patna").queryParam("appid", "704803df657f16669ff410158fdf7750");
		Response response = requestSpec.get();
		
		//actual value, expected value, message:
		Assert.assertEquals(response.statusCode()/*actual*/, 200, "Check for status code");
		
		//print status line & response Body:
		System.out.println("DigestAuth Response Status:" + response.statusLine());
		System.out.println("DigestAuth Response Body:" + response.body().asString());
		
		
	}
	
	
	

}

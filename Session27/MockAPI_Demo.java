package Session27;

//How to Mock API JSON Response Easily & Quickly:
// Mock API webiste -> https://designer.mocky.io
// https://run.mocky.io/v3/bfcf2cf0-04e3-41b3-be98-ecdc574ff81b

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class MockAPI_Demo 
{
	
	void test1() 
	{
		//create request specification:
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://run.mocky.io/v3/4f5d3c94-8a9e-412e-bd62-10b25ece5a9a");
		
		//perform get Request:
		Response response = requestSpec.get();
		
		//print Response Body:
		response.prettyPrint();
		
		if(response.statusCode() == 200) 
		{
			System.out.println("Correct status code");
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		
	}
	
	public static void main(String[] args) 
	{
		MockAPI_Demo obj = new MockAPI_Demo();
		obj.test1();		
	}
	
	

}

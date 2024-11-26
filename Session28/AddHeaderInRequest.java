package Session28;

import java.util.ArrayList;

// How to add Header or Headers in Request:

/*

Key:"Header1"
value:"Value1"

 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeaderInRequest 
{
	
	void testMethod1() 
	{
		
		
		Header header1 = new Header("Header1", "Value1");
		Header header2 = new Header("Header2", "Value2");
		Header header3 = new Header("Header3", "Value3");
		
		List<Header> headerList = new ArrayList<Header>();
		headerList.add(header1);
		headerList.add(header2);
		headerList.add(header3);
		
		Headers headersObj = new Headers(headerList);
		
		/*
		 
		Map<String, String> requestHeader = new HashMap<>();
		requestHeader.put("Header1", "Value1");
		requestHeader.put("Header2", "Value2");
		
		RequestSpecification requestSpec = RestAssured.given();
		
		//add header or headers:
		//requestSpec.header("Header1", "Value1");
		
		//requestSpec.headers(requestHeader);
		
		//requestSpec.header(requestHeaderObj);
		
		requestSpec.headers(headersObj);
		requestSpec.log().headers();
		
		requestSpec.baseUri("https://reqres.in/api/users?page=1");
		
		//perform Get Request:
		Response response = requestSpec.get();
		//response.prettyPrint();
		
		//validate Response code:
		if(response.statusCode() == 200) 
		{
			System.out.println("Correct status code");	
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		*/
		
		//BDD Style(Given, when, then):
		
		RestAssured
		.given()
			.headers(headersObj)
			.log()
			.headers()
		.when()
			.get("https://reqres.in/api/users?page=1")
		.then()
			.log()
			.body();
		
		
	}
	
	public static void main(String[] args) 
	{
		AddHeaderInRequest obj = new AddHeaderInRequest();
		obj.testMethod1();
		
	}
		
}
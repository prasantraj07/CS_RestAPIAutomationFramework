package Session29;

//Basic Principle of coding is 'Do not repeat the common code.'
//ResponseSpecBuilder class -> it allows you to create response specifications.

/*
StatusCode = 200
StatusLine = “HTTP/1.1 200 OK”
ContentType = ContentType.JSON
ResponseTime = 3000ms

*/

import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec_Demo 
{
	
	
	ResponseSpecification responseSpec = null;
	
	public void createResponseSpec() 
	{
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		
		//Method 1:
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectStatusLine("HTTP/1.1 200 OK");
		responseBuilder.expectContentType(ContentType.JSON);
		responseBuilder.expectResponseTime(Matchers.lessThan(5000L));
		
		//Method 2:
		responseBuilder
		.expectStatusCode(200)
		.expectStatusLine("HTTP/1.1 200 OK")
		.expectContentType(ContentType.JSON)
		.expectResponseTime(Matchers.lessThan(5000L));
		
		responseSpec = responseBuilder.build();
		
		
	}
	
	
	void getAllBookingIds() 
	{
		
		RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com/booking")
		.when()
			.get()
		.then()
			.spec(responseSpec)
			.body("size()", Matchers.greaterThan(0));
			
		//responseBuilder code is created in createResponseSpec method for below Common code:
		/*
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000L))
			.log()
			.all();
		*/
		
	}
	
	void getBookingByName() 
	{
		
		RestAssured
		.given()
			.baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally")
		.when()
			.get()
		.then()
			.spec(responseSpec); //this line is for calling common Response Specifications or assertions:
			
		
		//responseBuilder code is created in createResponseSpec method for below Common code:
		/*	
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000L))
			.log()
			.all();
		*/
		
	}
	
	
	
	public static void main(String[] args) 
	{
		ResponseSpec_Demo obj = new ResponseSpec_Demo();
		//obj.getAllBookingIds();
		obj.getBookingByName();
		
	}

}

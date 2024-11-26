package Session13;

//https://reqres.in/api/users

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification 
{

	
	@Test
	public void createUser() 
	{
		//Create Json data:
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("name", "Prasu");
		jsonData.put("job", "Architect");
		
		//Create Request Specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify url:
		requestSpec.baseUri("https://reqres.in")
		.basePath("/api/users")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString()).header("header1", "header1value");
		
		//query details from request specification:
		
		QueryableRequestSpecification queryReq = SpecificationQuerier.query(requestSpec);
		
		//get base URI:
		String retrievebaseURI = queryReq.getBaseUri();
		System.out.println("Base URI:"+ retrievebaseURI);
		
		//get base Path:
		String retrievebasePath = queryReq.getBasePath();
		System.out.println("Base Path:"+ retrievebasePath);
		
		//get request body:
		String retrieveBody = queryReq.getBody();
		System.out.println("Body:"+ retrieveBody);
		
		//get Request Headers:
		Headers allHeaders = queryReq.getHeaders();
		
		
		System.out.println("\n----------------REQUEST HEADERS--------------------\n");
		
		
		for(Header h:allHeaders) 
		{
			System.out.println("Header name:"+ h.getName()+ "\tHeader value:"+ h.getValue());
		}
		
		
		
		
		
		
		
		
	
	
	}

}

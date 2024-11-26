package Session03;

//Create -> POST
//Retrieve -> GET
//Update -> PUT
//Delete -> DELETE
//Partial Updation -> PATCH

//Post Request -> https://reqres.in/api/users
//Below is Resource Information(Request Body):
/*

{
	"name": "prachi",
	"job": "QA"
}

*/

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test_PostMethod 
{
	
	@Test
	public void test03()	//BDD style
	{
		//Creating JSON Data on the server:
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "prachi");
		jsonData.put("job", "QA");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured
		.given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON) //content type & body comes under 'header' which comes under 'given'
			.body(jsonData.toJSONString())
		.when()
			.post()		//post comes under 'when'
		.then()							
			.statusCode(201) //statusCode & log comes under 'then'
			.log().all(); //print all the logs
		
	}
	
	
	void test04() 	//BDD style
	{
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RestAssured
		.given()
			.body("{\r\n"
				+ "	\"name\": \"prachi\",\r\n"
				+ "	\"job\": \"QA\"\r\n"
				+ "}")
			.post()
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(201);
		
	}
	
	public void test05() 
	{
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Prasu");
		jsonData.put("profession", "Backend Developer");
		
		Response response = 
		requestSpec.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.post();
		
		String responseBody = response.getBody().asString();
		
		System.out.println(responseBody);
		
		
	}
	
	public static void main(String[] args) 
	{
		Test_PostMethod obj = new Test_PostMethod();
		obj.test03();
		//obj.test04();
		//obj.test05();
		
	}
}










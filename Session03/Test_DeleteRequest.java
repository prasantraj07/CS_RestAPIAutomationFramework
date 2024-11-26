package Session03;

//Delete Request -> https://reqres.in/api/users/52

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Test_DeleteRequest 
{
	
	@Test
	public void test06() 
	{
		RestAssured.baseURI = "https://reqres.in/api/users/52";
		RestAssured.given()
		.when()
		.delete()
		.then()
		.log().all()
		.statusCode(204);
	}
	
}

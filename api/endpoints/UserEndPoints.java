package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints 
{
	
	public static Response CreateUser(Users payload) 
	{
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		
		return response;
		
		
	}
	
	//Update User:
	public static Response GetUser(String userName) 
	{
		
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
		return response;
		
		
	}
	
	
	public static Response UpdateUser(String userName, Users payload) 
	{
		
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)	
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
		.put(Routes.put_url);
		
		return response;
			
	}
	
	public static Response DeleteUser(String userName) 
	{
		
		Response response = given()
		.accept(ContentType.JSON)	
		.pathParam("username", userName)
		
		.when()
		.delete(Routes.del_url);
		
		return response;
			
	}
	
	
}
















package Session15;

//Creating JSON Object using Java Map:

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class JsonUsingJavaMap 
{
	
	//Test 1:
	
	/*
  	{
    "username" : "admin",
    "password" : "password123"
	}

 */
	void createAuthToken() 
	{
		
		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		Response response = RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.contentType(ContentType.JSON)
		.body(authToken)
		.post();
		
		response.prettyPrint();
		
		if(response.statusCode() == 200) 
		{
			System.out.println("Correct status code");
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		
		//TestNG Test:
		//Assert.assertEquals(response.statusCode(), 200, "check for status code");
		
	}
	
	//Test 2:
	
	/*
	 * 
		{
	
		"firstName":"Mohan",
		"lastName":"Ambedkar",
		"age": 28,
		"salary": 100000.56,
		"IsMarried": true,
		"Hobbies":["Music", "Computer", "Games"],
		"TechSkill":
				{
					"Programming Language":"Java",
					"WebAutomation": "Selenium",
					"API Testing": "Rest Assured"
				}	
		}

	 */
	
	void createUser() 
	{
		HashMap<String, Object> userData = new HashMap<String, Object>();
		
		userData.put("firstName", "Mohan");
		userData.put("lastName", "Ambedkar");
		userData.put("age", 28);
		userData.put("salary", 100000.56);
		userData.put("IsMarried", true);
		
		ArrayList<String> hobbies = new ArrayList<String>(); //Hobbies has Array list
		hobbies.add("Music");
		hobbies.add("Computer");
		hobbies.add("Games");
		
		userData.put("Hobbies", hobbies);
		
		HashMap<String, String> techSkill = new HashMap<String, String>();
		techSkill.put("Programming Language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API Testing", "Rest Assured");
		
		userData.put("TechSkill", techSkill);
		
		Response response = RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(userData)
		.post();
		
		response.prettyPrint();
		
		if(response.statusCode() == 201) 
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
		JsonUsingJavaMap obj = new JsonUsingJavaMap();
		//obj.createAuthToken();
		obj.createUser();
		
	}

}















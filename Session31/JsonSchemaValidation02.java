package Session31;

//Json Schema Validation without Rest Assured:

import org.hamcrest.MatcherAssert;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;


public class JsonSchemaValidation02 
{
	
	
	void testMethod() 
	{
		
		String json = "\r\n"
				+ "{\r\n"
				+ "	\"id\": \"07\",\r\n"
				+ "	\"email\": \"randhawa@hotmail.com\"\r\n"
				+ "	\"first_Name\": \"Priya\",\r\n"
				+ "	\"last_Name\": \"Randhawa\"\r\n"
				+ "}\r\n"
				+ "";
		
		//Method 1:
		/*
		MatcherAssert.assertThat(json, 
		JsonSchemaValidator.matchesJsonSchema(new File
		("C:\\Users\\Asus\\Downloads\\EmployeeSchema.json")));	
		*/
		
		//Method 2:
		MatcherAssert.assertThat
		(json, JsonSchemaValidator.matchesJsonSchemaInClasspath("EmployeeSchema.json"));
		
	
	}
	
	public static void main(String[] args) 
	{
		JsonSchemaValidation02 obj = new JsonSchemaValidation02();
		obj.testMethod();
		
	}
	

}














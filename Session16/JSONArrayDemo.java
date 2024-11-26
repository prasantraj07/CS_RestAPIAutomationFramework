package Session16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayDemo 
{
	
// 1.Creating JSON Array Request Body using JSON Object:	
	void createuserUsingJSONArray() 
	{
		
		//Create JsonObjects for users:
		
		JSONObject user1 = new JSONObject();
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		JSONObject user2 = new JSONObject();
		user1.put("firstName", "Prerna");
		user1.put("lastName", "Gupta");
		user1.put("age", 27);
		user1.put("salary", 13000.50);
		
		JSONObject user3 = new JSONObject();
		user1.put("firstName", "Jatin");
		user1.put("lastName", "Gupta");
		user1.put("age", 26);
		user1.put("salary", 16000.50);
		
		
		//add JSON Objects to JSON Array:
		JSONArray usersPayload = new JSONArray();
		
		usersPayload.add(user1);
		usersPayload.add(user2);
		usersPayload.add(user3);
		
		//Create Request Specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in/api/users");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(usersPayload);
		
		
		Response response = requestSpec.post();
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

// 2.Create JSON Array using List:
	
	void createJsonArrayUsingList() 
	{
		
		Map<String, Object> user1 = new HashMap<String, Object>();
		//'Object' type can accept both String & Integer values.
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		Map<String, Object> user2 = new HashMap<String, Object>();
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		Map<String, Object> user3 = new HashMap<String, Object>();
		user1.put("firstName", "Prachi");
		user1.put("lastName", "Gupta");
		user1.put("age", 28);
		user1.put("salary", 10000.56);
		
		
		
		List<Map<String, Object>> jsonArrayListPayload = new ArrayList<>();
		
		jsonArrayListPayload.add(user1);
		jsonArrayListPayload.add(user2);
		jsonArrayListPayload.add(user3);
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in/api/users");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonArrayListPayload);
		
		Response response = requestSpec.post();
		
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
		JSONArrayDemo obj = new JSONArrayDemo();
		obj.createJsonArrayUsingList();
		
	}
		
		
		

}

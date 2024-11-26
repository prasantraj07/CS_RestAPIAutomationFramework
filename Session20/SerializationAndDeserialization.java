package Session20;

// ObjectMapper provides functionality for reading and writing JSON.

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization 
{
	
	void createJsonObjectFromEmployeeClassObject() throws JsonProcessingException 
	{
		
		EmployeeClass emp1 = new EmployeeClass();
		emp1.setFirstName("Madhav");
		emp1.setLastName("Mehta");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.50);
		
		// Serialization:
		//1. convert employee class object to JSON payload as String:
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String employeeJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(employeeJson);
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://httpbin.org/post");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(employeeJson);
		Response response = requestSpec.post();
		
		response.prettyPrint();
		
		if(response.statusCode() == 200) 
		{
			System.out.println("Correct status code");
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		
		// Deserialization:
		//2. convert JSON String(employee JSON) to Class Object(EmployeeClass):
		
		EmployeeClass emp2 = objMapper.readValue(employeeJson, EmployeeClass.class);
		
		System.out.println("/n----------Print after JSONObject to Class Object-------/n");
		System.out.println("firstName: " + emp2.getFirstName());
		System.out.println("lastName: " + emp2.getLastName());
		System.out.println("gender: " + emp2.getGender());
		System.out.println("age: " + emp2.getAge());
		System.out.println("salary: " + emp2.getSalary());
		
		
		
	}
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		SerializationAndDeserialization obj = new SerializationAndDeserialization();
		obj.createJsonObjectFromEmployeeClassObject();
		
	}

}









package Session21;

//Creating a POJO class of JSON Array:
//JSON Array is collection of JSON objects or List of Objects.
//ObjectMapper is a class which converts Java objects to JSON and vice versa.


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session20.EmployeeClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


/*
 	{
  	“firstName”: “Madhav”,
	“lastName”: “Mehta”,
	“gender”: “Male”,
	“age”: 35,
	“salary”: 10000.50
	}
	
	{
  	“firstName”: “Rita”,
	“lastName”: “Dobriyal”,
	“gender”: “Female”,
	“age”: 38,
	“salary”: 20000.50
	}
	
	{
  	“firstName”: “Roja”,
	“lastName”: “Reddy”,
	“gender”: “Female”,
	“age”: 33,
	“salary”: 25000.50
	}
 * 
 * 
 */

public class JsonArrayPojoClassDemo 
{
	
	void createEmployeesJsonArray() throws JsonProcessingException 
	{
		//create first employee Object:
		EmployeeClass emp1 = new EmployeeClass();
		
		emp1.setFirstName("Madhav");
		emp1.setLastName("Mehta");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.50);
		
		//create second employee Object:
		EmployeeClass emp2 = new EmployeeClass();
		
		emp2.setFirstName("Rita");
		emp2.setLastName("Dobriyal");
		emp2.setGender("Female");
		emp2.setAge(38);
		emp2.setSalary(20000.50);
		
		//create third employee Object:
		EmployeeClass emp3 = new EmployeeClass();
		
		emp3.setFirstName("Roja");
		emp3.setLastName("Reddy");
		emp3.setGender("Female");
		emp3.setAge(33);
		emp3.setSalary(25000.50);
		
		//create List of employees:
		
		List<EmployeeClass> listOfEmp = new ArrayList<EmployeeClass>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		
		//1. Serialization:
		//Convert employee class object to json array payload as a String:
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String jsonArrayPayload = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);
		
		System.out.println("employee class objects to json array payload");
		System.out.println(jsonArrayPayload);
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://httpbin.org/post");
		
		
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonArrayPayload);
		
		Response response = requestSpec.post();	
		
		System.out.println("---------------Response Body--------------");
		
		response.prettyPrint();
		System.out.println("Response status code: "+ response.statusCode());
		
		
		//2. Deserialization:
		//Converting json array to EmployeeClass objects:
		
		ResponseBody responseBody = response.getBody();
		
		JsonPath jsonPathView = responseBody.jsonPath();
		
		List<EmployeeClass> allEmployees = jsonPathView.getList("json", EmployeeClass.class);
		
		System.out.println("---------------Employee Objects in Response Body--------------");
		
		for(EmployeeClass emp: allEmployees) 
		{
			System.out.println(emp.getFirstName()+" "+ emp.getLastName());
			
		}
		
		
	}
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		JsonArrayPojoClassDemo obj = new JsonArrayPojoClassDemo();
		obj.createEmployeesJsonArray();
		
	}

}













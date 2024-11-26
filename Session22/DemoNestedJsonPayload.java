package Session22;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
{
  	“firstName”: “Madhav”,
	“lastName”: “Mehta”,
	“gender”: “Male”,
	“age”: 35,
	“salary”: 10000.50,
	"address":
	{
  		"street":"Park Avenue",
  		"city": "Vijaywada",
  		"state": "Andhra Pradesh",
  		"pin code": 530012
	}
}
*/

public class DemoNestedJsonPayload 
{
	
	void createUser() throws JsonProcessingException 
	{
		
		EmployeePojoClass emp1 = new EmployeePojoClass();
		emp1.setFirstName("Madhav");
		emp1.setLastName("Mehta");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.56);
		
		
		EmployeeAddress emp1Address = new EmployeeAddress();
		emp1Address.setStreet("Park Avenue");
		emp1Address.setCity("Vijaywada");
		emp1Address.setState("Andhra Pradesh");
		emp1Address.setPinCode(530012);
		
		emp1.setAddress(emp1Address);
		
		//convert class object to Json object as String:
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		System.out.println("json Payload : "+jsonPayload);
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://httpbin.org/post");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(jsonPayload);
		
		//perform Post request:
		Response response = requestSpec.post();
		
		response.prettyPrint();
		
	}
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		DemoNestedJsonPayload obj = new DemoNestedJsonPayload();
		obj.createUser();
		
	}
	
}















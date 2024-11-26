package Session23;

// Creating POJO class of Complex Nested JSON Object:

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Session22.EmployeeAddress;
import Session22.EmployeePojoClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 
"companyName": "XYZ Ltd",
"Street": "Dalal Street"
		  "City": "Mumbai",
		  "State": "Maharashtra",
		  "pin code": "220013"
"BankAccounts":["HDFC", "SBI", "AXIS"]
 
 */

public class ComplexNestedJsonObject 
{
	
	void createUser() throws JsonProcessingException 
	{
		//create Request payload:
		NestedJsonPOJO requestPayload = new NestedJsonPOJO();
		
		requestPayload.setCompanyName("XYZ Ltd");
		requestPayload.setStreet("Dalal Street");
		requestPayload.setCity("Mumbai");
		requestPayload.setState("Maharashtra");
		requestPayload.setPinCode("220013");
		
		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("SBI");
		banks.add("AXIS");
		
		requestPayload.setBankAccount(banks);
		
		EmployeePojoClass emp1 = new EmployeePojoClass();
		EmployeePojoClass emp2 = new EmployeePojoClass();
		EmployeePojoClass emp3 = new EmployeePojoClass();
		
		//1st Employee:
		
		emp1.setFirstName("Madhav");
		emp1.setLastName("Ambedkar");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.50);
		
		EmployeeAddress empAddress = new EmployeeAddress();
		empAddress.setStreet("Park Avenue");
		empAddress.setCity("Vijaywada");
		empAddress.setState("Andhra Pradesh");
		empAddress.setPinCode(530012);
		
		
		emp1.setAddress(empAddress);
		
		//2nd Employee:
		
		emp2.setFirstName("Radhika");
		emp2.setLastName("Dubey");
		emp2.setGender("Female");
		emp2.setAge(34);
		emp2.setSalary(25000.50);
		
		empAddress.setStreet("Park Street");
		empAddress.setCity("Kolkata");
		empAddress.setState("West Bengal");
		empAddress.setPinCode(711109);
		
		emp2.setAddress(empAddress);
		
		//3rd Employee:
		
		emp3.setFirstName("Sitara");
		emp3.setLastName("Singh");
		emp3.setGender("Male");
		emp3.setAge(33);
		emp3.setSalary(21000.50);
				
		
		empAddress.setStreet("Richmond Road");
		empAddress.setCity("Bengaluru");
		empAddress.setState("Karnataka");
		empAddress.setPinCode(560069);
				
		emp3.setAddress(empAddress);
		
		
		List<EmployeePojoClass> employees = new ArrayList<EmployeePojoClass>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		requestPayload.setEmployeelist(employees);
		
		//Convert Class object to JSON Object as String(Serialization):
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String payLoad = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		
		System.out.println(payLoad);
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://httpbin.org/post");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(payLoad);
		
		Response response = requestSpec.post();
		
		System.out.println("-------------------Response Body-------------------");
		response.prettyPrint();
		
		if(response.statusCode() == 200) 
		{
			System.out.println("Correct status code");
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		
	}
		
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		ComplexNestedJsonObject obj = new ComplexNestedJsonObject();
		obj.createUser();
		
	}

}



















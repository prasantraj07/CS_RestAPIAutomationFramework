package Session27;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonResponse 
{
	
	void test() 
	{
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://run.mocky.io/v3/4f5d3c94-8a9e-412e-bd62-10b25ece5a9a");
		
		
		//perform get Request:
		EmpPOJOClass emp = requestSpec.get().as(EmpPOJOClass.class);
		
		System.out.println("/n----------Print Class Objects(Deserialization)-------/n");
		
		
		System.out.println("firstName: " + emp.getFirstName());
		System.out.println("lastName: " + emp.getLastName());
		System.out.println("gender: " + emp.getGender());
		System.out.println("age: " + emp.getAge());
		System.out.println("salary: " + emp.getSalary());
		System.out.println("IsMarried: " + emp.isMarried());
		
		System.out.println("Hobbies:");
		String [] hobbiesStr = emp.getHobbies();
		
		for(int i=0;i<hobbiesStr.length; i++) 
		{
			System.out.println(hobbiesStr[i]);
			
		}
		
		//using for-each loop for iteration over Map.entrySet():
		
		for(Map.Entry<String, String> entry: emp.getFamilyMembers().entrySet())
			System.out.println("Key = "+ entry.getKey()+ ", Value = "+ entry.getValue());
		
		
	}
	
	public static void main(String[] args) 
	{
		JsonResponse obj = new JsonResponse();
		obj.test();
		
	}
	

}

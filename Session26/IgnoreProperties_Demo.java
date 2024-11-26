package Session26;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IgnoreProperties_Demo 
{
	
	void test1() throws JsonMappingException, JsonProcessingException 
	{
		
		//Json String (Directly copied from Employee class):
		
		String payLoad = "{\r\n"
				+ " \"firstName\": \"Dasrath\",\r\n"
				+ " \"lastName\": \"Singh\",\r\n"
				+ " \"gender\": \"Male\",\r\n"
				+ " \"age\": 33,\r\n"
				+ " \"salary\": 21000.50,\r\n"
				+ " \"IsMarried\": true,\r\n"
				+ " \"fullName\": \"Dasrath Singh\"\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		
		//Ignoring unknown "fullName" property of POJO class:
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		
		//Convert Json String to Class Object:
		
		Employee emp = objMapper.readValue(payLoad,Employee.class);
		
		System.out.println("-----------------Print Class Objects(Deserialization)-------------");
		
		System.out.println("FirstName: "+ emp.getFirstName());
		System.out.println("LastName: "+ emp.getLastName());
		System.out.println("Gender: "+ emp.getGender());
		System.out.println("Age: "+ emp.getAge());
		System.out.println("Salary: "+ emp.getSalary());
		System.out.println("isMarried: "+ emp.getMarried());
		
		
	}
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException 
	{
		
		IgnoreProperties_Demo obj = new IgnoreProperties_Demo();
		obj.test1();
		
	}
	

}



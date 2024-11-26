package Session25;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnore_Demo 
{
	
	void testMethod1() throws JsonProcessingException 
	{
		//create payload:
		EmployeePOJOClass emp1 = new EmployeePOJOClass();
		
		emp1.setFirstName("Dasrath");
		emp1.setLastName("Singh");
		emp1.setGender("Male");
		emp1.setAge(33);
		emp1.setSalary(21000.50);
		emp1.setMarried(true);
		emp1.setFullName("Dasrath Singh");
		
		
		//convert employee class object to json payload:
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String employeeJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(employeeJson);
		
		//Json Payload String to class Object:
		
		String payLoad = 
				"{\r\n"
				+ "  \"firstName\" : \"Dasrath\",\r\n"
				+ "  \"lastName\" : \"Singh\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"age\" : 33,\r\n"
				+ "  \"salary\" : 21000.5,\r\n"
				+ "  \"fullName\" : \"Dasrath Singh\",\r\n"
				+ "  \"married\" : true\r\n"
				+ "}";
		
		EmployeePOJOClass emp2 = objMapper.readValue(payLoad, EmployeePOJOClass.class);
		
		System.out.println("-------------Print class objects(Deserialize)---------");
		
		System.out.println("FirstName: "+ emp2.getFirstName());
		System.out.println("LastName: "+ emp2.getLastName());
		System.out.println("Gender: "+ emp2.getGender());
		System.out.println("Age: "+ emp2.getAge());
		System.out.println("Salary: "+ emp2.getSalary());
		System.out.println("FullName: "+ emp2.getFullName());
		
		
		
		
	}
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		JsonIgnore_Demo obj = new JsonIgnore_Demo();
		obj.testMethod1();
		
	}

}






































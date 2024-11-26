package Session24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Use of @JsonInclude annotation to ignore default values in Payload:

/*
 
{
“firstName”: “Sitara”,
“lastName”: “Singh”,
“gender”: “Male”,
“age”: 33,
“salary”: 21000.50,
"IsMarried": true
}
 
 */


public class JsonInclude_Demo 
{
	
	void testMethod1() throws JsonProcessingException 
	{
		//create Payload:
		
		EmployeePOJOClass emp = new EmployeePOJOClass();
		emp.setFirstName("Sitara");
		//emp.setLastName("Singh");
		emp.setGender("Male");
		//emp.setAge(33);
		emp.setSalary(21000.50);
		//emp.setisMarried(true);
		
		//Empty array:
		String[] hobbies = new String[2];
		hobbies[0] = "Reading";
		hobbies[1] = "Music";
		
		emp.setHobbies(hobbies);
		
		//Empty List:
		List<String> degrees = new ArrayList<String>();
		degrees.add("MBA");
		degrees.add("BCA");
		
		emp.setDegrees(degrees);
		
		//Empty Map:
		Map<String, String> familyMembers = new HashMap<>();
		familyMembers.put("1", "Friend");
		familyMembers.put("2", "Wife");
		
		emp.setFamilyMembers(familyMembers);
		
		
		//convert employee class object to Json payload as String:
		ObjectMapper objMapper = new ObjectMapper();
		String employeeJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println(employeeJson);
		
	}
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		JsonInclude_Demo obj = new JsonInclude_Demo();
		obj.testMethod1();
		
	}

}



















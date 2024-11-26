package Session17;

//A JSON object is a data type which is made up of unordered sets of key, value pairs.
//Jackson API -> It is used to serialize Java Objects or Map to JSON and vice versa.


//Creating JSON Object using Jackson API:

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Iterator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
// https://reqres.in/api/users

//	{
//		"firstName":"Mohan"
//		"lastName":"Ambedkar"
//		"age": 28,
//		"salary": 100000.56
//		"IsMarried": false,
		"Hobbies":["Cooking", "Music"],
//		"TechSkill":
//		{
//			"Programming Language":"Java",
//			"WebAutomation": "Selenium",
//			"API Testing": "Rest Assured"
//		}
//
//	}
*/

public class JsonUsingJacksonAPI 
{
	void createUser() throws JsonProcessingException 
	{
		//1.Create ObjectMapper class instance:
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Create ObjectNode i.e. Json node:
		
		ObjectNode userDetails = objectMapper.createObjectNode();
		
		userDetails.put("firstName", "Mohan");
		userDetails.put("lastName", "Ambedkar");
		userDetails.put("age", 28);
		userDetails.put("salary", 10000.56);
		userDetails.put("IsMarried", false);
		userDetails.set("Hobbies", objectMapper
		.convertValue(Arrays.asList("Cooking", "Music"), JsonNode.class));
		
		ObjectNode techSkill = objectMapper.createObjectNode();
		techSkill.put("Programming Language", "Java");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API Testing", "Rest Assured");
		
		userDetails.set("TechSkill", techSkill);
		
		
		//print userDetails JSON Object:
		
		String userDetailsAsString = objectMapper
		.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
		System.out.println("Created JSON Node is -> "+userDetailsAsString);
		
		//2.Retrieve field values:
		String firstName = userDetails.get("firstName").asText();
		System.out.println("Value of firstName field is "+ firstName);
		
		boolean isMarried = userDetails.get("IsMarried").asBoolean();
		System.out.println("Value of IsMarried field is "+ isMarried);
		
		//retrieve field value of WebAutomation:
		String webAutomationValue = userDetails.get("TechSkill").get("WebAutomation").asText();
		System.out.println("Value of WebAutomation field is "+ webAutomationValue);
		
		
		//retrieving all field names:
		System.out.println("\n------------Print all field names----------\n");
		
		Iterator<String> fieldNameIterator = userDetails.fieldNames();
		
		while(fieldNameIterator.hasNext()) 
		{
			System.out.println(fieldNameIterator.next());
			
		}
		
		//retrieving all field values:
		System.out.println("\n------------Print all field values----------\n");
		
		Iterator<JsonNode> fieldValueIterator = userDetails.elements();
		
		while(fieldValueIterator.hasNext()) 
		{
			System.out.println(fieldValueIterator.next());
			
		}
		
		//3. Retrieving all key-value pair (field names & values both):
		System.out.println("\n------------Print all field names & values both----------\n");
		
		Iterator<java.util.Map.Entry<String, JsonNode>> keyValueEntries = userDetails.fields();
		
		while(keyValueEntries.hasNext()) 
		{
			java.util.Map.Entry<String, JsonNode> node = keyValueEntries.next();
			node.getKey();
			
			System.out.println("Key -> "+ node.getKey() + ", "+ "Value -> "+ node.getValue());
			
		}
		
		//4. Remove field "firstName" from json object or ObjectNode:
		
		String removedValue = userDetails.remove("firstName").asText();
		System.out.println("Removed first name value is -> " + removedValue);
		
		//print userDetails JSON Object:
		
		String userDetailsAsString01 = objectMapper
		.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
		System.out.println("JSON Node after Remove method -> "+userDetailsAsString01);
		
		//5. Update Json object or object node:
		
		userDetails.put("lastName", "Valmiki");
		
		techSkill.put("Programming Language", "Python");
		userDetails.set("TechSkill", techSkill);
		
		//print userDetails JSON Object:
		String userDetailsAsString02 = objectMapper
		.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
		System.out.println("JSON Node after Update method -> "+userDetailsAsString02);
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in/api/users");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(userDetails);
		
		Response response = requestSpec.post();
		
		System.out.println("\n------------Print Http Response Body----------\n");
		
		response.prettyPrint();
				
	
	}
	
	public static void main(String[] args) throws JsonProcessingException 
	{
		JsonUsingJacksonAPI obj = new JsonUsingJacksonAPI();
		obj.createUser();

	}

}





















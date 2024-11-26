package Session14;

// https://petstore.swagger.io/v2/pet

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class ValidateXMLResponse 
{
	
	void addPet() 
	{
		
		String xmlRequestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		RequestSpecification requestSpec = RestAssured.given();
		
		
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
		
		requestSpec.header("accept", "application/xml");
		requestSpec.header("Content-Type", "application/xml");
		requestSpec.body(xmlRequestBody);
		
		Response response = requestSpec.post();
		
		response.prettyPrint();
		
		System.out.println("\n----------------------------\n");
		
		if(response.statusCode() == 200) 
		{
			System.out.println("Correct status code");
		}
		else 
		{
			System.out.println("Incorrect status code");
		}
		
		//Response XML Validation of 'Pet.name' element value using Matchers dependency:
		//Test01:
		
		//Approach 1:
		response.then().body("Pet.name", Matchers.equalTo("doggie"));
		
		//Approach 2:
		XmlPath objXmlPath = new XmlPath(response.asString());
		String petName = objXmlPath.get("Pet.name").toString();
		
		//Assert.assertEquals(petName, "doggie", "Check for Pet name");
		
		//Test02:
		List<String> travellersList = objXmlPath
		.getList("TravelerInformationResponse.Travelers.TravelerInformation");
		
		int totalTravelerCount = travellersList.size();
		
		Assert.assertEquals(totalTravelerCount, 10, "Check for total no. of Travellers");
		
		//Test03: Verify name 'Vano' in travellers list:
		
		List<String> listofTravellersName = objXmlPath
				.getList("TravelerInformationResponse.Travelers.TravelerInformation.name");
		
		//print all the names in the Travellers list:
		
		boolean found = false;
		for(String traveller: listofTravellersName)
		{
			System.out.println(traveller);
			
			if(traveller.equals("Vano")) 
			{
				found = true;
				break;
			}
			
		}
		
		Assert.assertEquals(found, true);
		
	}
	
	public static void main(String[] args) 
	{
		ValidateXMLResponse obj = new ValidateXMLResponse();
		obj.addPet();
		
		
	}

}







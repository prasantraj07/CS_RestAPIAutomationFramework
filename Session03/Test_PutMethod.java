package Session03;

//Put Request -> https://reqres.in/api/users/52
//Resource Information:
//{
//	"name":"Sheetal"
//	"job":"Teacher"
//}

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Test_PutMethod 
{
	@Test
	public void test04() 
	{
		//Creating JSON data on the server:
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Sheetal");
		jsonData.put("job", "Teacher");
				
		RestAssured.baseURI = "https://reqres.in/api/users/52";
		
		RestAssured
		.given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(jsonData.toJSONString())
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all(); //print all the logs
	}

}

package Session03;

//Patch Request -> https://reqres.in/api/users/52
//Resource Information:
//{
//	"name":"Radha"
//	"job":"Writer"
//}

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Test_PatchMethod 
{
	
	public void test05() 
	{
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Radha");
		jsonData.put("job", "Writer");
				
		RestAssured.baseURI = "https://reqres.in/api/users/52";
		RestAssured
		.given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.body(jsonData.toJSONString())
		.when()
			.patch()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	public static void main(String[] args) 
	{
		Test_PatchMethod obj = new Test_PatchMethod();
		obj.test05();
		
	}

}

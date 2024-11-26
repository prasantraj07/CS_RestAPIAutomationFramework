 package Session11;

//https://api-m.sandbox.paypal.com/v1/oauth2/token
//U/N & P/W are Client Id & client secret respectively provided by Client.
 
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

 
public class AuthorizationDemoOauth
{
	
	static String accessToken;
	@Test
	public void GetAccessToken() 
	{
		//random values:
		String clientId = "45878fhbn3";
		String clientSecret = "25874kgetgfv45214";
		
		//Create request Specification:
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL:
		requestSpec.baseUri("https://api-m.sandbox.paypal.com");
		requestSpec.basePath("/v1/oauth2/token");
		
		//Basic Authorization:
		Response response = requestSpec.auth().preemptive()
		.basic(clientId, clientSecret).param("grant_type", "client_credentials").post();
		
		
		response.prettyPrint();
		
		//print status code and status line:
		System.out.println("Response Code:" + response.statusCode());
		System.out.println("Status line:" + response.statusLine());
		
		//Validate response code:
		Assert.assertEquals(response.statusCode(), 200, "check for response code");
		
		//get access token from response body:
		
		String accessToken = response.getBody().path("access_token");
		System.out.println("access token:" + accessToken);
	
		
	}
	
	@Test(dependsOnMethods = "GetAccessToken")
	public void ListInvoice() 
	{
		Response res = RestAssured.given().auth().oauth2(accessToken)
		.queryParam("page","3")
		.queryParam("page_size", "4")
		.queryParam("total_count_required", "true")
		.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		
		System.out.println("\n--------------LIST INVOICE-------------");
		
		res.prettyPrint();
		
		//print status code and status line:
		System.out.println("Response Code:" + res.statusCode());
		System.out.println("Status line:" + res.statusLine());
		
		//Validate response code:
		Assert.assertEquals(res.statusCode(), 200, "check for response code");
		
	}
	
	
}

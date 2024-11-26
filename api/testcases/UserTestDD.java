package api.testcases;

//Data Driven Testing in API Automation:

import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.UserEndPoints;
import api.payload.Users;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD 
{
	
	@Test(priority=1, dataProvider="AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String userName, String fname, 
	String lname, String email, String pwd, String phone) 
	{
		
		Users userPayload = new Users();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		
		Response response = UserEndPoints.CreateUser(userPayload);
		
		System.out.println("------------Create User Data------------");
		
		//log response:
		response.then().log().all();
		
		//Validation:
		Assert.assertEquals(response.getStatusCode(), 200);
			
	}
	
	@Test(priority=2, dataProvider="UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) 
	{
		
		Response response = UserEndPoints.DeleteUser(username);
		
		
		System.out.println("------------Delete User Data------------");
		//log response:
		response.then().log().all();
		
		
		//Validation:
		Assert.assertEquals(response.getStatusCode(), 200);
			
	}
	

}














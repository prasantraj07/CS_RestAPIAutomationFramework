package api.testcases;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import io.restassured.response.Response;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.Users;


public class UserTest2 
{
	
	Faker faker;
	Users userPayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() 
	{
		
		faker = new Faker();
		userPayload = new Users();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//obtain logger:
		logger = LogManager.getLogger("RestAssuredAutomationFramework");
		
			
	}
	
	@Test(priority=1)
	public void testCreateUser() 
	{
		Response response = UserEndPoints2.CreateUser(userPayload);
		
		System.out.println("------------Create User Data------------");
		//log response:
		response.then().log().all();
		
		
		//Validation:
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//log:
		logger.info("Create User executed");
			
	}
	
	@Test(priority=2)
	public void testGetUser() //Read data
	{
		Response response = UserEndPoints2.GetUser(this.userPayload.getUsername());
		
		System.out.println("------------Get User Data------------");
		//log response:
		response.then().log().all();
		
		
		//Validation:
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//log:
		logger.info("Get User executed");
			
	}
	
	@Test(priority=3)
	public void testUpdateUser() 
	{
		userPayload.setFirstName(faker.name().firstName()); //updating firstName
		Response response = UserEndPoints2.UpdateUser(this.userPayload.getUsername(), userPayload);
		
		//log response:
		response.then().log().all();
		
		//Validation:
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Read UserData if firstName is updated or not:
		Response responsePostUpdate = UserEndPoints2.GetUser(this.userPayload.getUsername());
		
		System.out.println("------------Update User Data------------");
		
		responsePostUpdate.then().log().all();
		
		//log:
		logger.info("Update User executed");
	}
	
	@Test(priority=4)
	public void testDeleteUser() 
	{
		
		Response response = UserEndPoints2.DeleteUser(this.userPayload.getUsername());
		
		
		System.out.println("------------Delete User Data------------");
		//log response:
		response.then().log().all();
		
		//Validation:
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//log:
		logger.info("Delete User executed");
			
	}
	
	
}












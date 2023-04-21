package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	
	public Logger log;
	
	@BeforeClass
	public void setup()
	{
		
		log=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1,dataProvider ="Data",dataProviderClass = DataProviders.class)
	public void testPOSTUser(String userId,String userName,String fname,String lname,String usermail,String pwd,String ph)
	{
		User userPayload =new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(usermail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);		
		
		
		log.info("..........user creation Started............");
		Response response=UserEndpoints2.creatUser(userPayload);
		response.then().log().all();
		int stcode=response.getStatusCode();
		System.out.println("Status code for POST:"+stcode);
		Assert.assertEquals(response.getStatusCode(), 200);		
		log.info("................user created Sucessfully...............");
	}
	
	
	
	
	@Test(priority = 2,dataProvider ="UserNames",dataProviderClass = DataProviders.class)
	public void GETUserbyName(String userName)
	{
		log.info("..........Reading user info............");
		
		Response response=UserEndpoints2.readUser(userName);		
		int stcode=response.getStatusCode();
		System.out.println("Status code fo GET:"+stcode);
		Assert.assertEquals(response.getStatusCode(), 200);//in testNG
		
		log.info("................User Info Displayed...............");
	}
	
	@Test(priority = 3,dataProvider ="UserNames",dataProviderClass = DataProviders.class)
	public void DELETEUserbyName(String userName)
	{
		log.info("..........user Deletion Started............");
		
		Response response=UserEndpoints2.deleteUser(userName);	
		int stcode=response.getStatusCode();
		System.out.println("Status code for DELETE:"+stcode);
		Assert.assertEquals(response.getStatusCode(), 200);//in testNG
		
		log.info("................user Deleted Sucessfully...............");
	}
	
	
}

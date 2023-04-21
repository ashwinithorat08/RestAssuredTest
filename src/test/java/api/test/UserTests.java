package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;



public class UserTests {
	Faker faker;//to generate data and that data pass to the pojo class in post method
	User userPayload;//and to  pass data into payload
	
	public Logger log;
	
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userPayload=new User();
		
		
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(6, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());	
		
		
		log=LogManager.getLogger(this.getClass());
		//log.debug("...................Debugging...................");
	}
	
	
	//POST request test cases
	
	@Test(priority =1)
	public  void testPOSTUser() 
	{
		log.info("********Creating User*******");
		
		Response response=UserEndpoints.creatUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		log.info("********Created Sucessfully*******");
	}
	
	@Test(priority =2)
	public  void testGETUserbyName() 
	{
		log.info("********Reading User Info*******");
		Response response=UserEndpoints.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		log.info("********User Info is Displyed*******");
	}
	
	@Test(priority =3)
	public  void testUPDATEUserbyName() 
	{
		//update data using payload
		
		log.info("********Updating Info Started*******");
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
		
		response.then().log().body();
		// OR response.then().log().all().statusCode(200);//in restassured
		Assert.assertEquals(response.getStatusCode(), 200);//in testng
		
		Response responseafterupdate=UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
		
		log.info("********User Updated Sucessfully*******");
	}
	
	@Test(priority =4)
	public  void testDELETEUserbyName() 
	{
		
		log.info("********User deletion Started*******");
		Response response=UserEndpoints.deleteUser(this.userPayload.getUsername());		
		Assert.assertEquals(response.getStatusCode(), 200);//in testNG
		
		log.info("********User Deleted Sucessfully*******");
	}
	
}

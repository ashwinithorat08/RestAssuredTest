package testDemo;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class myFirstRestAssuredClass {
	@Test
	public static void getResponseBody()
	{			 
		 RestAssured
		 	   .given()			 
			   .queryParam("CUSTOMER_ID","68195")
			   .queryParam("PASSWORD","1234!")
			   .queryParam("Account_No","1")
			   .when().get("http://demo.guru99.com/V4/sinkministatement.php")
			   .then().log()
			   .body();
		 Reporter.log("Result",true);
		 
	}

}

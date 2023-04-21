package testDemo;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import javax.xml.crypto.Data;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import api.payload.User;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Demo_methodusing_hashmap {
	/*public void test1()
	{
		
		Response response=get("https://reqres.in/api/users?page=2");
		System.out.println("Status code:"+response.getStatusCode());
		System.out.println("Get Time:"+response.getTime());
		System.out.println("Get Status Line:"+response.getStatusLine());
		System.out.println("Header:"+response.getHeader("content-Type"));
		System.out.println("Body:"+response.getBody().toString());
		
		int Status_code=response.getStatusCode();
		Assert.assertEquals(Status_code, 200);
		
	}
	*/
	
	
	String baseURI="https://reqres.in/api";
	int id;
	
	
	@Test(priority = 1)
	public void GET_for_listusers() {
		
		

// /api/users?page=2


		given()
		
		.when()
		.get(baseURI+"/users?page=2")
		
		.then()		
		.statusCode(200)	
		.body("page",equalTo(2))	//to validate	
		.log().all();
		

	}

	@Test(priority = 2)
	public void GET_single_user()
	{
		given()
		.when()
		.get(baseURI+"/users/2")//if user is single then no need to pass in body
		.then()
		.statusCode(200)	
		.log().all();
		
	}
	
	@Test(priority = 3)
	public void POST_user()
	{
		
		HashMap<String,String> data=new HashMap<String, String>();
		data.put("name", "AshwiniThorat");
		data.put("job", "QA");
		
		id=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post(baseURI+"/users")
			.jsonPath().getInt("id");//capture id from response
		System.out.println("created User id:"+id);
			
		/*
		.then()		
			.statusCode(201)
			.log().all();//to print entire response on console
		*/   //commenting to get id of user to update or delete
	}
	
	
	
	
	@Test(priority = 4)
	public void PUT_user()
	{
		HashMap<String,String> data=new HashMap<String, String>();
		data.put("name", "Virendra");
		data.put("job", "Engineer");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
			.put(baseURI+"/users/"+id)
		.then()
		.statusCode(200)
		.body("name", equalTo("Virendra"))//to validate put user
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		//System.out.println("updated user  id:"+id);
		
	}

	
	
	@Test(priority = 5)
	public void DELETE()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
		//System.out.println("deleted User id:"+id);
	}
	
}

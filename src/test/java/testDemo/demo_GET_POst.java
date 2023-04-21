package testDemo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import javax.xml.crypto.Data;

import org.testng.*;



public class demo_GET_POst {
	private void test1() {
		// TODO Auto-generated method stub
		baseURI="https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200);
		//.body(data[4].first_name,equalTo("George"));
		//.
		
		
	}

}
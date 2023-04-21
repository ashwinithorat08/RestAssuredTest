//UserEndpoints.java-->created for perform CRUD operation to the user API
package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	
		//method created for getting url from .properties file
		static ResourceBundle getURL() 
		{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file & name of properties file is in "routes"
		return routes;
	}
	
		public static Response creatUser(User payload) 
		{
			
			String post_url=getURL().getString("post_url");
			Response response=
			given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(post_url);
			
			return response;
		}
		
		public static Response readUser(String userName)
		{
			String get_url=getURL().getString("get_url");
			Response response=
			given()
			.pathParam("username", userName)	//path parameter	"username" should same of routes.java class url's path parameter	Get_url=base_url+"/v2/user/{username}";
			
			.when()
			.get(get_url);
			
			return response;
		}
		
		public static Response updateUser(String userName,User payload) 
		{
			
			String update_url=getURL().getString("update_url");
			Response response=
			given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)	
			.body(payload)
			.when()
			.put(update_url);
			//.put(Routes.Update_url);
			
			return response;
		}
		
		public static Response deleteUser(String userName)
		{
			String delete_url=getURL().getString("delete_url");
			Response response=
			given()
			.pathParam("username", userName)			
			
			.when()
			.delete(delete_url);
			
			return response;
		}
}

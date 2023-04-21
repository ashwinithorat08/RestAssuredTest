//UserEndpoints.java-->created for perform CRUD operation to the user API
package api.endpoints;
import static io.restassured.RestAssured.*;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
		public static Response creatUser(User payload) 
		{
			Response response=
			given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(Routes.Post_url);
			
			return response;
		}
		
		public static Response readUser(String userName)
		{
			Response response=
			given()
			.pathParam("username", userName)	//path parameter	"username" should same of routes.java class url's path parameter	Get_url=base_url+"/v2/user/{username}";
			
			.when()
			.get(Routes.Get_url);
			
			return response;
		}
		
		public static Response updateUser(String userName,User payload) 
		{
			Response response=
			given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)	
			.body(payload)
			.when()
			.put(Routes.Update_url);
			//.put(Routes.Update_url);
			
			return response;
		}
		
		public static Response deleteUser(String userName)
		{
			Response response=
			given()
			.pathParam("username", userName)			
			
			.when()
			.delete(Routes.Delete_url);
			
			return response;
		}
}

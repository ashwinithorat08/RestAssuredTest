//............all project code link.......https://github.com/pavanoltraining/PetStoreAutomation





//step1:Routes.java--->class contains all module  URL
//step 2:create userEndPoint.java it--->contains CRUD method implementation(create retrieve update,delete)
//step 3:
/*
 * 
Swagger URI-https://petstore.swagger.io
create user(POST):https://petstore.swagger.io/v2/user
get user(GET):https://petstore.swagger.io/v2/user/{user name}
Update user(PUT):https://petstore.swagger.io/v2/user/{user name}
Delete user(DELETE):https://petstore.swagger.io/v2/user/{user name}
 */


package api.endpoints;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class Routes 
{
public static String base_url="https://petstore.swagger.io";

//working on user module

public static String  Post_url=base_url+"/v2/user";

public static String Get_url=base_url+"/v2/user/{username}";
 
 public static String Update_url=base_url+"/v2/user/{username}";

public static String  Delete_url=base_url+"/v2/user/{username}";
}

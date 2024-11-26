package api.endpoints;

/*
 
Create User		POST	https://petstore.swagger.io/v2/user
Get User		GET		https://petstore.swagger.io/v2/user/user/{username}
Update User		PUT		https://petstore.swagger.io/v2/user/user/{username}
Delete User		DELETE	https://petstore.swagger.io/v2/user/user/{username}

 */

public class Routes 
{
	
	//Common part in all URL's:
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module urls:
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String del_url = base_url + "/user/{username}";
	
	
	
	

}

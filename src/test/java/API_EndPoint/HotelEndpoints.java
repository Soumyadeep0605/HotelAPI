package API_EndPoint;

import API_Payload.HotelPojo;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HotelEndpoints {
	
	
	public static Response CreateUser(HotelPojo hp)
	
	{
		
		
		
		
		
		Response res= 
	    
				given()
				.contentType(ContentType.JSON)
				.body(hp)
				
				.when()
				.post(Route.PostUser);
				
				
				
		
		
		
		
		
		return res;
		
	}
	
	
	
	
public static Response CreateUser(String hp)
	
	{
		
	
		
		Response res= 
	    
				given()
				.header("Content-Type", "text/xml; charset=UTF-8")
				.body(hp)
				.log().all()
				
				.when()
				.post(Route.PostUser);
				
				
				
		
		
		
		
		
		return res;
		
	}

}

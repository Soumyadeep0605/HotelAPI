package API_EndPoint;

import API_Payload.HotelPojo;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HotelEndpointsusingPreperties {
	
	
	public static Response CreateUser(HotelPojo hp)
	
	{
		
		String url= routesAsProperties.postURL().getString("PostUser");
		
		
		
		
		
		Response res= 
	    
				given()
				.contentType(ContentType.JSON)
				.body(hp)
				
				.when()
				.post(url);
				
		
		
		return res;
		
	}
	
	
	public static Response GetUser(int id) 
	{
		String getURL= routesAsProperties.getURL().getString("GetUser");
		Response res= 
				
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(getURL+"/"+id);
		
		return res;
		
	}
	
public static Response CreateUser(String hp)
	
	{
		
	String url= routesAsProperties.getURL().getString("postURL");
		
		Response res= 
	    
				given()
				.header("Content-Type", "text/xml; charset=UTF-8")
				.body(hp)
				.log().all()
				
				.when()
				.post(url);
				
				
				
		
		
		
		
		
		return res;
		
	}

}

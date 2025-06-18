package API_Utilities;

import java.util.HashMap;
import java.util.Map;

import API_Payload.HotelPojo;

public class PojoToMapConverter {
	
	public static Map<String,String> Convert(HotelPojo hp)
	{
		
		
		Map<String,String> map= new HashMap<>();
		
		map.put("firstname", hp.getFirstname());
		map.put("lastname", hp.getLastname());
		map.put("totalprice", String.valueOf(hp.getTotalprice()));
		map.put("depositpaid", String.valueOf(hp.isDepositpaid()));
		map.put("checkin", hp.getBookingdates().getCheckin());
		map.put("checkout", hp.getBookingdates().getCheckout());
		map.put("additionalneeds", hp.getAdditionalneeds());
		
		return map;
		
	}

}

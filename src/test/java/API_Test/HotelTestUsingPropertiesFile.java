package API_Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import API_EndPoint.HotelEndpoints;
import API_Payload.HotelBookingDates;
import API_Payload.HotelPojo;
import API_Utilities.DatapoviderUtility;
import API_Utilities.ExcelToPOJOMapper;
import API_Utilities.PojoToMapConverter;
import API_Utilities.XMLTemplateUpdater;
import io.restassured.response.Response;


@Listeners(API_Utilities.ExcelReportManager.class)
public class HotelTestUsingPropertiesFile {
	
	
	/*@Test
	public void PostTest() throws JsonProcessingException
	{
		Faker fk; 
		HotelPojo hp;
		HotelBookingDates bookingdates=new HotelBookingDates();
		
		fk=new Faker();
		hp=new HotelPojo();
		hp.setFirstname(fk.name().firstName());
		hp.setLastname(fk.name().lastName());
		hp.setDepositpaid(true);
		hp.setTotalprice(fk.number().numberBetween(100, 500));
		hp.setAdditionalneeds(fk.harryPotter().character());
		
		bookingdates.setCheckin("2018-01-01");
		bookingdates.setCheckout("2018-01-03");
		hp.setBookingdates(bookingdates);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(hp);
		System.out.println("Serialized JSON: " + json);
		
		
		
	
		
		Response res= HotelEndpoints.CreateUser(hp);
		System.out.println(res.asPrettyString());
		
		System.out.println(res.statusCode());
	} */
	
	
	
	
	public static final String FilePath= "C:\\\\Users\\\\eesou\\\\OneDrive\\\\Desktop\\\\HotelData.xlsx";
	public static final String XMLFilePath="C:\\\\\\\\Users\\\\\\\\eesou\\\\\\\\OneDrive\\\\\\\\Desktop\\\\\\\\HotelDataTemplate.xml";
	
	
		
	
	
	@Test(dataProvider="BookingDataProvider", dataProviderClass = DatapoviderUtility.class)
	public void createBooking(HotelPojo hp) 
	{
		
		Response res= HotelEndpoints.CreateUser(hp);
		 System.out.println(res.asPrettyString());
		 
		
		Assert.assertEquals(res.jsonPath().get("booking.firstname") , hp.getFirstname()); // booking.firstname is my path 
		
		
        System.out.println(res.asPrettyString());
		System.out.println(res.statusCode());
		System.out.println("CHECK CHECK CHECK");
		
	}
	
	@Test(dataProvider="BookingDataProvider",dataProviderClass = DatapoviderUtility.class, enabled=false)
	public void createBookingXML(HotelPojo hp) throws IOException
	{
		Map<String, String> dataMap= PojoToMapConverter.Convert(hp);
		
		System.out.println("Booking POJO: "+hp);
		System.out.println("Converted Map: "+dataMap);
		String xmlBody= XMLTemplateUpdater.getUpdatedXML(XMLFilePath, dataMap);
		
		System.out.println(xmlBody);
		
		Response res= HotelEndpoints.CreateUser(xmlBody);
		
		boolean b;
		int statuscode= res.statusCode();
		
		if(statuscode==200)
		{
			b=true;
		}
		else
		{
			b=false;
		}
		
		Assert.assertEquals(true, b);
		
		
		
        System.out.println(res.asPrettyString());
		System.out.println(res.statusCode());
		
				
		
	}

}

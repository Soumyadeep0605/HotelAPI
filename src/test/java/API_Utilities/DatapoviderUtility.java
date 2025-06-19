package API_Utilities;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import API_EndPoint.routesAsProperties;
import API_Payload.HotelPojo;
import API_Test.HotelTest;

public class DatapoviderUtility {
	
	@BeforeClass
	@DataProvider(name= "BookingDataProvider")
	public Object[][] getBookingData()throws IOException
	{
		ResourceBundle rb=  ResourceBundle.getBundle("General"); // two ways we can access the elements of a properies file. one by using this ResourceBundle class. 
		
		
		
		
		String fp= rb.getString("FilePath");
		ExcelToPOJOMapper etpm= new ExcelToPOJOMapper(fp, "Data");
		
		List<HotelPojo> dataList= etpm.getBookingdata();
		Object[][] data= new Object[(dataList.size())][1];
		for(int i=0; i<dataList.size();i++)
		{
			data[i][0]=dataList.get(i);
			
		}
				
		return data;
		
	}

}

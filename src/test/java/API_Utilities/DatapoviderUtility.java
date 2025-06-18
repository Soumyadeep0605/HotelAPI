package API_Utilities;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import API_Payload.HotelPojo;
import API_Test.HotelTest;

public class DatapoviderUtility {
	
	@BeforeClass
	@DataProvider(name= "BookingDataProvider")
	public Object[][] getBookingData()throws IOException
	{
		ExcelToPOJOMapper etpm= new ExcelToPOJOMapper(HotelTest.FilePath, "Data");
		
		List<HotelPojo> dataList= etpm.getBookingdata();
		Object[][] data= new Object[(dataList.size())][1];
		for(int i=0; i<dataList.size();i++)
		{
			data[i][0]=dataList.get(i);
			
		}
				
		return data;
		
	}

}

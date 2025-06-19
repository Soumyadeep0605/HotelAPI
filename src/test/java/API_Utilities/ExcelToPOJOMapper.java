package API_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import API_Payload.HotelBookingDates;
import API_Payload.HotelPojo;

public class ExcelToPOJOMapper {
	
	
	
	static String Filepath;
	static String Sheetname;
	
	public ExcelToPOJOMapper(String filePath ,String sheetname)
	{
		this.Filepath=filePath;
		this.Sheetname= sheetname;
	}

	
	
	public List<HotelPojo> getBookingdata() throws IOException
	{
		
		List<HotelPojo> dataList= new ArrayList<>();
		
		FileInputStream fis= new FileInputStream(Filepath);
		Workbook workbook= new XSSFWorkbook(fis);
		Sheet sheet= workbook.getSheet(Sheetname);
		
		Row headerRow= sheet.getRow(0);
		int totalRows= sheet.getLastRowNum();
		
		
		for(int i=1; i<=totalRows; i++)
		{
			Row dataRow= sheet.getRow(i);
			if(dataRow==null) continue;
			
			HotelPojo pojo= new HotelPojo();
			HotelBookingDates bookingDates= new HotelBookingDates();
			
			for(int j=0; j<headerRow.getLastCellNum();j++)
			{
				String Key= headerRow.getCell(j).getStringCellValue();
				Cell cell= dataRow.getCell(j);
				
				if(cell==null)continue;
				
				switch(Key.toLowerCase())
				{
				case "firstname":
					pojo.setFirstname(cell.getStringCellValue());
					break;
				case "lastname":
					pojo.setLastname(cell.getStringCellValue());
				    break;
				case "totalprice":
					pojo.setTotalprice((int)cell.getNumericCellValue());
					break;
				case "depositpaid":
					pojo.setDepositpaid(cell.getBooleanCellValue());
					break;
				case "checkin":
					bookingDates.setCheckin(cell.getStringCellValue());
				case "chekcout":
					bookingDates.setCheckout(cell.getStringCellValue());
					break;
				case "additionalneeds":
				    pojo.setAdditionalneeds(cell.getStringCellValue());
				    break;
				}
				
			}
			pojo.setBookingdates(bookingDates);
			dataList.add(pojo);
		}
		
		workbook.close();
		fis.close();
		return dataList;
		
	}
}

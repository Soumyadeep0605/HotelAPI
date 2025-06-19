package API_EndPoint;

import java.util.ResourceBundle;

public class routesAsProperties {
	
	public static ResourceBundle getURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes"); // load properties file
		return rb;
		
	}
	
	public static ResourceBundle postURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes");
		return rb;
	}

	public static ResourceBundle UpdateURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes");
		return rb;
	}
	
	public static ResourceBundle DeleteURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes");
		return rb;
	}
	
	
}

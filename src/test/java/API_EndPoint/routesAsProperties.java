package API_EndPoint;

import java.util.ResourceBundle;

public class routesAsProperties {
	
	static ResourceBundle getURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes"); // load properties file
		return rb;
		
	}
	
	static ResourceBundle postURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes");
		return rb;
	}

	static ResourceBundle UpdateURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes");
		return rb;
	}
	
	static ResourceBundle DeleteURL()
	{
		ResourceBundle rb= ResourceBundle.getBundle("routes");
		return rb;
	}
	
	
}

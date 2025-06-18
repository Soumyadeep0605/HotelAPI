package API_Payload;

import java.util.Date;

public class HotelBookingDates {

	
	private String checkin;
	private String checkout;
	
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String string) {
		this.checkin = string;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String string) {
		this.checkout = string;
	}
	
	 @Override
	    public String toString() {
	        return "{checkin='" + checkin + "', checkout='" + checkout + "'}";
	

}
}

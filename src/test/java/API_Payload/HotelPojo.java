package API_Payload;

public class HotelPojo {
	
	 String firstname;
	 String lastname;
	 int totalprice;
	 boolean depositpaid;
	 String additionalneeds;
	 HotelBookingDates bookingdates;
	 
	 public HotelBookingDates getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(HotelBookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	
	
	public String toString()
	{
		
		return "HotelPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
		
	}

}

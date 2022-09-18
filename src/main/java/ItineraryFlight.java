
public class ItineraryFlight {
	private int number;
	private String departure_name;
	private String departure_code;
	private String arrival_name;
	private String arrival_code;
	private int day;
	private int orders;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getDeparture_name() {
		return departure_name;
	}
	public void setDeparture_name(String departure_name) {
		this.departure_name = departure_name;
	}
	public String getDeparture_code() {
		return departure_code;
	}
	public void setDeparture_code(String departure_code) {
		this.departure_code = departure_code;
	}
	public String getArrival_name() {
		return arrival_name;
	}
	public void setArrival_name(String arrival_name) {
		this.arrival_name = arrival_name;
	}
	public String getArrival_code() {
		return arrival_code;
	}
	public void setArrival_code(String arrival_code) {
		this.arrival_code = arrival_code;
	}
	public ItineraryFlight(int number, String departure_name, String departure_code, String arrival_name,
			String arrival_code, int day) {
		super();
		this.number = number;
		this.departure_name = departure_name;
		this.departure_code = departure_code;
		this.arrival_name = arrival_name;
		this.arrival_code = arrival_code;
		this.day = day;
		this.orders = 0;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Flight: " + getNumber() + ", departure: " + getDeparture_code() +", arrival: " + getArrival_code() +", day: "+ getDay()+ "";
	}


}

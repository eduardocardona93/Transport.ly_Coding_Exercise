
public class Order {
	private String destination;
	private String number;
	private int flight_number;
	private String departure_city;
	private String arrival_city;
	private int day;
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Order(String destination, String number, int flight_number, String departure_city, String arrival_city,
			int day) {
		super();
		this.destination = destination;
		this.number = number;
		this.flight_number = flight_number;
		this.departure_city = departure_city;
		this.arrival_city = arrival_city;
		this.day = day;
	}
	public Order(String number) {
		super();
		this.number = number;
		this.flight_number = -1;
		this.departure_city = null;
		this.arrival_city = null;
		this.day = -1;
	}
	@Override
	public String toString() {

		if(flight_number > -1)
			return "order: " + number + ", flightNumber: " + flight_number + ", departure: " + departure_city + ", arrival: " + arrival_city + ", day:" + day ;
		else
			return "order: " + number + ", flightNumber: not scheduled";
	}
	
	
}

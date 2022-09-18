import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {

	public static void main(String[] args) {

		// itinerary flights list definition
		ArrayList<ItineraryFlight> itineraryFlights = new ArrayList();
		// itinerary flights predefined set
		itineraryFlights.add(new ItineraryFlight(1,"Montreal", "YUL", "Toronto", "YYZ", 1));
		itineraryFlights.add(new ItineraryFlight(2,"Montreal", "YUL", "Calgary", "YYC", 1));
		itineraryFlights.add(new ItineraryFlight(3,"Montreal", "YUL", "Vancouver", "YVR", 1));
		itineraryFlights.add(new ItineraryFlight(4,"Montreal", "YUL", "Toronto", "YYZ", 2));
		itineraryFlights.add(new ItineraryFlight(5,"Montreal", "YUL", "Calgary", "YYC", 2));
		itineraryFlights.add(new ItineraryFlight(6,"Montreal", "YUL", "Vancouver", "YVR", 2));



		// itinerary flights printing
		System.out.println("Flight Itinerary");
		for (ItineraryFlight itineraryFlight : itineraryFlights) {
			System.out.println(itineraryFlight.toString());
		}
		List<Order> orderList = new ArrayList();
		JSONParser jsonParser = new JSONParser();
		String filePath = new File("").getAbsolutePath();
		try{
			FileReader reader = new FileReader(filePath + "\\src\\main\\resources\\coding-assigment-orders.json");
			//Read JSON file
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);

			Iterator<String> keys = json.keySet().iterator();
			// Iterate orders
			while (keys.hasNext()) {
				String order_number = keys.next(); // gets iterated order number
				String flight_number = "not scheduled"; // sets the flight number as not scheduled
				String destination = ((HashMap) json.get(order_number)).get("destination").toString(); // gets the order destination
				for (ItineraryFlight itineraryFlight : itineraryFlights) { // searchs for the flight with a common destination with the order
					if(itineraryFlight.getArrival_code().equalsIgnoreCase(destination)  && itineraryFlight.getOrders() <= 20) { // validates if the flight has enough space for orders
						flight_number = Integer.toString(itineraryFlight.getNumber()) ; // sets the flight number
						itineraryFlight.setOrders(itineraryFlight.getOrders()+1); // adds an order to the flight orders count
						// creates the order element and adds it to the list
						orderList.add(new Order(itineraryFlight.getDeparture_code(), order_number, itineraryFlight.getNumber(),itineraryFlight.getDeparture_code() , itineraryFlight.getArrival_code(), itineraryFlight.getDay()));
						break;
					}

				}
				
				// if the flight is not scheduled then creates an order with no scheduled flight
				if(flight_number.equals("not scheduled")) {
					orderList.add(new Order(order_number));
				}
			}
			// prints the order
			for (Order order : orderList) {
				System.out.println(order.toString());
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}



	}

}

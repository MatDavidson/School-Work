package prob1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AirportLoader {

	public static Map<String,Airport> getAirportMap(String fileName){
//_sp18_solution --add back to filepath
		File airportFile = new File("src\\prob1\\" + fileName);

		Map<String,Airport> airports = new HashMap<>();
		try(Scanner input = new Scanner(airportFile)) {
			while(input.hasNextLine()){
				String code = input.next();
				double latitude = input.nextDouble();
				double longitude = input.nextDouble();
				String city = input.next();
				String state = input.next();

				Airport airport = new Airport(code, latitude, longitude, city, state);
				airports.put(airport.getCode(), airport);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return airports;
	}
}

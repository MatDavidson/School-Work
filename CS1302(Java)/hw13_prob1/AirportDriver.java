package prob1;

import java.util.*;

public class AirportDriver {

	public static void main(String[] args) {

		String airportFileSmall = "airportFileSmall.txt";
		String airportFileMedium = "airportFileMedium.txt";
		String airportFileSameCities = "airportFileSameCities.txt";
		Map<String,Airport> airports;
		double dist;
		Airport a1, a2;

		// Test 1
		airports = AirportLoader.getAirportMap(airportFileSmall);
		System.out.println("Test 1: AirportLoader.getAirportList()\n");
		print(airports);

		// Test 2
		AirportManager airportManager;
		airports = AirportLoader.getAirportMap(airportFileSmall);
		airportManager = new AirportManager(airports);
		a1 = airportManager.getAirport("ANB");
		a2 = airportManager.getAirport("VLD");
		System.out.println("\nTest 2a: AirportManager.getAirport('ANB')\n");
		System.out.println(a1);
		System.out.println("\nTest 2b: AirportManager.getAirport('VLD')\n");
		System.out.println(a2);

		// Test 3
		airports = AirportLoader.getAirportMap(airportFileSmall);
		airportManager = new AirportManager(airports);
		a1 = airportManager.getAirport("ANB");
		a2 = airportManager.getAirport("VLD");
		dist = airportManager.getDistanceBetween(a1,a2);
		System.out.println("\nTest 3: AirportManager.getDistanceBetween(a1,a2)\n");
		System.out.println(dist);

		// Test 4
		airports = AirportLoader.getAirportMap(airportFileSmall);
		airportManager = new AirportManager(airports);
		dist = airportManager.getDistanceBetween("ANB", "VLD");
		System.out.println("\nTest 4: AirportManager.getDistanceBetween('ANB', 'VLD')\n");
		System.out.println(dist);

		// Test 5
		airports = AirportLoader.getAirportMap(airportFileSmall);
		airportManager = new AirportManager(airports);
		Airport closest;
		closest = airportManager.getAirportClosestTo("ANB");
		System.out.println("\nTest 5a: AirportManager.getAirportClosestTo('ANB')\n");
		System.out.println(closest);
		closest = airportManager.getAirportClosestTo("VLD");
		System.out.println("\nTest 5b: AirportManager.getAirportClosestTo('VLD')\n");
		System.out.println(closest);

		// Test 6
		airports = AirportLoader.getAirportMap(airportFileMedium);
		airportManager = new AirportManager(airports);
		List<Airport> within = airportManager.getAirportsWithin("ANB", 150);
		System.out.println("\nTest 6a: AirportManager.getAirportsWithin('ANB', 150)\n");
		print(within);
		within = airportManager.getAirportsWithin("VLD", 150);
		System.out.println("\nTest 6b: AirportManager.getAirportsWithin('VLD', 150)\n");
		print(within);

		// Test 7
		airports = AirportLoader.getAirportMap(airportFileMedium);
		airportManager = new AirportManager(airports);
		within = airportManager.getAirportsWithin("ANB", "VLD", 150);
		System.out.println("\nTest 7: AirportManager.getAirportsWithin('ANB', 'VLD', 150)\n");
		print(within);

		// Test 8
		airports = AirportLoader.getAirportMap(airportFileSameCities);
		airportManager = new AirportManager(airports);
		List<Airport> sorted = airportManager.getAirportsSortedBy("City");
		System.out.println("\nTest 8a: AirportManager.getAirportsSortedBy('City')");
		print(sorted);
		sorted = airportManager.getAirportsSortedBy("State");
		System.out.println("\nTest 8b: AirportManager.getAirportsSortedBy('State')");
		print(sorted);
//		System.out.println("\nTest 8c: debug test");
//		print(airportManager.getAirports());


		// Test 9
		airports = AirportLoader.getAirportMap(airportFileSmall);
		airportManager = new AirportManager(airports);
		List<Airport> closestAirports = airportManager.getAirportsClosestTo("ANB", 1);
		System.out.println("\nTest 9a: AirportManager.getAirportsClosestTo('ANB', 1)");
		print(closestAirports);
		closestAirports = airportManager.getAirportsClosestTo("ANB", 2);
		System.out.println("\nTest 9b: AirportManager.getAirportsClosestTo('ANB', 2)");
		print(closestAirports);
		closestAirports = airportManager.getAirportsClosestTo("ANB", 3);
		System.out.println("\nTest 9c: AirportManager.getAirportsClosestTo('ANB', 3)");
		print(closestAirports);

		// Test 10
		airports = AirportLoader.getAirportMap(airportFileSameCities);
		airportManager = new AirportManager(airports);
		List<Airport> byCity = airportManager.getAirportsByCity("Greenville");
		System.out.println("\nTest 10: AirportManager.getAirportsByCity('Greenville')");
		print(byCity);

		// Test 11
		airports = AirportLoader.getAirportMap(airportFileSameCities);
		List<Airport> byCityState = airportManager.getAirportsByCityState("Greenville", "SC");
		System.out.println("\nTest 11: AirportManager.getAirportsByCityState('Greenville','SC')");
		print(byCityState);

		// Test 12
		airports = AirportLoader.getAirportMap(airportFileMedium);
		airportManager = new AirportManager(airports);
		List<Airport> byNWs = airportManager.getNWSNamedAirports();
		System.out.println("\nTest 12: AirportManager.getNWSNamedAirport()");
		print(byNWs);

		// Test 13
		airports = AirportLoader.getAirportMap(airportFileMedium);
		airportManager = new AirportManager(airports);
		List<Airport> byLoc = airportManager.getAirportsWithin(75,31.4,84.1);
		System.out.println("\nTest 13a: AirportManager.getAirportsWithin(75,31.53,84.18)");
		print(byLoc);
		byLoc = airportManager.getAirportsWithin(70,31.4,84.1);
		System.out.println("\nTest 13b: AirportManager.getAirportsWithin(70,31.53,84.18)");
		print(byLoc);
	}

	private static void print(Map<String,Airport> airports){
		for( Airport a : airports.values())
			System.out.println(a);
	}

	private static void print(List<Airport> airports){
		for( Airport a : airports)
			System.out.println(a);
	}
}

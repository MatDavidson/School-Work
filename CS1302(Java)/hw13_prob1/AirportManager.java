package prob1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AirportManager {
	private Map<String, Airport> airports = new HashMap<String, Airport>();
	
	public AirportManager(Map<String, Airport> airports) {
		this.airports = airports;
	}
	
	public Airport getAirport(String code) {
		return airports.get(code);
	}
	
	public double getDistanceBetween(Airport airport1, Airport airport2) {
		double lat1 = airport1.getLatitude();
		double long1 = airport1.getLongitude();
		double lat2 = airport2.getLatitude();
		double long2 = airport2.getLongitude();
		
		return DistanceCalculator.getDistance(lat1, long1, lat2, long2);
	}
	
	public double getDistanceBetween(String code1, String code2) {
		Airport airport1 = airports.get(code1);
		Airport airport2 = airports.get(code2);
		
		return getDistanceBetween(airport1, airport2);
	}
	
	public Airport getAirportClosestTo(String code) {
		Set<String> keys = airports.keySet();
		double dist = 999999.9;
		Airport closest = null;
		
		for(String key: keys) {
			if(!code.equals(key)) {
				if(getDistanceBetween(code,key) < dist) {
					dist = getDistanceBetween(code,key);
					closest = airports.get(key);
				}
			}
		}
		return closest;
	}
	
	public List<Airport> getAirportsWithin(String code, double withinDist){
		List<Airport> within = new ArrayList<>();
		Set<String> keyes = airports.keySet();
		
		for(String key: keyes) {
			if(getDistanceBetween(code,key) < withinDist && !code.equals(key))
				within.add(airports.get(key));
		}
		return within;
	}
	
	public List<Airport> getAirportsWithin(String code1, String code2, double withinDist){
		List<Airport> within1 = getAirportsWithin(code1, withinDist);
		List<Airport> within2 = getAirportsWithin(code2, withinDist);
		List<Airport> withinBoth = new ArrayList<>();
		
		for(Airport a: within1) {
			if(within2.contains(a))
				withinBoth.add(a);
		}
		return withinBoth;
	}
	
	public List<Airport> getAirportsSortedBy(String sortType){
		List<Airport> list = new ArrayList<>();
		Set<String> keys = airports.keySet();
		
		for(String key: keys) {
			list.add(airports.get(key));
		}
		
		if(sortType.equals("City")) {
			list.sort(new CityComparator());
			return list;
		}	
		else if(sortType.equals("State")) {
			list.sort(new StateComparator());
			return list;
		}	
		else
			return null;
	}
	
	public List<Airport> getAirportsClosestTo(String code, int num){
		List<Airport> closeTo = new ArrayList<>();
		Set<String> keys = airports.keySet();
		Map<Double, String> distances = new HashMap<Double, String>();
		
		for(String key: keys) {
			if(!key.equals(code))
			distances.put(getDistanceBetween(airports.get(code),airports.get(key)), key);
		}
		
		Set<Double> temp = distances.keySet();
		List<Double> distancesKeys = new ArrayList<>();
		distancesKeys.addAll(temp);
		distancesKeys.sort(new DoubleComparator());
		
		for(int i = 0; i < num; i++) {
			closeTo.add(airports.get(distances.get(distancesKeys.get(i))));
		}
		
		return closeTo;
	}
	
	public List<Airport> getAirportsByCity(String city){
		List<Airport> result = new ArrayList<>();
		Set<String> keys = airports.keySet();
		
		for(String key: keys) {
			if(airports.get(key).getCity().equals(city))
				result.add(airports.get(key));
		}
		return result;
	}
	
	public List<Airport> getAirportsByCityState(String city, String State){
		List<Airport> result = new ArrayList<>();
		Set<String> keys = airports.keySet();
		
		for(String key: keys) {
			if(airports.get(key).getCity().equals(city) && airports.get(key).getState().equals(State))
				result.add(airports.get(key));
		}
		return result;
	}
	
	public List<Airport> getNWSNamedAirports(){
		List<Airport> result = new ArrayList<>();
		Set<String> keys = airports.keySet();
		
		for(String key: keys) {
			if(key.endsWith("X"))
				result.add(airports.get(key));
		}
		return result;
	}
	
	public List<Airport> getAirportsWithin(double withinDist, double lat, double lon){
		Airport dummy = new Airport("+++", lat, lon, null, null);
		
		airports.put("+++", dummy);
		List<Airport> within = getAirportsWithin("+++", withinDist);
		
		airports.remove("+++");
		
		return within;
	}
}

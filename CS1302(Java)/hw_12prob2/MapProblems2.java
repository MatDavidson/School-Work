package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MapProblems2 {
	public static HashMap<Integer, Double> week1 = new HashMap<Integer, Double>();
	public static HashMap<Integer, Double> week2 = new HashMap<Integer, Double>();
	public static HashMap<Integer, Double> week3 = new HashMap<Integer, Double>();

	public static void main(String[] args) {
		week1.put(43, 100.10);
		week1.put(19, 200.50);
		week1.put( 7, 300.25);
		week1.put(28, 110.00);
		
		week2.put(92, 200.00);
		week2.put(28, 190.00);
		week2.put( 7, 100.75);
		week2.put(51, 200.25);
		week2.put(63, 100.10);
		
		System.out.println("Week 1: " + week1);
		System.out.println("Week 2: " + week2);
		
		System.out.println("Worked both: " + workedBoth(week1, week2));
		
		System.out.println("\nWeek 1: " + week1);
		System.out.println("Week 2: " + week2);
		System.out.println("Worked  one: " + onlyWorkedOne(week1, week2));
		
		System.out.println("\nWeek 1: " + week1);
		System.out.println("Week 2: " + week2 + "\n");
		
		week1.clear();
		week1.put(1, 50.0);
		week1.put(2, 300.0);
		week1.put(3, 200.0);
		
		week2.clear();
		week2.put(2, 50.0);
		week2.put(3, 25.0);
		
		week3.put(1, 25.0);
		week3.put(3, 25.0);
		week3.put(4, 50.0);
		
		List<HashMap<Integer, Double>> maps = new ArrayList<>();
		maps.add(week1);
		maps.add(week2);
		maps.add(week3);
		
		List<Sales> sales = sortSales(maps);
		
		for(Sales s: sales) {
			System.out.println(s.toString());
		}
	}
	
	public static HashMap<Integer, Double> workedBoth(HashMap<Integer, Double> week1, HashMap<Integer, Double> week2){
		HashMap<Integer, Double> workedBoth = new HashMap<Integer, Double>();
		Set<Integer> keyes = week1.keySet();
		
		for(Integer key: keyes) {
			if(week2.keySet().contains(key)) {
				double val = (week1.get(key) + week2.get(key));
				workedBoth.put(key, val);
			}
		}
		return workedBoth;
	}
	
	public static HashMap<Integer, Double> onlyWorkedOne(HashMap<Integer, Double> week1, HashMap<Integer, Double> week2){
		HashMap<Integer, Double> workedOne = new HashMap<Integer, Double>();
		Set<Integer> keyes = week1.keySet();

		for(Integer key: keyes) {
			if(!week2.keySet().contains(key)) {
				workedOne.put(key, week1.get(key));
			}
		}
		
		keyes = week2.keySet();
		
		for(Integer key: keyes) {
			if(!week1.keySet().contains(key)) {
				workedOne.put(key, week2.get(key));
			}
		}
		return workedOne;
	}	
	
	public static List<Sales> sortSales(List<HashMap<Integer, Double>> maps){
		List<Sales> sales = new ArrayList<>();
		int week = 0;
		
		for(HashMap<Integer, Double> map: maps) {
			week++;
			Set<Integer> keys = map.keySet();
			
			for(Integer key: keys) {
				Sales s = new Sales(key, map.get(key), week);
				sales.add(s);
			}
		}
		Collections.sort(sales, new SalesComparator());
		return sales;
	}
}

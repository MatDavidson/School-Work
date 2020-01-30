package prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetProblems {
	
	private static Set<String> names1 = new HashSet<>(Arrays.asList("Tim", "Bob", "Bill", "Fred", "Gabby", "Kelly", "Marsha", "Ashley", "Cassandra", "Rodrigo"));	
	private static Set<String> names2 = new HashSet<>(Arrays.asList("Tim", "Mat", "Jack", "Fred", "Gabby", "Carla", "Marsha", "Thomas", "Cassandra", "Armondo"));

	private static List<String> names3 = new ArrayList<>(names1);
	
	
	public static void main(String[] args) {
		names3.addAll(names2);
		
		removeLongNames(names1, 6);
		System.out.println(names1);
		
		System.out.println(getNamesInCommon(names1, names2));
		
		System.out.println(justInFirst(names1, names2));
		
		System.out.println(getIndicesForMatches(names3, names2));
		
		System.out.println(getUniqueNames(names3));
		
		removeDuplicates(names1, names2);
		
		System.out.println(names1);
		System.out.println(names2);
	}
	
	public static void removeLongNames(Set<String> names, int len) {
		Iterator<String> iter = names.iterator();
		
		while(iter.hasNext()) {
			if(iter.next().length() > len)
				iter.remove();
		}
	}
	
	public static Set<String> getNamesInCommon(Set<String> set1, Set<String> set2){
		Set<String> common = new HashSet<>();
		Iterator<String> iter = set1.iterator();
		
		while(iter.hasNext()) {
			String name = iter.next();
			if(set2.contains(name)) {
				common.add(name);
			}
		}
		
		return common;
	}
	
	public static Set<String> justInFirst(Set<String> set1, Set<String> set2){
		Set<String> firstOnly = new HashSet<>();

		Iterator<String> iter = set1.iterator();

		while(iter.hasNext()) {
			String name = iter.next();
			if(!set2.contains(name)) {
				firstOnly.add(name);
			}
		}
		
		return firstOnly;
	}
	
	public static Set<Integer> getIndicesForMatches(List<String> list, Set<String> set){
		Set<Integer> indices = new HashSet<>();

		Iterator<String> iter = list.iterator();

		while(iter.hasNext()) {
			String name = iter.next();
			if(set.contains(name)) {
				indices.add(list.indexOf(name));
			}
		}

		return indices;
	}
	
	public static void removeDuplicates(Set<String> set1, Set<String> set2) {
		List<String> temp1 = new ArrayList<>(set1);
		List<String> temp2 = new ArrayList<>(set2);
		
		Iterator<String> iter = temp1.iterator();

		while(iter.hasNext()) {
			String name = iter.next();
			if(temp2.contains(name)) {
				set2.remove(name);
				set1.remove(name);
			}
		}
	}

	public static List<String> getUniqueNames(List<String> names){
		List<String> uniqueList = new ArrayList<>();
		Set<String> uniqueSet = new HashSet<>();
		
		for(String name: names) {
			uniqueSet.add(name);
		}
		
		uniqueList.addAll(uniqueSet);
		
		return uniqueList;
	}
}

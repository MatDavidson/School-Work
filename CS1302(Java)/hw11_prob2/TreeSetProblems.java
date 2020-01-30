package prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetProblems {
	public static HashSet<Integer> nums = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	public static List<Integer> locs = new ArrayList<>(Arrays.asList(1,3,5));
	public static List<String> words1 = new ArrayList<>(Arrays.asList("dog","cat","bug","egg","bat","gem"));

	public static void main(String[] args) {		
		System.out.println(nums);
		System.out.println(getBig(nums, 5));
		System.out.println(nums);
	
		System.out.println(words1);
		System.out.println(getWords(locs, words1));
		System.out.println(words1);
		
		System.out.println(words1);
		System.out.println(getWords2(locs, words1));
		System.out.println(words1);
	}
	
	public static TreeSet<Integer> getBig(HashSet<Integer> ints, int t){
		TreeSet<Integer> result = new TreeSet<>();
		
		Iterator<Integer> iter = ints.iterator();
		
		while(iter.hasNext()) {
			int i = iter.next();
			if(i > t)
				result.add(i);
			else
				iter.remove();
		}	
		return result;
	}
	
	public static TreeSet<String> getWords(List<Integer> locations, List<String> words){
		TreeSet<String> result = new TreeSet<>();
		
		for(Integer i: locations) {
			result.add(words.get(i));
		}
		
		return result;
	}
	
	public static TreeSet<String> getWords2(List<Integer> locations, List<String> words){
		TreeSet<String> result = new TreeSet<>();
		
		Collections.sort(locations);
		
		for(int i = locations.size()-1; i >= 0; i--) {
			result.add(words.get(locations.get(i)));
			words1.remove(words.get(locations.get(i)));
		}
		
		return result;
	}
}

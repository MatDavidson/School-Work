package prob1;

import java.util.Set;
import java.util.TreeMap;

public class MapProblems1 {
	public static TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
	
	public static void main(String[] args) {
//		tm.put('A', 8);
//		tm.put('B', 2);
//		tm.put('C', 4);
//		tm.put('G', 2);
//		tm.put('L', 8);
//		tm.put('P', 2);
//		tm.put('R', 1);
//		tm.put('V', 3);
//		
//		System.out.println(tm);
//		System.out.println(swapKeyValue(tm));
	}
	
	public static TreeMap<Integer, String> swapKeyValue(TreeMap<Character, Integer> tm){
		TreeMap<Integer, String> swapTM = new TreeMap<Integer, String>();
		Set<Character> keyes = tm.keySet();
		
		for(Character key: keyes) {
			if(!swapTM.keySet().contains(tm.get(key))) {
				swapTM.put(tm.get(key), key.toString());
			}
			else {
				int i = tm.get(key);
				String s = (swapTM.get(i) + key.toString());
				swapTM.put(i, s);
			}	
		}
		return swapTM;
	}
}

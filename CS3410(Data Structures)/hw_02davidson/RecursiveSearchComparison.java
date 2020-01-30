package hw_02davidson;

import java.util.Arrays;

public class RecursiveSearchComparison {
public static StringBuilder s = new StringBuilder();
	
	public static void main(String[] args) {
		
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		searchCompare();
		
		System.out.print(s.toString());

	}
	
	//Returns a new array of size 2^20, populates it with random integers up to one million 
	//	and sorts it.
	public static int[] createArray() {
		int[] a = new int[1048576];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*1000000)+1;
		}
		Arrays.sort(a);
		
		return a;
	}
	
	//Recursive linear search method 
	public static boolean recursiveLinearSearch(int[] a, int n, int key) {
		if(n >= a.length)
			return false;
		else if(a[n] == key)
			return true;
		else
			return recursiveLinearSearch(a, n+1, key);
	}
	

	
	//Recursive binary search method
	public static boolean recursiveBinarySearch(int[] a, int key, int begin, int end) {
		int mid = (end - begin)/2 + begin;
		
		if(begin > end)
			return false;
		
		if(key < a[mid])
			return recursiveBinarySearch(a, key, begin, mid-1);
		else if(key == a[mid])
			return true;
		else 
			return recursiveBinarySearch(a, key, mid+1, end);
	}
	
	//Calculates the time in nanoseconds between starting and ending linear search
	public static void recursiveLinearSearchTime(int[] a, int key) {
		long t1, t2;
		
		t1 = System.nanoTime();
		recursiveLinearSearch(a, 0, key);
		t2 = System.nanoTime();
		
		s.append("\n\tRecursive linear time in nS: " + (t2-t1));
	}
	
	//Calculates the time in nanoseconds between starting and ending binary search
	public static void recursiveBinarySearchTime(int[] a, int key) {
		long t1, t2;
		
		t1 = System.nanoTime();
		recursiveBinarySearch(a, key, 0, a.length-1);
		t2 = System.nanoTime();
		
		s.append("\n\tRecursive binary time in nS: " + (t2 - t1));
	}
	
	//Creates an array and a random key value and compares linear search versus binary search time
	public static void searchCompare() {

		int[] a = createArray();
		int key = (int)(Math.random()*1000000)+1;
		
		s.append("\n**************************************************");
		s.append("\n\tValue of key:" + key);
		recursiveLinearSearchTime(a, key);
		recursiveBinarySearchTime(a, key);
		s.append("\n\tKey found: " + recursiveBinarySearch(a, key, 0, a.length-1));
		s.append("\n**************************************************");
	}
}

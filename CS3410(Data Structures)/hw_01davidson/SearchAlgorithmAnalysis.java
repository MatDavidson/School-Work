package hw_01davidson;

import java.util.Arrays;

public class SearchAlgorithmAnalysis {

	public static StringBuilder s = new StringBuilder();
	
	public static void main(String[] args) {
		
		searchCompare(10);
		searchCompare(100);
		searchCompare(1000);
		searchCompare(10000);
		searchCompare(100000);
		
		System.out.print(s.toString());

	}
	
	//Accepts an, integer and creates an array of that size. Array is automatically populated 
	//	according to the assignment and sorted.
	public static int[] createArray(int size) {
		int[] a = new int[size];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*100000)+1;
		}
		Arrays.sort(a);
		
		return a;
	}
	
	//Linear search method
	public static boolean linearSearch(int[] a, int key) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == key)
				return true;
		}
		
		return false;
	}
	
	//Binary search method
	public static boolean binarySearch(int[] a, int key) {
		int begin = 0;
		int end = a.length -1;
		int mid;
		
		while(begin<=end) {
			mid = (int)(begin + end)/2;
			if(a[mid] == key)
				return true;
			else if(a[mid] > key)
				end = mid - 1;
			else
				begin = mid + 1;
		}
		
		return false;
	}
	
	//Calculates the time in nanoseconds between starting and ending linear search
	public static void linearSearchTime(int[] a, int key) {
		long t1, t2;
		t1 = System.nanoTime();
		s.append("\n\tFound with linear search: " + linearSearch(a, key));
		t2 = System.nanoTime();
		
		s.append("\n\tLinear time in nS: " + (t2-t1));
	}
	
	//Calculates the time in nanoseconds between starting and ending binary search
	public static void binarySearchTime(int[] a, int key) {
		long t1, t2;
		t1 = System.nanoTime();
		s.append("\n\tFound with binary search: " + binarySearch(a, key));
		t2 = System.nanoTime();
		
		s.append("\n\tBinary time in nS: " + (t2 - t1));
	}
	
	//Creates an array and a random key value and compares linear search versus binary search time
	public static void searchCompare(int size) {

		int[] a = createArray(size);
		int key = (int)(Math.random()*100000)+1;
		
		s.append("\n**************************************************");
		s.append("\n\tSize of N: " + a.length);
		s.append("\n\tValue of key:" + key);
		linearSearchTime(a, key);
		binarySearchTime(a, key);
		s.append("\n**************************************************");
	}
}

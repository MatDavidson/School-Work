package prob2;

import java.util.ArrayList;

public class BinarySearchTester {

	public static int binarySearch( ArrayList<Blob> blobs, Blob bKey1, Blob bKey2 ) {
		int mid = blobs.size()/2;
		int key = bKey1.getCoolnessFactor() + bKey2.getCoolnessFactor();
		
		if(mid % 2 != 0)
			mid -= 1;
		
		int cool = blobs.get(mid).getCoolnessFactor() + blobs.get(mid + 1).getCoolnessFactor();
		
		if(key == cool)
			return mid;
		else if(key < cool) {			
			return binarySearch(blobs, key, 0, mid - 1);
		}
		else {
			return binarySearch(blobs, key, mid + 1, blobs.size());
		}
	}
	
	public static int binarySearch( ArrayList<Blob> blobs, int key, int low, int high ) {
		int mid = (low + high)/2;
		
		if(mid % 2 != 0)
			mid -= 1;
		
		if(low > mid)
			return -(low + 2);
		
		int cool = blobs.get(mid).getCoolnessFactor() + blobs.get(mid + 1).getCoolnessFactor();
		
		if(low == high && key != cool)
			return -(low);
		
		if(key == cool)
			return mid;
		
		else if(key < cool) {
			return binarySearch(blobs, key, low, mid - 1);
		}
		else {			
			return binarySearch(blobs, key, mid + 1, high);
		}
	}

	public static void main( String[] args ) {
		// Sample code to create a sorted Blob list with 5 twins (10 elements).
		// You should make sure your code works with other numbers of twins.
		ArrayList<Blob> blobs = buildBlobList(8);
		printBlobList(blobs);
		// ---> WRITE CODE HERE TO TEST <---
		System.out.println(binarySearch(blobs, new Blob(3), new Blob(7)));
		
		System.out.println(binarySearch(blobs, new Blob(5), new Blob(7)));
		
		System.out.println(binarySearch(blobs, new Blob(7), new Blob(7)));
		
		System.out.println(binarySearch(blobs, new Blob(1), new Blob(7)));
		
		System.out.println(binarySearch(blobs, new Blob(3), new Blob(3)));
		
		System.out.println(binarySearch(blobs, new Blob(6), new Blob(7)));
		
		System.out.println(binarySearch(blobs, new Blob(6), new Blob(5)));
		
		System.out.println(binarySearch(blobs, new Blob(6), new Blob(9)));
		
		System.out.println(binarySearch(blobs, new Blob(6), new Blob(1)));
		
		System.out.println(binarySearch(blobs, new Blob(9), new Blob(9)));
		
		System.out.println(binarySearch(blobs, new Blob(10), new Blob(10)));
		
		System.out.println(binarySearch(blobs, new Blob(10), new Blob(11)));
		
		System.out.println(binarySearch(blobs, new Blob(10), new Blob(9)));
	}

	// You may use this method to build and return a sorted Blob
	// list based on sum of coolness factor for each of the twins.
	// Creates "numTwins" twins (i.e. 2*numTwins elements)
	private static ArrayList<Blob> buildBlobList(int numTwins) {
		ArrayList<Blob> blobs = new ArrayList<>();
		int cNess = 2;
		for(int i=1; i<=numTwins; i++) {
			Blob b1 = new Blob(cNess);
			cNess+=2;
			Blob b2 = new Blob(cNess--);
			blobs.add(b1);
			blobs.add(b2);
		}
		return blobs;
	}

	// You may use this method to print a blob list in a way that
	// emphasizes the twins and the sum of their coolness factors.
	private static void printBlobList(ArrayList<Blob> blobs) {
		StringBuilder sb = new StringBuilder("Sorted Blob list:\n");
		for(int i=0; i<blobs.size(); i+=2) {
			int cNess1 = blobs.get(i).getCoolnessFactor();
			int cNess2 = blobs.get(i+1).getCoolnessFactor();
			int twinPower = cNess1 + cNess2;
			sb.append(String.format("B(%d)+B(%d)=%d, ", cNess1, cNess2, twinPower));
		}
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb.toString());
	}
}

package prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtilities {
	
	public static void main(String[] args) {
		List<Integer> l1;
		List<Integer> l2;

		System.out.println("Test 1a - list sizes equal");
		l1 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9,11));
		l2 = new ArrayList<Integer>(Arrays.asList(2,4,6,8,10,12));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,1)=" + interleave(l1,l2,1));

		System.out.println("\nTest 1b - list sizes equal");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,5,6,9,10));
		l2 = new ArrayList<Integer>(Arrays.asList(3,4,7,8,11,12));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,2)=" + interleave(l1,l2,2));

		System.out.println("\nTest 1b - list sizes equal");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,7,8,9));
		l2 = new ArrayList<Integer>(Arrays.asList(4,5,6,10,11,12));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,3)=" + interleave(l1,l2,3));

		System.out.println("\nTest 2a - list 1 > list 2");
		l1 = new ArrayList<Integer>(Arrays.asList(1,3,5,6));
		l2 = new ArrayList<Integer>(Arrays.asList(2,4));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,1)=" + interleave(l1,l2,1));

		System.out.println("\nTest 2b - list 1 > list 2");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,5,6));
		l2 = new ArrayList<Integer>(Arrays.asList(3,4));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,2)=" + interleave(l1,l2,2));

		System.out.println("\nTest 2c - list 1 > list 2");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,6));
		l2 = new ArrayList<Integer>(Arrays.asList(4,5));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,3)=" + interleave(l1,l2,3));

		System.out.println("\nTest 3a - list 1 < list 2");
		l1 = new ArrayList<Integer>(Arrays.asList(1,3));
		l2 = new ArrayList<Integer>(Arrays.asList(2,4,5,6));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,1)=" + interleave(l1,l2,1));

		System.out.println("\nTest 3b - list 1 < list 2");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2));
		l2 = new ArrayList<Integer>(Arrays.asList(3,4,5,6));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,2)=" + interleave(l1,l2,2));

		System.out.println("\nTest 4a");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,7,8,9,13));
		l2 = new ArrayList<Integer>(Arrays.asList(4,5,6,10,11,12));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,3)=" + interleave(l1,l2,3));

		System.out.println("\nTest 4b");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,7,8,9,13,14));
		l2 = new ArrayList<Integer>(Arrays.asList(4,5,6,10,11,12));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,3)=" + interleave(l1,l2,3));

		System.out.println("\nTest 4c");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,7,8,9,13,14,15));
		l2 = new ArrayList<Integer>(Arrays.asList(4,5,6,10,11,12));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,3)=" + interleave(l1,l2,3));

		System.out.println("\nTest 4d");
		l1 = new ArrayList<Integer>(Arrays.asList(1,2,3,7,8,9,13,14,15));
		l2 = new ArrayList<Integer>(Arrays.asList(4,5,6,10,11,12,16));
		System.out.println("l1=" + l1);
		System.out.println("l2=" + l2);
		System.out.println("interleave(l1,l2,3)=" + interleave(l1,l2,3));

		System.out.println("\nTest 5-Lists of Dogs");
		List<Dog> dogs1 = new ArrayList<>(Arrays.asList(new Dog(1), new Dog(2), new Dog(5), new Dog(6)));
		List<Dog> dogs2 = new ArrayList<>(Arrays.asList(new Dog(3), new Dog(4), new Dog(7)));
		System.out.println("dogs1=" + dogs1);
		System.out.println("dogs2=" + dogs2);
		System.out.println("interleave(dogs1,dogs2,2)=" + interleave(dogs1,dogs2,2));

	}
	
	public static <E> List<E> interleave(List<E> list1, List<E> list2, int n){
		int o = 0;
		List<E> result = new ArrayList<E>();
		if(list1.size() < n || list2.size() < n) {
			return null;
		}	

		if(list1.size() <= list2.size()) {
			while(o < list1.size()) {
				if(list1.subList(o, list1.size()).size() < n)
					return result;
				for(int i = o; i < o + n; i ++) {
					result.add(list1.get(i));
				}
				if(list2.subList(o, list2.size()).size() < n)
					return result;
				for(int i = o; i < o + n; i ++) {
					result.add(list2.get(i));
				}
				o += n;
			}
		}
		else{
			while(o < list2.size()) {
				if(list1.subList(o, list1.size()).size() < n)
					return result;
				for(int i = o; i < o + n; i ++) {
					result.add(list1.get(i));
				}
				if(list2.subList(o, list2.size()).size() < n)
					return result;
				for(int i = o; i < o + n; i ++) {
					result.add(list2.get(i));
				}
				o += n;
			}
			if(list1.subList(o, list1.size()).size() < n)
				return result;
			for(int i = o; i < o + n; i++) {
				result.add(list1.get(i));
			}
		}

		return result;
	}

}

//Mathieu Davidson
//Data Structures
//Lab 3

package RecursiveGCD;

import java.util.Scanner;

public class RecursiveGCD {
	public static Scanner input = new Scanner(System.in);
	public static int val1, val2;
	
	public static void main(String[] args) {
		System.out.print("\tThe Greatest Common Divisor of 35 and 7 is " + GCD(35, 7) + "!");
		System.out.print("\n\tThe Greatest Common Divisor of 25 and 2 is " + GCD(25, 2) + "!");
		System.out.print("\n\n\tYou can enter any two integers in any order and I will find the Greatest Common Divsor!");
		
		System.out.print("\n\n\tEnter an integer:\t");
		val1 = Integer.parseInt(input.next());
		
		System.out.print("\n\tEnter another integer:\t");
		val2 = Integer.parseInt(input.next());
		
		if(val1 < val2) {
			int temp = val1;
			val1 = val2;
			val2 = temp;
		}
		System.out.print("\n\tThe Greatest Common Divisor is " + GCD(val1, val2) + "!");
	}
	
	public static int GCD(int m, int n) {
		if(n == 0)
			return m;
		
		else if(m/n == 0)
			return n;
	
		else
			return GCD(n, m%n);
	}
}

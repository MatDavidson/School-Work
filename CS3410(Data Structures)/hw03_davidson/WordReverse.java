package hw03_davidson;

import java.util.Scanner;
import java.util.Stack;

public class WordReverse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> chars = new Stack<>();
		String word = "";
		StringBuilder sB = new StringBuilder();
		
		System.out.print("\tPlease enter a sentence.\n\t");

		String input = scan.nextLine();
	
		System.out.print("\n\tYou entered: \"" + input + "\"");
		
		String[] words = input.split(" ");
		
		for(int i=0; i < words.length; i++) {
			word = words[i];
			for (int j = 0; j < word.length(); j++) {
				chars.push(word.charAt(j));
			}
			while(!chars.empty()) {
				sB.append(chars.pop());
			}
			sB.append(" ");
		}
		sB.deleteCharAt(sB.length() -1);
		
		System.out.print("\n\tWords reversed: \"" + sB.toString() +"\"");
		scan.close();
	}

}

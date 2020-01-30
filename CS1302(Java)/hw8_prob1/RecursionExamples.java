package prob1;

public class RecursionExamples {

	public static void main(String[] args) {
//		printReverse("3412", 2);
//		printReverse("789456123" ,3);
//		printReverse("7456123", 3);
//	    printReverse("abcdefghijklmnopqrstuvwxyz" ,10);
//	    
//	    printReverse2("3412", 2);
//		printReverse2("789456123" ,3);
//		printReverse2("7456123", 3);
//	    printReverse2("abcdefghijklmnopqrstuvwxyz" ,10);
		
//		System.out.println(countDigits("abc",2,5));
//		System.out.println(countDigits("2a15963bc4",3,7));
		
//		System.out.println(countCode("Dac", "ac"));
//		System.out.println(countCode("Dac12ac", "ac"));
//		System.out.println(countCode("acacac", "ac"));
//		System.out.println(countCode("acacacacac", "ac"));
	}
	
	public static double sumSeries(int n) {
		if( n < 1)
			return 0.0;
		else if( n % 2 == 0)
			return sumSeries(n-1) - 1.0/n;
		else
			return sumSeries(n-1) + 1.0/n;
	}


	public static void printReverse(String s, int n) {
		int begin = s.length() - n;

		if( begin < 0)
			System.out.print(s + "\n");
		else {
			System.out.print(s.substring(begin));
			printReverse(s.substring(0, s.length()-n), n);
		}	
	}

	public static void printReverse2(String s, int n) {
		if(n < s.length()) 
			printReverse2(s, n, s.length()-n);
		else
			System.out.print(s);
	}

	private static void printReverse2(String s, int n, int loc) {
		if(loc <= 0)
			System.out.print(s.substring(0, loc + n) + "\n");
		else {
			System.out.print(s.substring(loc, loc + n));
			printReverse2(s, n, loc-n);
		}
	}

	public static int countDigits(String s, int low, int high) {
		int count = 0;
		char c;
		
		if(low > high)
			return 0;
		
		else if(low == high && low < s.length()) {
			c = s.charAt(low);
			if(Character.isDigit(c))
				count++;
		}
		else {
			if(low < s.length()) {
				c = s.charAt(low);
				if(Character.isDigit(c))
					count += 1 + countDigits(s, low + 1, high);
			}
		}
		
		return count;
	}

	public static int countCode(String msg, String code ) {
		int count = 0;
		
		if(msg.contains(code)) {
			count += 1 + countCode(msg, code, msg.indexOf(code) + code.length() + 1);
		}
		
		return count;
	}

	private static int countCode(String msg, String code, int pos ) {
		int count = 0;
		
		if(pos >= msg.length())
			return count;
		
		if(msg.substring(pos).contains(code)) {
			count += 1 + countCode(msg, code, pos + code.length() + 1);
		}
		return count;
	}
}

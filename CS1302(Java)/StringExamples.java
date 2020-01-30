package prob1;

public class StringExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//isLevel1 accepts a string and and checks if it is a level 1 password by passing that same password to 
	// to the 5 helper methods. So long as the first 2 return true and 2 of the second 3 return true,
	// the method returns true.
	public static boolean isLevel1(String password){
		if (isLongEnough(password) && hasNoSpaces(password)){
			if ((hasUpper(password) && hasLower(password)) || (hasUpper(password) && hasDigit(password)) || (hasLower(password) && hasDigit(password)))
				return true;
		}	
		return false;
	}		
	
	//isLevel2 accepts a string and and checks if it is a level 2 password by passing that same password to 
	// to the 5 helper methods. Only returns true if all 5 helper methods return true.
	public static boolean isLevel2(String password){
		if (isLongEnough(password) && hasNoSpaces(password) && hasUpper(password) && hasLower(password) && hasDigit(password)){
			return true;
		}
		return false;
	}
	
	//helper method that checks the length of the password
	public static boolean isLongEnough(String password){
		if (password.length() >= 6)
			return true;
		else
			return false;
	}
		
	//helper method that makes sure there are no spaces in the password
	public static boolean hasNoSpaces(String password){
		for (int i = 0; i < password.length(); i++){
			if (password.charAt(i) != ' ')
				continue;
			else
				return false;
		}
		return true;
	}
		
	//helper method that checks for at least one upper case letter in password
	public static boolean hasUpper(String password){
		for (int i = 0; i < password.length(); i++){
			if (Character.isUpperCase(password.charAt(i)))
				return true;
			else 
				continue;
		}
		return false;
	}
	
	//helper method that checks for at least one lower case letter in password
	public static boolean hasLower(String password){
		for (int i = 0; i < password.length(); i++){
			if (Character.isLowerCase(password.charAt(i)))
				return true;
			else 
				continue;
		}
		return false;
	}

	//helper method that checks for at least one digit in password
	public static boolean hasDigit(String password){
		for (int i = 0; i < password.length(); i++){
			if (Character.isDigit(password.charAt(i)))
				return true;
			else 
				continue;
		}
		return false;
	}
	
	//This method accepts a string and returns a new string of the words in the original in reverse order
	public static String reverseWords(String str){		
		String result = "";
		int start = (str.lastIndexOf(' '));		
		int end = str.length() -1;   
        
		while (start > 0){			
			result += (str.substring(start +1 , end +1) + ' ');
			end = start-1;
        	start = str.lastIndexOf(' ', end);
		}		
		if (start == -1)
			result += (str.substring(0, end +1));
				
		return result;	
	}
	
	//This method uses nested for loops to to go through the array of strings using the same process as
	// going through a two-dimensional array. It builds a new string that is comprised of first the unique
	// letters and then the unique numbers in the string array in the order that they occur
	public static String getUniqueCharsAndDigits(String[] str){
		String result = "";
		for (int i = 0; i < str.length; i++){
			for (int j = 0; j < str[i].length(); j++){
				if (Character.isLetter(str[i].charAt(j)) && !result.contains("" + str[i].charAt(j)))
					result += str[i].charAt(j);
			}
		}
		
		for (int i = 0; i < str.length; i++){
			for (int j = 0; j < str[i].length(); j++){
				if (Character.isDigit(str[i].charAt(j)) && !result.contains("" + str[i].charAt(j)))
					result += str[i].charAt(j);
			}
		}
		return result;
	}
	
	//This method accepts several arrays. It passes the salary array to a helper method to find the index of the
	// smallest salary. It then returns a string of the values in each array at the index found by the helper method
	public static String getSmallestSalaryString(String[] names, int[] ages, double[] salaries){
		
		int index = smallestDoubleIndex(salaries);
		
		String result = String.format("%s$%,.2f, %s%s, %s%d", "Smallest salary:", salaries[index], "Name:", names[index], "age:", ages[index]);
		return result;
	}
	
	//This helper method accepts a one dimensional array of double and returns the index of the smallest double
	public static int smallestDoubleIndex(double[] arr){
		double smallest = arr[0];
		int smallestIndex = 0;
		
		for (int i = 1; i < arr.length; i++){
			if (arr[i] < smallest){
				smallest = arr[i];
				smallestIndex = i;
			}				
		}
		return smallestIndex;
	}
}

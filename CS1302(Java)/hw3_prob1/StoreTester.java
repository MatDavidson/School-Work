package prob1;

import emps.Employee;

public class StoreTester {

	private static double score = 0.0;
	private static StringBuilder report = new StringBuilder();
	
	public static void main(String[] args) {
		report.append("\n\nTest Report");
		report.append("\n-----------");
		
		System.out.print(testOne());
		System.out.print(testTwo());
		System.out.print(testThree());
		System.out.print(testFour());
		System.out.print(testFive());
		System.out.print(testSix());
		System.out.print(testSeven());
		System.out.print(testEight());
		System.out.print(testNine());
		
		report.append("\n\n" + finishReport());
		System.out.print(report.toString());
	}
	//Method for generating generic employee objects with 40 hrs at $10/hr and adds them to emps array for the store object
	public static void generateEmps(int i, Store s) {
		String name = "";
		for( int j = 0; j < i; j++) {
			name = "emp" + Integer.toString(j);
			Employee emp = new Employee(name, 10.0);
			
			for( int k = 0; k < 5; k++) {
				emp.setHours(k, 8.0);
			}	
			s.addEmp(emp);
		}
	}
	//Method that will fill the hours for a manually generated employee
	public static void fillHours(Employee emp) {
		for( int k = 0; k < 5; k++) {
			emp.setHours(k, 8.0);
		}
	}	
	//Method that checks for the correct values in numEmps, getTotalHours and getTotalPay. Display true or false for each value and
	//	whether or not points have been awarded
	public static String resultChecker(Store s, int emps, double hrs, double pay, double points) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nResults Check:");
		result.append("\n--------------");
		result.append(String.format("\nEmployees: %d, Total Hours: %.2f, Total Pay: $%,.2f", s.getNumEmps(), s.getTotalHours(), s.getTotalPay()));
		result.append("\nEmployees expected: " + emps + ", " + (s.numEmps == emps));
		result.append("\nTotal Hours expected: " + hrs + ", " + (s.getTotalHours() == hrs));
		result.append("\nTotal Pay expected: " + pay + ", " + (s.getTotalPay() == pay));
		if( s.numEmps == emps && s.getTotalHours() == hrs && s.getTotalPay() == pay) {
			result.append("\nPoints awarded: " + points);
		}
		else {
			result.append("\nPoints awarded: 0");
		}
		return result.toString();
	}
	//Method that returns true or false after checking for the correct values in numEmps, getTotalhours and getTotlaPay. If the
	//	method returns true, points will be awarded
	public static boolean resultPass(Store s, int emps, double hrs, double pay) {
		if( s.numEmps == emps && s.getTotalHours() == hrs && s.getTotalPay() == pay) {
			return true;
		}
		else {
			return false;
		}
	}
	//Method that checks a position in the emps array for a predetermined name. Displays expected name at index and true or false
	//  also displays whether or not points have been awarded
	public static String arrayChecker(Store s, int index, String name, double points) {
		String result = "\n\nExpected employee at index " + index + ": " + name + ", " + (s.emps[index].getName().equals(name));
		if(s.emps[index].getName().equals(name)) {
			result += "\nPoints awarded: " + points;
		}
		else {
			result += "\nPoints awarded: 0";
		}
		return result;	
	}
	//Method that returns true or false after checking for the correct name at the index in the array. If the method returns true,
	//	points will be awarded
	public static boolean arrayPass(Store s, int index, String name) {
		if(s.emps[index].getName().equals(name)) {
			return true;
		}
		else {
			return false;
		}
	}	
	//Method that checks if an index in the array is empty and displays true or false and whether or not points are awarded 
	public static String emptyCheck(Store s, int i, double points) {
		String result = "\n\nIs index " + i + " empty? " + (s.emps[i] == null) ;
		result += "\nPoints awarded: " + points;
		return result;
	}
	//Method that returns true or false after checking for an empty space. points are awarded if it returns true
	public static boolean isEmpty(Store s, int i) {
		if( s.emps[i] == null) {
			return true;
		}
		else {
			return false;
		}
	}
	//Method that will print the employee array as evidence of changes made
	public static String printArray(Store s) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nEmployee Array");
		for(int i = 0; i < s.numEmps; i++) {
			result.append(String.format("\nEmployee " + i + ": " + s.emps[i].getName() + ", "));			
		}
		return result.toString();
	}
	//Method that adds the final score to the test report
	public static String finishReport() {
		String result = "Total Points: " + Double.toString(score) + "/9.0";
		return result;
	}
	
	//Simple test: 
	//	1. Check to make sure that an empty store object is created
	//	2. Populate the store with generic emps and check the results
	//	3. Check the emp array
	public static String testOne() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest One: Simple Test\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Check for a new store with no employees, hours or pay.\n");
		result.append(resultChecker(s, 0, 0.0, 0.0, .5));
		
		if( resultPass(s, 0, 0.0, 0.0)){
			points += .5;
		}
		result.append("\n\nNext, add 5 employees and check results");
		generateEmps(5, s);
		result.append(resultChecker(s, 5, 200.0, 2000.0, 0.0));
		result.append(printArray(s));
		result.append(arrayChecker(s, 4, "emp4", .5));
		
		if( resultPass(s, 5, 200.0, 2000.0) && arrayPass(s, 4, "emp4")){
			points += .5;
		}
		if( points != 1.0) {
			result.append("\n\nTest One Failed");
			report.append("\nTest One Failed");
		}
		else {
			result.append("\n\nTest One Passed");
			report.append("\nTest One Passed");
		}
		score += points;
		return result.toString();
	}
	
	//Add test:
	//	1. Generate a store and populate it with employees, print results
	//	2. Create new emps and add them using the addEmp method
	//	3. Check the results and the array
	//  4. Fill the hours in for the new emps and check results
	public static String testTwo() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Two: Add Employees\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 5 employees. Check results\n");
		generateEmps(5, s);
		result.append(resultChecker(s, 5, 200.0, 2000.0, 0.0));
		result.append("\n\nNext, add some new employees and check results");
		Employee emp = new Employee("Allen", 10.0);
		s.addEmp(emp);
		Employee emp1 = new Employee("Billy", 10.0);
		s.addEmp(emp1);
		result.append(resultChecker(s, 7, 200.0, 2000.0, 0.25));
		if( resultPass(s, 7, 200.0, 2000.0)){
			points += 0.25;
		}
		result.append(printArray(s));
		result.append(arrayChecker(s, 5, "Allen", 0.125));
		if(arrayPass(s, 5, "Allen")) {
			points += 0.125;
		}
		result.append(arrayChecker(s, 6, "Billy", 0.125));
		if( arrayPass(s, 6, "Billy")){
			points += 0.125;
		}
		fillHours(emp);
		fillHours(emp1);
		result.append("\n\nThe fill hours method has been called for the new employees.");
		result.append(resultChecker(s, 7, 280.0, 2800.0, 0.5));
		if( resultPass(s, 7, 280.0, 2800.0)){
			points += 0.5;
		}
		if( points != 1.0) {
			result.append("\n\nTest Two Failed");
			report.append("\nTest Two Failed");
		}
		else {
			result.append("\n\nTest Two Passed");
			report.append("\nTest Two Passed");
		}
		score += points;
		return result.toString();
	}	
	
	//Full Array, Add test
	//	1. Generate a store with a full (20) emp array, print results
	//  2. create a new emp and pass it to the addEmp method
	//	3. print the array and check the results. Ensure that no new employee has been added
	public static String testThree() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Three: Full Array, Add Employee\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 20 employees. Check results\n");
		generateEmps(20, s);
		result.append(printArray(s));
		result.append(resultChecker(s, 20, 800.0, 8000.0, 0.33));
		if( resultPass(s, 20, 800.0, 8000.0)){
			points += 0.33;
		}
		result.append("\n\nNext, add a new employee and check results");
		Employee emp = new Employee("Allen", 10.0);
		s.addEmp(emp);
		result.append("\nThe addEmp method has been called");
		result.append(printArray(s));
		result.append(resultChecker(s, 20, 800.0, 8000.0, 0.33));
		if( resultPass(s, 20, 800.0, 8000.0)){
			points += 0.33;
		}
		result.append(arrayChecker(s, 19, "emp19", 0.34));
		if( arrayPass(s, 19, "emp19")){
			points += 0.34;
		}
		if( points != 1.0) {
			result.append("\n\nTest Three Failed");
			report.append("\nTest Three Failed");
		}
		else {
			result.append("\n\nTest Three Passed");
			report.append("\nTest Three Passed");
		}
		score += points;
		
		return result.toString();
	}
	
	//Remove Employee Test
	//	1. Generate a new store with 5 emps, print results, print array
	//	2. call removeEmployee method, print array
	//	3. check to make sure that the employee has been removed
	//	4. check to make sure the employees beyond that removed index shift to fill the empty space
	//	5. check the previous final index to make sure that emp there has been removed
	public static String testFour() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Four: Remove Employees\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 5 employees. Check results\n");
		generateEmps(5, s);
		result.append(printArray(s));
		result.append(resultChecker(s, 5, 200.0, 2000.0, 0.0));
		result.append("\n\nNext, remove the employee in index 2. \nCheck to make sure the emps shift to fill the empty space.");
		s.removeEmployee(2);
		result.append("\n\nThe removeEmployee method had been called.");
		result.append(printArray(s));
		result.append(emptyCheck(s, 4, 0.33));
		if( isEmpty(s, 4)) {
			points += 0.33;
		}
		result.append(resultChecker(s, 4, 160.0, 1600.0, 0.33));
		if( resultPass(s, 4, 160.0, 1600.0)){
			points += 0.33;
		}
		result.append(arrayChecker(s, 2, "emp3", 0.34));
		if( arrayPass(s, 2, "emp3")){
			points += 0.34;
		}
		if( points != 1.0) {
			result.append("\n\nTest Four Failed");
			report.append("\nTest Four Failed");
		}
		else {
			result.append("\n\nTest Four Passed");
			report.append("\nTest Four Passed");
		}
		score += points;
		
		return result.toString();
	}
	
	//Remove 2 Employees at the same index Test
		//	1. Generate a new store with 10 emps, print results, print array
		//	2. call removeEmployee method twice at the same index, print array
		//	3. check to make sure that the employees have been removed
		//	4. check to make sure the employees beyond that removed index shift to fill the empty space
		//	5. check the previous final indexes to make sure that emps there have been removed
	public static String testFive() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Five: Remove Multiple Employees from the Same Index\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 10 employees. Check results\n");
		generateEmps(10, s);
		result.append(resultChecker(s, 10, 400.0, 4000.0, 0.33));
		if( resultPass(s, 10, 400.0, 4000.0)){
			points += 0.33;
		}
		result.append("\n\nNext, remove the employee in index 3. \nCheck to make sure the emps shift to fill the empty space.");
		s.removeEmployee(3);
		result.append("\n\nThe removeEmployee method had been called.");
		result.append(printArray(s));
		result.append(emptyCheck(s, 9, 0.11));
		if( isEmpty(s, 9)) {
			points += 0.11;
		}
		result.append(resultChecker(s, 9, 360.0, 3600.0, 0.11));
		if( resultPass(s, 9, 360.0, 3600.0)){
			points += 0.11;
		}
		result.append(arrayChecker(s, 3, "emp4", 0.12));
		if( arrayPass(s, 3, "emp4")){
			points += 0.12;
		}
		result.append("\n\nNext, remove the employee in index 3. \nCheck to make sure the emps shift to fill the empty space.");
		s.removeEmployee(3);
		result.append("\n\nThe removeEmployee method had been called.");
		result.append(printArray(s));
		result.append(emptyCheck(s, 8, 0.11));
		if( isEmpty(s, 8)) {
			points += 0.11;
		}
		result.append(resultChecker(s, 8, 320.0, 3200.0, 0.11));
		if( resultPass(s, 8, 320.0, 3200.0)){
			points += 0.11;
		}
		result.append(arrayChecker(s, 3, "emp5", 0.11));
		if( arrayPass(s, 3, "emp5")){
			points += 0.11;
		}
		if( points != 1.0) {
			result.append("\n\nTest Five Failed");
			report.append("\nTest Five Failed");
		}
		else {
			result.append("\n\nTest Five Passed");
			report.append("\nTest Five Passed");
		}
		score += points;
		
		
		return result.toString();
	}
	
	//Remove Employees at different indexes Test
			//	1. Generate a new store with 10 emps, print results, print array
			//	2. call removeEmployee method twice at different indexes, print array
			//	3. check to make sure that the employees have been removed
			//	4. check to make sure the employees beyond that removed index shift to fill the empty space
			//	5. check the previous final indexes to make sure that emps there have been removed
	public static String testSix() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Six: Remove Multiple Employees from a different Index\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 10 employees. Check results\n");
		generateEmps(10, s);
		result.append(resultChecker(s, 10, 400.0, 4000.0, 0.33));
		if( resultPass(s, 10, 400.0, 4000.0)){
			points += 0.33;
		}
		result.append("\n\nNext, remove the employee in index 7. \nCheck to make sure the emps shift to fill the empty space.");
		s.removeEmployee(7);
		result.append("\n\nThe removeEmployee method had been called.");
		result.append(printArray(s));
		result.append(emptyCheck(s, 9, 0.11));
		if( isEmpty(s, 9)) {
			points += 0.11;
		}
		result.append(resultChecker(s, 9, 360.0, 3600.0, 0.11));
		if( resultPass(s, 9, 360.0, 3600.0)){
			points += 0.11;
		}
		result.append(arrayChecker(s, 7, "emp8", 0.12));
		if( arrayPass(s, 7, "emp8")){
			points += 0.12;
		}
		result.append("\n\nNext, remove the employee in index 6. \nCheck to make sure the emps shift to fill the empty space.");
		s.removeEmployee(6);
		result.append("\n\nThe removeEmployee method had been called.");
		result.append(printArray(s));
		result.append(emptyCheck(s, 8, 0.11));
		if( isEmpty(s, 8)) {
			points += 0.11;
		}
		result.append(resultChecker(s, 8, 320.0, 3200.0, 0.11));
		if( resultPass(s, 8, 320.0, 3200.0)){
			points += 0.11;
		}
		result.append(arrayChecker(s, 6, "emp8", 0.11));
		if( arrayPass(s, 6, "emp8")){
			points += 0.11;
		}
		if( points != 1.0) {
			result.append("\n\nTest Six Failed");
			report.append("\nTest Six Failed");
		}
		else {
			result.append("\n\nTest Six Passed");
			report.append("\nTest Six Passed");
		}
		score += points;
		
		
		return result.toString();
	}
	
	//Remove all emps from the last index test
		//1. Create a new store object and stock it with 20 generic employee objects
		//2. Start at the last filled index and remove all employees
		//3. Check results
	public static String testSeven() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Seven: Remove all Employees from last Index to first\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 20 employees. Check results\n");
		generateEmps(20, s);
		result.append(resultChecker(s, 20, 800.0, 8000.0, 0.0));
		if( resultPass(s, 20, 800.0, 8000.0)){
			points += 0.0;
		}
		result.append("\n\nNext, remove all employees starting at the last index. \nCheck to make sure each space is empty.");
		
		for(int i = s.numEmps - 1; i >= 0; i--) {
			s.removeEmployee(i);
			result.append("\n\nThe removeEmployee method had been called.");
			result.append(emptyCheck(s, i, 0.025));
			if( isEmpty(s, i)) {
				points += 0.025;
			}
		}
		result.append(resultChecker(s, 0, 0.0, 0.0, 0.5));
		if( resultPass(s, 0, 0.0, 0.0)){
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Seven Failed");
			report.append("\nTest Seven Failed");
		}
		else {
			result.append("\n\nTest Seven Passed");
			report.append("\nTest Seven Passed");
		}
		score += points;
		
		
		return result.toString();
	}
	
	//Remove all emps from the first index test
			//1. Create a new store object and stock it with 20 generic employee objects
			//2. Start at the first filled and remove all employees
			//3. Check results
	public static String testEight() {
		Store s = new Store();
		double points = 0.0;
		String name = "";
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Eight: Remove all Employees from the first index\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 20 employees. Check results\n");
		generateEmps(20, s);
		int x = s.numEmps;
		result.append(resultChecker(s, 20, 800.0, 8000.0, 0.0));
		result.append("\n\nNext, remove all employees by removing the employee at the first index. \nCheck to make sure the employees shift to fill the space.");
		
		for( int i = 0; i < x-1; i++) {			
			s.removeEmployee(0);
			name = "emp" + Integer.toString(i + 1);
			result.append("\n\nThe removeEmployee method had been called.");
			result.append(arrayChecker(s, 0, name, .025));
			
			if( arrayPass(s, 0, name)){
				points += .025;
			}
		}
		s.removeEmployee(0);
		result.append("\nThe removeEmployee method has been called for the last employee");
		result.append(emptyCheck(s, 0, 0.025));
		if( isEmpty(s, 0)) {
			points += 0.025;
		}
		result.append(resultChecker(s, 0, 0.0, 0.0, 0.5));
		if( resultPass(s, 0, 0.0, 0.0)){
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Eight Failed");
			report.append("\nTest Eight Failed");
		}
		else {
			result.append("\n\nTest Eight Passed");
			report.append("\nTest Eight Passed");
		}
		score += points;
		
		
		return result.toString();
	}
	
	//Remove Employee at invalid index test
	//	1.	Create a store object and populate it with 10 generic employees
	//	2.  call the removeEmployee method at an index beyond the last filled space
	//	3.	print the array and check results
	public static String testNine() {
		Store s = new Store();
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Nine: Remove Employee beyond the last Index\n");
		result.append("---------------------\n");
		result.append("Create a Store object. Stock it with 10 employees. Check results\n");
		generateEmps(10, s);
		result.append(printArray(s));
		result.append(resultChecker(s, 10, 400.0, 4000.0, 0.5));
		if( resultPass(s, 10, 400.0, 4000.0)){
			points += 0.5;
		}
		result.append("\n\nNext, remove the employee in index 13. \nCheck to make sure that nothing has changed.");
		s.removeEmployee(13);
		result.append("\n\nThe removeEmployee method had been called.");
		result.append(printArray(s));
		result.append(resultChecker(s, 10, 400.0, 4000.0, 0.5));
		if( resultPass(s, 10, 400.0, 4000.0)){
			points += 0.5;
		}
		if( points != 1.0) {
			result.append("\n\nTest Nine Failed");
			report.append("\nTest Nine Failed");
		}
		else {
			result.append("\n\nTest Nine Passed");
			report.append("\nTest Nine Passed");
		}
		score += points;
		
		
		return result.toString();
	}
}
//
//public static String test() {
//	double points = 0.0;
//	StringBuilder result = new StringBuilder();
//	
//	result.append("\n\nTest \n");
//	result.append("---------------------\n");
//	result.append("Create ");
//	
//	
//	
//	if( points != 1.0) {
//		result.append("\n\nTest  Failed: " + points + "/1.0");
//		report.append("\nTest  Failed: " + points + "/1.0");
//	}
//	else {
//		result.append("\n\nTest  Passed: " + points + "/1.0");
//		report.append("\nTest  Passed: " + points + "/1.0");
//	}
//	score += points;
//	return result.toString();
//}
//
//public static void generate(int i, Warehouse w) {
//	String name = "";
//	for( int j = 0; j < i; j++) {
//		name = "" + Integer.toString(j);
//		Item i = new Item(name, 5.0);
//}
//	

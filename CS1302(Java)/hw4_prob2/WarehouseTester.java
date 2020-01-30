package prob2;

public class WarehouseTester {
	
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
			
		report.append("\n\n" + finishReport());
		System.out.print(report.toString());

	}
	
	public static void generateItems(int i, Warehouse w) {
		String name = "";
		for( int j = 0; j < i; j++) {
			name = "item" + Integer.toString(j);
			Item item = new Item(name, 5.0);
			w.items.add(item);
		}
	}
	
	public static void generateRefrigeratedItems(int i, Warehouse w) {
		String name = "";
		for( int j = 0; j < i; j++) {
			name = "refItem" + Integer.toString(j);
			RefrigeratedItem item = new RefrigeratedItem(name, 1.0, 20.0);
			w.items.add(item);
		}
	}
	
	public static String resultChecker(Warehouse w, int numItems, double cost, double refCost, double points) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nResults Check:");
		result.append("\n--------------");
		result.append(String.format("\nTotal Items: %d, Total Cost: %.2f, Fridge Cost: $%,.2f", w.items.size(), w.getTotalCost(), w.getTotalCostRefrigerated()));
		result.append("\nNum Items expected: " + numItems + ", " + (w.items.size() == numItems));
		result.append("\nTotal Cost expected: " + cost + ", " + (w.getTotalCost() == cost));
		result.append("\nFridge Cost expected: " + refCost + ", " + (w.getTotalCostRefrigerated() == refCost));
		
		if( w.items.size() == numItems && w.getTotalCost() == cost && w.getTotalCostRefrigerated() == refCost) {
			result.append("\nPoints awarded: " + points);
		}
		else {
			result.append("\nPoints awarded: 0");
		}
		return result.toString();
	}
	
	public static boolean resultPass(Warehouse w, int numItems, double cost, double refCost) {
		if( w.items.size() == numItems && w.getTotalCost() == cost && w.getTotalCostRefrigerated() == refCost) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String getChecker(String s, Warehouse w, String name, double points) {
		StringBuilder result = new StringBuilder();
		
		result.append(s + "\n");
		result.append(w.getItem(name).toString());
		
		if(s.equals(w.getItem(name).toString())) {
			result.append("\nPoints awarded: " + points);
		}
		else {
			result.append("\nPoints awarded: 0");
		}
		return result.toString();
	}
	public static boolean getPass(String s, Warehouse w, String name) {
		
		if(s.equals(w.getItem(name).toString())) {
			return true;
		}
		else
			return false;
	}
	
	public static String nullChecker(Warehouse w, String name, double points) {
		StringBuilder result = new StringBuilder();
		
		if( w.getItem(name) == null) {
			result.append("\n\ngetItem returned null. " + points + " points added.");
		}
		else
			result.append("Test failed");
		return result.toString();
	}
	
	public static boolean nullPass(Warehouse w, String name) {
		if( w.getItem(name) == null) {
			return true;
		}
		else 
			return false;
	}
	
	public static String finishReport() {
		String result = "Total Points: " + Double.toString(score) + "/4.0";
		return result;
	}
	
	public static String testOne() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest One: Simple Test\n");
		result.append("---------------------\n");
		result.append("Create a Warehouse object and stock it with 5 items and 5 refrigerated"
					+ " items. Check results");
		
		Warehouse w = new Warehouse();
		result.append("\n\nThe warehouse has been created");
		result.append(resultChecker(w, 0, 0.0, 0.0, 0.0));
		
		generateItems(5, w);
		result.append("\n\nFive generic items have been added to the warehouse.");
		result.append(resultChecker(w, 5, 50.0, 0.0, 0.5));
		if( resultPass(w, 5, 50.0, 0.0)){
			points += .5;
		}
		
		generateRefrigeratedItems(5, w);
		result.append("\n\nFive generic refrigerated items have been added to the warehouse.");
		result.append(resultChecker(w, 10, 100.0, 50.0, 0.5));
		if( resultPass(w, 10, 100.0, 50.0)){
			points += .5;
		}
				
		if( points != 1.0) {
			result.append("\n\nTest One Failed: " + points + "/1.0");
			report.append("\nTest One Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest One Passed: " + points + "/1.0");
			report.append("\nTest One Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testTwo() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		String str = "name=food, cost=$10.00, weight=5.00";
		
		result.append("\n\nTest Two: Get Item Check\n");
		result.append("---------------------\n");
		result.append("Create a warehouse object and stock it with items. Call the get item method.");
		
		Warehouse w = new Warehouse();
		result.append("\n\nThe warehouse has been created");
		result.append(resultChecker(w, 0, 0.0, 0.0, 0.0));
		
		generateItems(5, w);
		result.append("\n\nFive generic items have been added to the warehouse.");
		result.append(resultChecker(w, 5, 50.0, 0.0, 0.0));
		
		Item item = new Item("food", 5.0);
		w.addItem(item);
		
		result.append(getChecker(str, w, "food", 1.0));
		if( getPass(str, w, "food")){
			points += 1.0;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Two Failed: " + points + "/1.0");
			report.append("\nTest Two Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Two Passed: " + points + "/1.0");
			report.append("\nTest Two Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testThree() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Three: Get Item check/nonexistent item.\n");
		result.append("---------------------\n");
		result.append("Create a warehouse object and stock it with items. Call the get item method.");
		
		Warehouse w = new Warehouse();
		result.append("\n\nThe warehouse has been created");
		result.append(resultChecker(w, 0, 0.0, 0.0, 0.0));
		
		generateItems(5, w);
		result.append("\n\nFive generic items have been added to the warehouse.");
		result.append(resultChecker(w, 5, 50.0, 0.0, 0.0));
		
		result.append(nullChecker(w, "stuff", 1.0));
		if( nullPass(w, "stuff")){
			points += 1.0;
		}
		
		
		if( points != 1.0) {
			result.append("\n\nTest Three Failed: " + points + "/1.0");
			report.append("\nTest Three Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Three Passed: " + points + "/1.0");
			report.append("\nTest Three Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testFour() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Four: Remove Item.\n");
		result.append("---------------------\n");
		result.append("Create Create a warehouse and stock it. Remove an item and check results.");
		
		Warehouse w = new Warehouse();
		result.append("\n\nThe warehouse has been created");
		result.append(resultChecker(w, 0, 0.0, 0.0, 0.0));
		
		Item item = new Item("food", 5.0);
		w.addItem(item);
		result.append("\n\nItem \"food\" has been added to items");
		
		generateItems(5, w);
		result.append("\n\nFive generic items have been added to the warehouse.");
		result.append(resultChecker(w, 6, 60.0, 0.0, 0.0));
		
		result.append(w.toString());
		
		w.removeItem(w.getItem("food"));
		result.append("\n\n\"food\" item has been removed\n");
		
		result.append("\n" + w.toString());
		
		result.append(resultChecker(w, 5, 50.0, 0.0, 1.0));
		if( resultPass(w, 5, 50.0, 0.0)){
			points += 1.0;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Four Failed: " + points + "/1.0");
			report.append("\nTest Four Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Four Passed: " + points + "/1.0");
			report.append("\nTest Four Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testFive() {
		StringBuilder result = new StringBuilder();

		result.append("\n\nTest Five: Get Refrigerated Items\n");
		result.append("---------------------\n");
		result.append("Create a warehouse and stock it with items and refitems. Check the getRefrigeratedItems method");
		
		Warehouse w = new Warehouse();
		result.append("\n\nThe warehouse has been created");
		result.append(resultChecker(w, 0, 0.0, 0.0, 0.0));
		
		generateItems(5, w);
		result.append("\n\nFive generic items have been added to the warehouse.");
		result.append(resultChecker(w, 5, 50.0, 0.0, 0.0));

		generateRefrigeratedItems(3, w);
		result.append("\n\nThree generic refrigerated items have been added to the warehouse.");
		result.append(resultChecker(w, 8, 80.0, 30.0, 0.0));
		
		result.append("\n" + w.getRefrigeratedItems().toString());

		return result.toString();
	}
}

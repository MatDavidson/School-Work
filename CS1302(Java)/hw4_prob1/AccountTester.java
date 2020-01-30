package prob1;

public class AccountTester {

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
		System.out.print(testTen());
		
		report.append("\n\n" + finishReport());
		System.out.print(report.toString());
	}
	
	public static String resultChecker(CheckingAccount c, int id, double bal, boolean lowBal, int withdrawals, double points) {
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nResults Check:");
		result.append("\n--------------\n");
		result.append(c.toString());
		result.append("\nAccount expected: " + id + ", " + (c.getId() == id));
		result.append("\nBalance expected: " + bal + ", " + (c.getBalance() == bal));
		result.append("\nLow Balance expected: " + lowBal + ", " + (c.isLowBalance() == lowBal));
		result.append("\nWithdrawals expected: " + withdrawals + ", " + (c.getNumWithdrawals() == withdrawals));
		
		if( c.id == id && c.balance == bal && c.isLowBalance == lowBal && c.numWithdrawals == withdrawals) {
			result.append("\nPoints awarded: " + points);
		}
		else {
			result.append("\nPoints awarded: 0");
		}
		return result.toString();
	}
	
	public static boolean resultPass(CheckingAccount c, int id, double bal, boolean lowBal, int withdrawals) {
		if( c.id == id && c.balance == bal && c.isLowBalance == lowBal && c.numWithdrawals == withdrawals) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String finishReport() {
		String result = "Total Points: " + Double.toString(score) + "/10.0";
		return result;
	}
	
	public static String testOne() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest One: Simple Test\n");
		result.append("---------------------\n");
		result.append("Create a generic Checking Account object and a generic Gold Checking Account "
					+ "object and check their values.");
		
		CheckingAccount ca = new CheckingAccount(101, 100.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 100.0, false, 0, 0.5));
		
		if( resultPass(ca, 101, 100.0, false, 0)) {
			points += 0.5;
		}
		
		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1000.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 1000.0, false, 0, 0.5));
		
		if( resultPass(gca, 201, 1000.0, false, 0)) {
			points += 0.5;
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
		
		result.append("\n\nTest Two: Deposit Test\n");
		result.append("---------------------\n");
		result.append("Create a CA object and a GCA object and test the deposit method for each.");
		
		CheckingAccount ca = new CheckingAccount(101, 100.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 100.0, false, 0, 0.0));

		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1000.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 1000.0, false, 0, 0.0));

		result.append("\n\nTest the deposit method.");
		
		ca.deposit(100.0);
		result.append("\n\nThe deposit method has been called for CA");
		result.append(resultChecker(ca, 101, 200.0, false, 0, 0.5));		
		if( resultPass(ca, 101, 200.0, false, 0)) {
			points += 0.5;
		}
		
		gca.deposit(100.0);
		result.append("\n\nThe deposit method has been called for GCA");
		result.append(resultChecker(gca, 201, 1100.0, false, 0, 0.5));
		if( resultPass(gca, 201, 1100.0, false, 0)) {
			points += 0.5;
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
		
		result.append("\n\nTest Three: Withdarawal Test\n");
		result.append("---------------------\n");
		result.append("Create a CA and GCA and test the withdraw method for both.");
		
		CheckingAccount ca = new CheckingAccount(101, 100.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 100.0, false, 0, 0.0));

		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1000.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 1000.0, false, 0, 0.0));

		result.append("\n\nTest the withdrawal method.");
		
		ca.withdrawal(20.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		result.append(resultChecker(ca, 101, 80.0, true, 1, 0.5));
		if( resultPass(ca, 101, 80.0, true, 1)) {
			points += 0.5;
		}
		
		gca.withdrawal(20.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		result.append(resultChecker(gca, 201, 980.0, true, 1, 0.5));
		if( resultPass(gca, 201, 980.0, true, 1)) {
			points += 0.5;
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
		
		result.append("\n\nTest Four: Accounts Created with Low Balance.\n");
		result.append("---------------------\n");
		result.append("Create a CA and GCA with low balances. Check Truth value of isLowBalance.");
		
		CheckingAccount ca = new CheckingAccount(101, 90.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 90.0, true, 0, 0.5));
		if( resultPass(ca, 101, 90.0, true, 0)) {
			points += 0.5;
		}

		GoldCheckingAccount gca = new GoldCheckingAccount(201, 900.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 900.0, true, 0, 0.5));
		if( resultPass(gca, 201, 900.0, true, 0)) {
			points += 0.5;
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
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Five: isLowBalance after a deposit.\n");
		result.append("---------------------\n");
		result.append("Create accounts with a low balance. Deposit to higher than low balance and check.");
		
		CheckingAccount ca = new CheckingAccount(101, 90.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 90.0, true, 0, 0.0));
		
		GoldCheckingAccount gca = new GoldCheckingAccount(201, 900.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 900.0, true, 0, 0.0));
		
		result.append("\n\nDeposit money so the balance is higher than the low bal condition.");
		
		ca.deposit(100.0);
		result.append("\n\nThe deposit method has been called for CA");
		result.append(resultChecker(ca, 101, 190.0, true, 0, 0.5));		
		if( resultPass(ca, 101, 190.0, true, 0)) {
			points += 0.5;
		}
		
		gca.deposit(150.0);
		result.append("\n\nThe deposit method has been called for GCA");
		result.append(resultChecker(gca, 201, 1050.0, true, 0, 0.5));
		if( resultPass(gca, 201, 1050.0, true, 0)) {
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Five Failed: " + points + "/1.0");
			report.append("\nTest Five Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Five Passed: " + points + "/1.0");
			report.append("\nTest Five Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testSix() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Six: Account Overdrafts\n");
		result.append("---------------------\n");
		result.append("Create account objects. Overdraw the accounts and check results.");
		
		CheckingAccount ca = new CheckingAccount(101, 100.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 100.0, false, 0, 0.0));

		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1000.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 1000.0, false, 0, 0.0));

		result.append("\n\nOverdraw the accounts.");
		
		ca.withdrawal(120.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		result.append(resultChecker(ca, 101, -40.0, true, 1, 0.5));
		if( resultPass(ca, 101, -40.0, true, 1)) {
			points += 0.5;
		}
		
		gca.withdrawal(1020.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		result.append(resultChecker(gca, 201, -40.0, true, 1, 0.5));
		if( resultPass(gca, 201, -40.0, true, 1)) {
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Six Failed: " + points + "/1.0");
			report.append("\nTest Six Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Six Passed: " + points + "/1.0");
			report.append("\nTest Six Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testSeven() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Seven: More than three withdrawals\n");
		result.append("---------------------\n");
		result.append("Create accounts. Call the withdrawal method three times. "
					+ "Call it one more time to check the withdrawal fee.");
		
		CheckingAccount ca = new CheckingAccount(101, 100.0);
		result.append("\n\nThe Checking Account has been created.");
		result.append(resultChecker(ca, 101, 100.0, false, 0, 0.0));
		
		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1000.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		result.append(resultChecker(gca, 201, 1000.0, false, 0, 0.0));
		
		result.append("\n\nCall the withdrawal method four times for each account");
		
		ca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		ca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		ca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		ca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for CA.");

		result.append(resultChecker(ca, 101, 58.0, true, 4, 0.5));
		if( resultPass(ca, 101, 58.0, true, 4)) {
			points += 0.5;
		}
		
		gca.withdrawal(25.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		gca.withdrawal(25.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		gca.withdrawal(25.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		gca.withdrawal(25.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		
		result.append(resultChecker(gca, 201, 900.0, true, 4, 0.5));
		if( resultPass(gca, 201, 900.0, true, 4)) {
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Seven Failed: " + points + "/1.0");
			report.append("\nTest Seven Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Seven Passed: " + points + "/1.0");
			report.append("\nTest Seven Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testEight() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Eight: End of Month.\n");
		result.append("---------------------\n");
		result.append("Create Account Objects. Call the Withdrawal method, "
					+ "then call the End of the Month method.");
		
		result.append("\n\nThe Checking Account has been created.");
		CheckingAccount ca = new CheckingAccount(101, 120.0);
		
		ca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		
		result.append(resultChecker(ca, 101, 110.0, false, 1, 0.0));
		if( resultPass(ca, 101, 110.0, false, 1)) {
			points += 0.0;
		}
		
		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1020.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		
		gca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		result.append(resultChecker(gca, 201, 1010.0, false, 1, 0.0));
		if( resultPass(gca, 201, 1010.0, false, 1)) {
			points += 0.0;
		}
		
		result.append("\n\nCall the endOfMonth method for both.");
		
		ca.endOfMonth();
		result.append("The endOfMonth method has been called for CA");
		result.append(resultChecker(ca, 101, 110.0, false, 0, 0.0));
		if( resultPass(ca, 101, 110.0, false, 0)) {
			points += 0.5;
		}
		
		gca.endOfMonth();
		result.append("The endOfMonth method has been called for GCA");
		result.append(resultChecker(gca, 201, 1020.10, false, 0, 0.5));
		if( resultPass(gca, 201, 1020.10, false, 0)) {
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Eight Failed: " + points + "/1.0");
			report.append("\nTest Eight Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Eight Passed: " + points + "/1.0");
			report.append("\nTest Eight Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
	
	public static String testNine() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Nine: End of Month w/lowBalance.\n");
		result.append("---------------------\n");
		result.append("Create Account Objects. Withdraw enough money for isLowBalance to be true, "
					+ "then call the End of the Month method.");
		
		CheckingAccount ca = new CheckingAccount(101, 100.0);
		result.append("\n\nThe Checking Account has been created.");
		
		ca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for CA.");
		
		result.append(resultChecker(ca, 101, 90.0, true, 1, 0.0));
		if( resultPass(ca, 101, 90.0, true, 1)) {
			points += 0.0;
		}
		
		GoldCheckingAccount gca = new GoldCheckingAccount(201, 1000.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		
		gca.withdrawal(10.0);
		result.append("\n\nThe withdrawal method has been called for GCA.");
		result.append(resultChecker(gca, 201, 990.0, true, 1, 0.0));
		if( resultPass(gca, 201, 990.0, true, 1)) {
			points += 0.0;
		}
		
		result.append("\n\nCall the endOfMonth method for both.");
		
		ca.endOfMonth();
		result.append("The endOfMonth method has been called for CA");
		result.append(resultChecker(ca, 101, 80.0, true, 0, 0.5));
		if( resultPass(ca, 101, 80.0, true, 0)) {
			points += 0.5;
		}
		
		gca.endOfMonth();
		result.append("The endOfMonth method has been called for GCA");
		result.append(resultChecker(gca, 201, 965.0, true, 0, 0.5));
		if( resultPass(gca, 201, 965.0, true, 0)) {
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Nine Failed: " + points + "/1.0");
			report.append("\nTest Nine Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Nine Passed: " + points + "/1.0");
			report.append("\nTest Nine Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}

	public static String testTen() {
		double points = 0.0;
		StringBuilder result = new StringBuilder();
		
		result.append("\n\nTest Ten: End of the Month w/$0 balance.\n");
		result.append("---------------------\n");
		result.append("Create account objects with a balance of zero and call endOfMonth.");
		
		CheckingAccount ca = new CheckingAccount(101, 0.0);
		result.append("\n\nThe Checking Account has been created.");
		GoldCheckingAccount gca = new GoldCheckingAccount(201, 0.0);
		result.append("\n\nThe Gold Checking Account has been created.");
		
		result.append("\n\nCall the endOfMonth method for both.");
		
		ca.endOfMonth();
		result.append("\n\nThe endOfMonth method has been called for CA");
		result.append(resultChecker(ca, 101, -30.0, true, 0, 0.5));
		if( resultPass(ca, 101, -30.0, true, 0)) {
			points += 0.5;
		}

		gca.endOfMonth();
		result.append("\n\nThe endOfMonth method has been called for GCA");
		result.append(resultChecker(gca, 201, -45.0, true, 0, 0.5));
		if( resultPass(gca, 201, -45.0, true, 0)) {
			points += 0.5;
		}
		
		if( points != 1.0) {
			result.append("\n\nTest Ten Failed: " + points + "/1.0");
			report.append("\nTest Ten Failed: " + points + "/1.0");
		}
		else {
			result.append("\n\nTest Ten Passed: " + points + "/1.0");
			report.append("\nTest Ten Passed: " + points + "/1.0");
		}
		score += points;
		return result.toString();
	}
}
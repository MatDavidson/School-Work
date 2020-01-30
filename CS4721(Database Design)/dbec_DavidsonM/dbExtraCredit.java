//package dbExtraCredit;  **in a package on my machine
//dbExtraCredit assignment,
//Mat Davidson

import java.util.*;
import java.sql.*;
import java.io.*;

public class dbExtraCredit {
	static ResultSet r;
	static String query;
	static Statement stmt;
	static Connection conn;
	
	public static void main (String args []) throws SQLException, ClassNotFoundException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println ("Could not load the driver");
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Enter DB user name: ");
		String usrname = input.next();
		System.out.println("Enter passwor: ");
		String pswd = input.next();

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba_mat?useSSL=false&useUnicode=true&serverTimezone=UTC", usrname, pswd);
		System.out.println("DB connected..");
		
		//prob1() finds the tallest player by iterating over the result list of all players
		//	and extracting the heights. It then sends the height in feet and inches to a helper
		//	method which returns the height in inches. Then, it compares that height to the tallest
		//	height thus far while keeping up with the tallest player's ilkid. Each time a new 
		//	tallest player is found, it prints the ilkid and height. Finally, it prints the name 
		// 	and height in feet and inches of the tallest player. My output returned Manute Bol, 7'6".
		//
		//I tried using a single query which is included in my sql file. I think my logic wasn't right
		//	because it returned nothing. 
		prob1();
		
		//With prob2() I was able to write a single sql statement to generate the result. It is printed
		//	in the console.
		prob2();
		
		//Similar to prob2(), I was able to write a single sql statement to get the results.
		prob3();
		System.out.println("*********************************************");
		System.out.println("Output complete.");

		stmt.close();
		conn.close();
		input.close();
	}
	private static String query1() {
		String s = "SELECT ilkid, h_feet, h_inches FROM players";	
		return s;
	}
	private static String query1a(String ilkid) {
		String s = "SELECT * FROM players WHERE ilkid = \"" + ilkid + "\"";	
		return s;
	}
	private static double getHeight(int feet, double inches) {
		double d = (double)(feet*12) + inches;	
		return d;
	}
	private static void prob1() throws SQLException {
		stmt = conn.createStatement();
		query = query1();
		System.out.println("*********************************************");
		System.out.println("Finding the tallest player...\n");
		r = stmt.executeQuery(query);
		double max = 0.0;
		String player = "";
		System.out.println("Query used to generate players list: " + query + "/n");
		while (r.next ()) {
			String ilkid = r.getString(1);
			int feet = r.getInt(2);
			double inches = r.getDouble(3);
			double height = getHeight(feet, inches);
			if(height > max) {
				max = height;
				player = ilkid;
				System.out.println("New \"Tallest\" Player: " + ilkid + ", Height(in): " + height);
			}			
		}
		query = query1a(player);
		System.out.println("\nQuery used to print info: " + query);
		r = stmt.executeQuery(query);
		while (r.next ()) {
			System.out.println("\nThe tallest player is " + r.getString(2) + " " + r.getString(3) + " at " + r.getInt(7) + " feet " + r.getDouble(8) + " inches.");
		}
	}
	private static String query2() {
		String s = "SELECT * FROM coaches_career WHERE sesason_win = (SELECT MAX(sesason_win) FROM coaches_career)";
		
		return s;
	}
	private static void prob2() throws SQLException {
		stmt = conn.createStatement();
		query = query2();
		System.out.println("*********************************************");
		System.out.println("Finding the coach with the most season wins...\n");
		System.out.println("Query used to print info: " + query + "\n");
		r = stmt.executeQuery(query);
		while (r.next ()) {
			System.out.println(r.getString(1) + ": " + r.getString(2) + " " + r.getString(3) + " with " + r.getInt(4) + " total season wins.");
		}

	}
	private static String query3() {
		String s = "SELECT * FROM teams WHERE location = \"San Diego\"";
		
		return s;
	}
	private static void prob3() throws SQLException {
		stmt = conn.createStatement();
		query = query3();
		System.out.println("*********************************************");
		System.out.println("Finding the teams from San Diego...\n");
		System.out.println("Query used to print info: " + query + "\n");
		r = stmt.executeQuery(query);
		while (r.next ()) {
			System.out.println(r.getString(1) + ": " + r.getString(3));
		}
	}
}

package prob2;

import java.util.ArrayList;

public class MartianTester {

	public static void main(String[] args) throws CloneNotSupportedException {
		// Test 0 – Create MartianManager and create some red and green martians
		//  to be used in tests that follow.
		StringBuilder result = new StringBuilder();
		MartianManager mm = new MartianManager();
		result.append("\nTest 0 – Create MartianManager and create some red and green martians "
					+ "\nto be used in tests that follow.");
		result.append("\n\nA new MartianManager has been created");
		generateRedMartians(5, mm);
		generateGreenMartians(5, mm);
		result.append("\nThe MartianManager has been stocked with some Martians");
		
		result.append(testOne(mm));
		result.append(testTwo(mm));
		result.append(testThree(mm));
		result.append(testFour(mm));
		result.append(testFive(mm));
		result.append(testSix(mm));
		result.append(testSeven(mm));
		result.append(testEight(mm));
		result.append(testNine(mm));
		result.append(testTen(mm));
		result.append(testEleven(mm));
		result.append(testTwelve(mm));
		result.append(testThirteen(mm));
		result.append(testFourteen(mm));
		result.append(testFifteen(mm));
		
		
		System.out.print(result);
	}
	
	public static void generateRedMartians(int num, MartianManager mm) {
		int id = 100;
		for(int i = 0; i < num; i++) {
			id++;
			RedMartian m = new RedMartian(id);
			mm.addMartian(m);
		}
	}

	public static void generateGreenMartians(int num, MartianManager mm) {
		int id = 200;
		for(int i = 0; i < num; i++) {
			id++;
			GreenMartian m = new GreenMartian(id);
			mm.addMartian(m);
		}
	}
	
	public static String testOne(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 1 - Martian.toString()");
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		return result.toString();
	}
	
	public static String testTwo(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 2 - Martian.equals()");
		GreenMartian gm = new GreenMartian(101);
		result.append("\n\nA new GreenMartian has been created with the ID 101.\n"
					+ "--Call the equal method on the RedMartian with ID 101, result should be true.");
		result.append("\nDoes GreenMartian 101 equal RedMartian 101? " + gm.equals(mm.getMartianWithId(101)));
		result.append("\n\n--Call the equals method for some other Martian. Result should be false.");
		result.append("\nDoes GreenMartian 101 equal GreenMartian 201? " + gm.equals(mm.getMartianWithId(201)));

		return result.toString();
	}
	
	public static String testThree(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		RedMartian testMartian = (RedMartian)mm.getMartianWithId(103);
		result.append("\n\nTest 3 - Martian.compareTo()");
		result.append("\n--Call the compareTo method multiple times for a Martian."
					+ "\n--RedMartian 103 will be compared to 101, itself and 105."
					+ "\n--Results should be: 1, 0 and -1 respectively.");
		result.append("\nRedMartian 103 compared to RedMartian 101: " + testMartian.compareTo(mm.getMartianWithId(101)));
		result.append("\nRedMartian 103 compared to RedMartian 103: " + testMartian.compareTo(mm.getMartianWithId(103)));
		result.append("\nRedMartian 103 compared to RedMartian 105: " + testMartian.compareTo(mm.getMartianWithId(105)));

		return result.toString();
	}
	
	public static String testFour(MartianManager mm) throws CloneNotSupportedException {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 4 - Martian.clone()");
		result.append("\n--Call the clone method for a Martian. Check that the new Martian"
					+ "has the same data as the original Martian but does not occupy the"
					+ "same space in memory");
		GreenMartian gmClone = (GreenMartian)mm.getMartianWithId(203).clone();
		result.append("\n\n--A clone of GreenMartian 203 has been created. Call the equals "
					+ "method. Result should be true.");
		result.append("\nDoes gmClone equal GreenMartian 203? " + gmClone.equals(mm.getMartianWithId(203)));
		result.append("\n\n--Use \"==\" to determine if the clone reference is pointing to "
					+ "\nthe location of GreenMartian 203 in memory. Should be false.");
		result.append("\nDoes gmClone point to GreenMartian 203? " + (gmClone == mm.getMartianWithId(203)));
		return result.toString();
	}
	
	public static String testFive(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 5 - MartianManager.addMartian()");
		result.append("\n--Create some new Martians and add them to the Martians list."
					+ "\nCheck to that any GreenMartians were added to Teleporters");
		RedMartian red1 = new RedMartian(111);
		mm.addMartian(red1);
		result.append("\nA new RedMartian has been added: " + red1.toString());
		RedMartian red2 = new RedMartian(121);
		mm.addMartian(red2);
		result.append("\nA new RedMartian has been added: " + red2.toString());
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		
		GreenMartian green1 = new GreenMartian(211);
		mm.addMartian(green1);
		result.append("\nA new GreenMartian has been added: " + green1.toString());
		GreenMartian green2 = new GreenMartian(221);
		mm.addMartian(green2);
		result.append("\nA new GreenMartian has been added: " + green2.toString());
		
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		
		RedMartian red3 = new RedMartian(108);
		mm.addMartian(red3);
		result.append("\nA new RedMartian has been added: " + red3.toString());
		RedMartian red4 = new RedMartian(119);
		mm.addMartian(red4);
		result.append("\nA new RedMartian has been added: " + red4.toString());
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		
		GreenMartian green3 = new GreenMartian(207);
		mm.addMartian(green3);
		result.append("\nA new GreenMartian has been added: " + green3.toString());
		GreenMartian green4 = new GreenMartian(218);
		mm.addMartian(green4);
		result.append("\nA new GreenMartian has been added: " + green4.toString());
		
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}

		return result.toString();
	}
	
	public static String testSix(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 6 - MartianManager.groupSpeak()");
		result.append(mm.groupSpeak());
		return result.toString();
	}
	
	public static String testSeven(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 7 - MartianManager.groupTeleport()");
		result.append(mm.groupTeleport("Washington D.C."));

		return result.toString();
	}
	
	public static String testEight(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 8 - MartianManager.getMartianAt()");
		result.append("\n--Pass several indeces to the getMartianAt method "
					+ "\nIndex 1 should return RedMartian 102 "
					+ "\nIndex 20 should return null "
					+ "\nIndex -5 should return null ");
		result.append("\n\nIndex 1  contains: " + mm.getMartianAt(1));
		result.append("\n\nIndex 20 contains: " + mm.getMartianAt(20));
		result.append("\n\nIndex -5 contains: " + mm.getMartianAt(-5));

		return result.toString();
	}
	
	public static String testNine(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 9 - MartianManager.getTeleporterAt()");
		result.append("\n--Pass several indeces to the getMartianAt method "
					+ "\nIndex 4 should return GreenMartian 205 "
					+ "\nIndex 10 should return null "
					+ "\nIndex -3 should return null ");
		result.append("\n\nIndex 4  contains: " + mm.getTeleporterAt(4));
		result.append("\n\nIndex 10 contains: " + mm.getTeleporterAt(10));
		result.append("\n\nIndex -3 contains: " + mm.getTeleporterAt(-3));

		return result.toString();
	}
	
	public static String testTen(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 10 - MartianManager.getMartianWithId()");
		result.append("\n--Call the getMartianWithId method. "
					+ "\nId 204 should return GreenMartian 204"
					+ "\nId 119 should return RedMartian 119"
					+ "\nId 300 should return null");
		result.append("\nGet Martian with id 204: " + mm.getMartianWithId(204));
		result.append("\nGet Martian with id 119: " + mm.getMartianWithId(119));
		result.append("\nGet Martian with id 300: " + mm.getMartianWithId(300));
		return result.toString();
	}
		
	public static String testEleven(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 11 - MartianManager.getMartianClosestTo()");
		result.append("\n--Call the getMartianClosestTo method with several ids"
					+ "\nId 215 should return GreenMartian 218"
					+ "\nId 125 should return RedMartian 121"
					+ "\nId 99 should return RedMartian 101");
		result.append("\nMartian closest to 215: " + mm.getMartianClosestTo(215));
		result.append("\nMartian closest to 125: " + mm.getMartianClosestTo(125));
		result.append("\nMartian closest to 99: " + mm.getMartianClosestTo(99));
		return result.toString();
	}	

	public static String testTwelve(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 12 - MartianManager.removeMartian()");
		result.append("\n--Display the list of Martians and Teleporters"
					+ "\nCall the removeMartian method for some martians "
					+ "\nDisplay the lists again");
		result.append("\n\nThe martians list contains " + mm.getNumMartians() + " Martians:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains " + mm.getNumTeleporters() + " Teleporters:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		
		result.append("\nRemove Martian 101: " + mm.removeMartian(101));
		result.append("\nRemove Martian 201: " + mm.removeMartian(201));
		result.append("\nRemove Martian 218: " + mm.removeMartian(218));
		result.append("\n\nThe martians list contains " + mm.getNumMartians() + " Martians:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains " + mm.getNumTeleporters() + " Teleporters:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		return result.toString();
	}
	
	public static String testThirteen(MartianManager mm) throws CloneNotSupportedException {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 13 - MartianManager.sortedMartians()");
		result.append("\n--Display the Martians list"
					+ "\nCall the sortedMartians method and display the result");
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}

		ArrayList<Martian> sortedMartians = (ArrayList<Martian>)mm.sortedMartians();
		result.append("\n\nThe sorted martians list contains:");
		for(Martian m: sortedMartians) {
			result.append("\n" + m.toString());
		}
				
		return result.toString();
	}
	
	public static String testFourteen(MartianManager mm) {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest MartianManager.obliterateTeleporters()");
		result.append("\n--Display the Martians and Teleporters lists"
					+ "\nCall the obliterateTeleporters method and display lists");
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		result.append("\n\nCalling the obliterateTeleporters method...");
		mm.obliterateTeleporters();
		result.append("\n\nThe martians list contains:");
		for(Martian m: mm.martians) {
			result.append("\n" + m.toString());
		}
		result.append("\n\nThe teleporters list contains:");
		for(Teleporter t: mm.teleporters) {
			result.append("\n" + t.toString());
		}
		
		return result.toString();
	}
	
	public static String testFifteen(MartianManager mm) throws CloneNotSupportedException {
		StringBuilder result = new StringBuilder();
		result.append("\n\nTest 15 - MartianManager.clone()");
		result.append("\n--Add some GreenMartians back to the manager"
					+ "\nCall the MartianManager clone method"
					+ "\nCheck the memory location of the Martian lists"
					+ "\nCheck that each martian is a clone with the equals");
		result.append("\n\nAdding GreenMartians");
		generateGreenMartians(5, mm);
		result.append("\n\nCalling clone method...");
		MartianManager mmClone = (MartianManager)mm.clone();
		result.append("\nUse \"==\" to determine if the Martians lists occupy"
					+ "\nthe same place in memory. Should be false");
		result.append("\nIs the mmClone list the same as the mm list? " + (mmClone.martians == mm.martians));
		result.append("\n\nUse \"==\" to check the memory location of the Martians "
					+ "\nin each list. Should be false for each");
		for(int i = 0; i < mm.martians.size(); i++) {
			result.append("\nIs The martian in index " + i + " of mmClone the same as mm? " + (mmClone.martians.get(i) == mm.martians.get(i)));
		}	
		result.append("\n\nUse the equals method to show that each the martians are cloned");
		for(int i = 0; i < mm.martians.size(); i++) {
			result.append("\nIs The martian in index " + i + " of mmClone equal to the corresponding mm index? " + mmClone.martians.get(i).equals(mm.martians.get(i)));
		}
		return result.toString();
	}
}


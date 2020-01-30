package prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GenericMartianManagerDriver {

	public static void main(String[] args) {
		GenericMartianManager<GreenMartian> mm = new GenericMartianManager<>();

		RedMartian r1 = new RedMartian(8);
		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian g4 = new GreenMartian(4);
		GreenMartian lime1 = new LimeMartian(2);
		LimeMartian lime2 = new LimeMartian(48);
		Martian mart1 = new GreenMartian(91);

		// Test 1 - MartianManager.addMartian()
		System.out.println("***Test 1 - MartianManager.addMartian()");
		System.out.print(mm.addMartian(g1) + ", ");
		System.out.print(mm.addMartian(g2) + ", ");
		System.out.print(mm.addMartian(g3) + ", ");
		System.out.print(mm.addMartian(g4) + ", ");
// Uncomment and should not compile.
//		System.out.print(mm.addMartian(mart1) + ", ");
//		System.out.print(mm.addMartian(r1) + ", ");
		System.out.print(mm.addMartian(lime2) + ", ");
		System.out.println(mm.addMartian(lime1));

		// Test 2 - MartianManager.getMartian()
		System.out.println("\n***Test 2 - MartianManager.getMartian()");
		Martian m = new GreenMartian(16);
// Uncomment and should not compile.
//		GreenMartian m2 = mm.getMartian(m);
		GreenMartian gm1 = new GreenMartian(11);
		gm1.setVolume(999);
// Uncomment and should not compile.
//		LimeMartian m0 = mm.getMartian(gm1);
		GreenMartian gm2 = mm.getMartian(gm1);
		System.out.println( gm2 );
		System.out.println( mm.getMartian(new GreenMartian(888)) );

		// Test 3 - MartianManager.mergeMartians()
		System.out.println("\n***Test 3 - MartianManager.mergeMartians()");
		ArrayList<RedMartian> redMarts = new ArrayList<>();
		redMarts.add(r1);
// Uncomment and should not compile.
//		mm.mergeMartians(redMarts);
		ArrayList<LimeMartian> limeMarts = new ArrayList<>();
		LimeMartian lime3 = new LimeMartian(33,20);
		limeMarts.add(lime3);
		mm.mergeMartians(limeMarts);
		System.out.println( "Num=" + mm.getNumMartians() + ", " + mm.getMartian(lime3) );


		// Test 4 - MartianManager.removeMartian()
		System.out.println("\n***Test 4 - MartianManager.removeMartian()");
		Martian m4 = new RedMartian(39,2);
// Uncomment and should not compile.
//		System.out.print( mm.removeMartian(m4) + ", " );
		LimeMartian m5 = new LimeMartian(10,2);
		System.out.print( mm.removeMartian(m5) + ", " );
		LimeMartian m6 = new LimeMartian(111,2);
		System.out.print( mm.removeMartian(m6) + ", " );

		test5();
	}

	public static void test5() {
		// Test 5 - getSmallest() static generic method
		System.out.println("\n\n***Test 5 - getSmallest()");
		GreenMartian g1 = new GreenMartian(11);
		GreenMartian g2 = new GreenMartian(4);
		GreenMartian g3 = new GreenMartian(10);
		GreenMartian lime1 = new LimeMartian(2);
		LimeMartian lime2 = new LimeMartian(48);
		ArrayList<Martian> marts1 = new ArrayList<>(Arrays.asList(g1,g2,g3,lime1,lime2));
// Uncomment and should not compile.
//		ArrayList<GreenMartian> smallGreens = getSmallest(marts1,3);
		ArrayList<GreenMartian> greens = new ArrayList<>(Arrays.asList(g1,g2,g3,lime1,lime2));

// Uncomment and should work correctly
		ArrayList<GreenMartian> smallGreens = getSmallest(greens,3);
		System.out.println(smallGreens);
	}

	public static <E extends Martian> ArrayList<E> getSmallest(ArrayList<? extends Martian> marts, int num) {
		ArrayList<E> martians = new ArrayList<E>();
		ArrayList<E> clone = (ArrayList<E>) marts.clone();
		
		for(int i = num; i > 1; i--) {
			clone.remove(getSmallestIndex(clone));
		}
		
		int id = clone.get(getSmallestIndex(clone)).getId();
		
		for(Martian m: marts) {
			if(m.getId() <= id)
				martians.add((E)m);
		}
		
		return martians;
	}
	
	public static <E extends Martian> int getSmallestIndex(ArrayList<? extends Martian> martians) {
		int i = 0;
		int smallest = 1000;
		
		for(Martian m: martians) {
			if(m.getId() < smallest) {
				smallest = m.getId();
				i = martians.indexOf(m);
			}
		}
		
		return i;
	}
}

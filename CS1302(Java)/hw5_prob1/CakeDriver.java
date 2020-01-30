package prob1;

public class CakeDriver {

	public static void main(String[] args) {
		Cake classicYellow = new ClassicYellowCake("Duncan Hines Classic Yellow Cake Mix");
		System.out.println("Classic Yellow Cake");
		System.out.println("-------------------");
		System.out.println(classicYellow.makeCake());

		Cake highAltitudeClassicYellow = new HighAltitudeClassicYellowCake("Duncan Hines Classic Yellow Cake Mix");
		System.out.println("\nHigh Altitude Classic Yellow Cake");
		System.out.println("-----------------------------------");
		System.out.println(highAltitudeClassicYellow.makeCake());

		Cake organicVanilla = new OrganicCake("Organic Vanilla Cake Mix");
		System.out.println("\nOrganic Vanilla Cake");
		System.out.println("----------------------");
		System.out.println(organicVanilla.makeCake());

	}
}

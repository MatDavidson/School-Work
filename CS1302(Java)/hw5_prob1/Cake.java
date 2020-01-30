package prob1;

public abstract class Cake {
	private String cakeMix;

	public Cake(String cakeMix) {
		this.cakeMix = cakeMix;
	}

	public final String makeCake() {
		String cake = "";
		cake += blend();
		cake += pour();
		cake += bake();
		return cake;
	}

	public String bake() {
		return "Bake at 350 degrees F 30 minutes";
	}

	public String getCakeMix() {
		return cakeMix;
	}

	private final String blend() {
		String cake = "Blend:(";
		cake += getCakeMix() + ", ";
		cake += getLiquid() + ", ";
		cake += getOil() + ", ";
		cake += getEggs() + ")\n";
		return cake;
	}

	public String pour() {
		return "Pour mix into pan\n";
	}
	
	public abstract String getLiquid();
	
	public abstract String getOil();
	
	public abstract String getEggs();
}

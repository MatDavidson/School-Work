package prob1;

public class HighAltitudeClassicYellowCake extends ClassicYellowCake{
	
	public HighAltitudeClassicYellowCake(String cakeMix) {
		super(cakeMix);
	}
	
	@Override
	public String bake() {
		return "Bake at 375 degrees F 26 minutes";
	}
	
	@Override
	public String getCakeMix() {
		return super.getCakeMix() + " + 2 tbs flour";
	}
}

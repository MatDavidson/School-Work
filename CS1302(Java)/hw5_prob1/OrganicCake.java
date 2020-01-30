package prob1;

public class OrganicCake extends Cake{

	public OrganicCake(String cakeMix) {
		super(cakeMix);
	}
	
	public String getLiquid() {
		return "1 1/4 cup milk";
	}
	
	public String getOil() {
		return "1/2 cup canola oil";
	}
	
	public String getEggs() {
		return "2 large eggs";
	}
}

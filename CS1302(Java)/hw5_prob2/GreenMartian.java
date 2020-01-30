package prob2;

public class GreenMartian extends Martian implements Teleporter {
	
	//Green Martian constructor 
	public GreenMartian(int id) {
		super(id);
	}

	//returns a string in the format, "id=xxx, Grobldy Grock"
	@Override
	public String speak() {
		String s = String.format("id=%d, Grobldy Grock", getId());
		return s;
	}
	
	//Returns a string in the format: “id=xxx teleporting to dest”
	@Override
	public String teleport(String dest) {
		String s = String.format("id=%d teleporting to %s", getId(), dest);
		return s;
	}
		
	//Returns a in the format: “Green Martian - id=xxx, vol=yyy”
	@Override
	public String toString() {
		String s = String.format("Green Martian - id=%d, vol=%d", getId(), getVolume());
		return s;
	}

}

package prob2;

public class RedMartian extends Martian{
	
	//Red Martian constructor
	public RedMartian(int id) {
		super(id);
	}
	
	//returns a string in the format, "id=xxx, Rubldy Rock"
	@Override
	public String speak() {
		String s = String.format("id=%d, Rubldy Rock", getId());
		return s;
	}
	
	//Returns a in the format: “Red Martian - id=xxx, vol=yyy”
	@Override
	public String toString() {
		String s = String.format("Red Martian - id=%d, vol=%d", getId(), getVolume());
		return s;
	}
	
}

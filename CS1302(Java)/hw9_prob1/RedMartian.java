package prob1;

public class RedMartian extends Martian {

	public RedMartian(int id, int volume) {
		super(id,volume);
	}

	public RedMartian(int id) {
		super(id);
	}

	public String speak() {
		return getId() + " Rubldy Rock";
	}

	@Override
	public String toString() {
		return "Red " + super.toString();
	}
}

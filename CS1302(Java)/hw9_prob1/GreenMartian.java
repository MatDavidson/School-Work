package prob1;

public class GreenMartian extends Martian {

	public GreenMartian(int id, int volume) {
		super(id,volume);
	}

	public GreenMartian(int id) {
		super(id);
	}

	@Override
	public String speak() {
		return getId() + " Grubldy Grock";
	}

	@Override
	public String toString() {
		return "Green " + super.toString();
	}

}

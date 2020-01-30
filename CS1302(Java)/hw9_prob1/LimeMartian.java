package prob1;

public class LimeMartian extends GreenMartian {

	public LimeMartian(int id, int volume) {
		super(id,volume);
	}

	public LimeMartian(int id) {
		super(id);
	}

	@Override
	public String speak() {
		return getId() + " Limey Lock";
	}

	@Override
	public String toString() {
		return "Lime " + super.toString();
	}

}

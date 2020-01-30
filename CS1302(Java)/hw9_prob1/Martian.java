package prob1;

/**
 * The Martian class is an abstract class that models Martains of various subtypes. Martians are defined by
 * four properties: (a) and "id" which is the unique way to identify a Martian, (b) a "volume", and two boolean properties:
 * (c) hasESP and (D) isVegetariant. 3 constructors are supplied for creating Martians in various ways. Martian overrides
 * equals to so that two Martians are considered equal if they have the same ID. Comparable is implemented so that
 * Martians can be sorted on their ID property. Martians are also Cloneable so that a default (deep) clone is returned.
 * Martian defines an abstract speak property which subclasses implement.
 * @author dgibson
 *
 */
public abstract class Martian implements Cloneable, Comparable<Martian> {

	private int id;
	private int volume;
	protected boolean hasESP;
	protected boolean isVegetarian;

	public Martian(int id, int volume) {
		this.id = id;
		this.volume = volume;
	}

	public Martian(int id) {
		this(id,1);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object o) {
		Martian m = (Martian)o;
		return this.id == m.getId();
	}

	public int getId() {
		return id;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public abstract String speak();

	public String toString() {
		String msg = String.format("Martian id=%d vol=%d",  id, volume);
		return msg;
	}

	@Override
	public int compareTo(Martian m) {
		return this.getId() - m.getId() ;
	}
}

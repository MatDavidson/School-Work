package prob2;

public abstract class Martian implements Cloneable, Comparable<Martian> {

	private int id;
	private int volume;
	
	//Creates a Martian object with an id and sets volume to 1
	public Martian(int id) {
		this.id = id;
		this.setVolume(1);
	}
	
	//Creates and returns a clone of the martian object
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//Implements Java's compareTo method so that Martians are compared based on 
	//	their Id's which results in the usual ascending sorted order.
	public int compareTo(Martian m) {
		int diff = this.id - m.getId();
		
		if( diff < 0) {
			return -1;
		}
		else if( diff > 0) {
			return 1;
		}
		else
			return 0;
	}
	
	//Two martians are equal if their id's are equal, regardless of whether they 
	//	green or red 
	@Override
	public boolean equals(Object o) {
		return this.getId() == ((Martian)o).getId();
	}
	
	//Returns the id
	public int getId() {
		return id;
	}
	
	//Returns the volume
	public int getVolume() {
		return volume;
	}
	
	//Sets the volume to level
	public void setVolume(int level) {
		volume = level;
	}
	
	//Abstract speak method to be inherited by sub-classes
	public abstract String speak();
	
	//Returns a string in this format, "id=xxx, vol=yyy"
	@Override
	public String toString() {
		String s = String.format("id=%d, vol=%d", id, volume);
		return s;
	}
}

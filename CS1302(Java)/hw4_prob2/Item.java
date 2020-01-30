package prob2;

public class Item {

	protected String name = "";
	protected double weight = 0.0;
	
	public Item() {
		this("Noname", 0.0);
	}

	public Item(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public double cost() {
		return weight * 2;
	}
	
	public boolean equals(Object o) {
		Item i;
		if( o instanceof Item) {
			i = (Item)o;
			return (this.getName() == i.getName());
		}
		else return false;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String toString() {
		String result = String.format("name=%s, cost=$%,.2f, weight=%.2f", name, cost(), weight);
		return result;
	}
}
